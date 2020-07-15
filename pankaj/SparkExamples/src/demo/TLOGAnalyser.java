package demo;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.*;
import com.mongodb.spark.MongoSpark;
import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.explode;

public final class TLOGAnalyser {
	static {
		System.setProperty("hadoop.home.dir", "D:\\personal_dev\\spark\\hadoop");
	}
	public static void main(final String[] args) {

		try(SparkSession sparkSession = SparkSession.builder().master("local").appName("TLOGAnalyser")
				.config("spark.mongodb.input.uri", "mongodb://127.0.0.1/txnDB.transactions")
				.config("spark.mongodb.output.uri", "mongodb://127.0.0.1/txnDB.plus").getOrCreate();
				JavaSparkContext jsc = new JavaSparkContext(sparkSession.sparkContext());) 	{

			Dataset<Row> transactionDS = MongoSpark.load(jsc).toDF();
			transactionDS.printSchema();
			transactionDS.show();

			analyseItems(sparkSession, transactionDS);
			analysePayments(sparkSession, transactionDS);
			analyseOutdoorTransactions(sparkSession, transactionDS);
			analyseLoyaltyTktLvl(sparkSession,transactionDS);
			analyseLoyaltyLineItem(sparkSession,transactionDS);
			analyseTillTransactions(sparkSession, transactionDS);

		} finally {
			SparkSession.clearActiveSession();
		}

	}

	private static void analyseOutdoorTransactions(SparkSession sparkSession, Dataset<Row> transactionDS) {
		transactionDS.createOrReplaceTempView("transactions");
		sparkSession.sql("select sum(trans.trValue.trTotWTax) from transactions where trans.trHeader.trTickNum.trSeq > 9000000").show();		
		Dataset<Row> outdoorTransactions = sparkSession.sql("select * from transactions where trans.trHeader.trTickNum.trSeq > 9000000");		
		Dataset<Row> trLines = outdoorTransactions.select(col("trans.trHeader.trUniqueSN"), col("trans.type"), col("trans.trValue"),col("trans.trHeader.trTickNum.trSeq"),
				explode(col("trans.trLines.trLine")).as("trLines"));
		trLines.createOrReplaceTempView("itemlines");
		trLines.show();
		trLines.printSchema();
		Dataset<Row> outdoorMerchandiseSales = sparkSession.sql("SELECT sum(abs(trLines.trlLineTot)) FROM itemlines where trLines.type = \"plu\"");
		outdoorMerchandiseSales.show();
		Dataset<Row> outdoorFuelSales = sparkSession.sql("SELECT sum(abs(trLines.trlLineTot)) FROM itemlines where trLines.type != \"plu\"");
		outdoorFuelSales.show();

	}

	private static void analysePayments(SparkSession sparkSession, Dataset<Row> transactionDS) {
		Dataset<Row> trPayLines = transactionDS.select(col("trans.trHeader.trUniqueSN"), col("trans.type"),
				(explode(col("trans.trPaylines.trPayline")).as("trPaylines"))).filter(col("trPaylines.trpPayCode.value").notEqual("Change"));
		trPayLines.createOrReplaceTempView("paymentlines");
		trPayLines.show();
		trPayLines.printSchema();
		Dataset<Row> mopCounts = sparkSession
				.sql("SELECT trPayLines.trpPayCode.value, count(trPaylines) FROM paymentlines Group By trPayLines.trpPayCode.value ");
		mopCounts.show();
		Dataset<Row> creditCount = sparkSession
				.sql("SELECT count(trPaylines) FROM paymentlines where trPaylines.trpPaycode.value = \"CREDIT\"");
		creditCount.show();
		Dataset<Row> refundTrans = transactionDS.filter(col("trans.type").contains("refund"))
				.select("trans.trHeader.trUniqueSN");
		refundTrans.createOrReplaceTempView("refundtransactions");
		refundTrans.show();
		Dataset<Row> refundCount = sparkSession.sql("SELECT count(trUniqueSN) From refundtransactions");
		refundCount.show();
		Dataset<Row> cashCount = sparkSession.sql(
				"SELECT count(trPaylines) FROM paymentlines where trPaylines.trpPaycode.value = \"CASH\" AND trPaylines.trpAmt > 0");
		cashCount.show();
	}

	private static void analyseLoyaltyTktLvl(SparkSession sparkSession, Dataset<Row> transactionDS) {
		Dataset<Row> trLines = transactionDS.select(col("trans.trHeader.trUniqueSN"), col("trans.type"), col("trans.trValue"),
				explode(col("trans.trLoyalty.trLoyaltyProgram")).as("trLoyaltyLines"),col("trans.trHeader.trTickNum.trSeq"));
		trLines.createOrReplaceTempView("itemlines");
		trLines.show();
		trLines.printSchema();
		Dataset<Row> program1Count = sparkSession
				.sql("SELECT count(trLoyaltyLines.programID) FROM itemlines where trLoyaltyLines.programID = \"PROGRAM01\"");
		program1Count.show();
		Dataset<Row> program1DiscAmount = sparkSession
				.sql("SELECT sum(trLoyaltyLines.trloAutoDisc) FROM itemlines where trLoyaltyLines.programID = \"PROGRAM01\"");
		program1DiscAmount.show();
		Dataset<Row> program2Count = sparkSession
				.sql("SELECT count(trLoyaltyLines.programID) FROM itemlines where trLoyaltyLines.programID = \"PROGRAM02\"");
		program2Count.show();
		Dataset<Row> program2DiscAmount = sparkSession
				.sql("SELECT sum(trLoyaltyLines.trloAutoDisc) FROM itemlines where trLoyaltyLines.programID = \"PROGRAM02\"");
		program2DiscAmount.show();
	
	}
	
	private static void analyseLoyaltyLineItem(SparkSession sparkSession, Dataset<Row> transactionDS) {
		Dataset<Row> trLines = transactionDS.select(col("trans.trHeader.trUniqueSN"), col("trans.type"), col("trans.trValue"),
				explode(col("trans.trLines.trLine")).as("trLines"),col("trans.trHeader.trTickNum.trSeq"));
		trLines.createOrReplaceTempView("itemlines");
		trLines.show();
		trLines.printSchema();
		Dataset<Row> trLoyLines = trLines.select(explode(col("trLines.trloLnItemDisc")).as("trLoyLines"));
		trLoyLines.createOrReplaceTempView("loyaltyItemlines");
		trLoyLines.show();
		trLoyLines.printSchema();		
		Dataset<Row> program1Count = sparkSession
				.sql("SELECT count(trLoyLines.programID) FROM loyaltyItemlines where trLoyLines.programID = \"PROGRAM01\"");
		program1Count.show();
		Dataset<Row> program1DiscAmount = sparkSession
				.sql("SELECT sum(trLoyLines.discAmt) FROM loyaltyItemlines where trLoyLines.programID = \"PROGRAM01\"");
		program1DiscAmount.show();
		Dataset<Row> program2Count = sparkSession
				.sql("SELECT count(trLoyLines.programID) FROM loyaltyItemlines where trLoyLines.programID = \"PROGRAM02\"");
		program2Count.show();
		Dataset<Row> program2DiscAmount = sparkSession
				.sql("SELECT sum(trLoyLines.discAmt) FROM loyaltyItemlines where trLoyLines.programID = \"PROGRAM02\"");
		program2DiscAmount.show();
	
	}
	
	private static void analyseItems(SparkSession sparkSession, Dataset<Row> transactionDS) {
		Dataset<Row> trLines = transactionDS.select(col("trans.trHeader.trUniqueSN"), col("trans.type"), col("trans.trValue"),
				col("trans.trHeader.trTickNum.trSeq"),explode(col("trans.trLines.trLine")).as("trLines"));
		trLines.createOrReplaceTempView("itemlines");
		trLines.show();
		trLines.printSchema();
		Dataset<Row> depCount = sparkSession
				.sql("SELECT sum(abs(trLines.trlLineTot)) FROM itemlines where trLines.trlDept.number = 1");
		depCount.show();
		Dataset<Row> catCount = sparkSession
				.sql("SELECT sum(abs(trLines.trlLineTot)) FROM itemlines where trLines.trlCat.number = 9994");
		catCount.show();	
	}
	
	
	private static void analyseTillTransactions(SparkSession sparkSession, Dataset<Row> transactionDS) {
		Dataset<Row> payInTxns = transactionDS.filter(col("trans.type").isin("payin","safeloan")).select(col("trans.trHeader.cashier"),col("trans.trHeader.trTickNum.trSeq"), col("trans.type"),
				(explode(col("trans.trPaylines.trPayline")).as("trPaylines")));
		payInTxns.createOrReplaceTempView("payins");
		payInTxns.show();
		payInTxns.printSchema();
		Dataset<Row> payInAmt = sparkSession.sql("SELECT sum(abs(trPaylines.trpAmt)) FROM payins");
		payInAmt.show();
		
		Dataset<Row> payOutTxns = transactionDS.filter(col("trans.type").isin("payout","safedrop")).select(col("trans.trHeader.cashier"),col("trans.trHeader.trTickNum.trSeq"), col("trans.type"),
				(explode(col("trans.trPaylines.trPayline")).as("trPaylines")));
		payOutTxns.createOrReplaceTempView("payouts");
		payOutTxns.show();
		payOutTxns.printSchema();
		Dataset<Row> payOutAmt = sparkSession.sql("SELECT sum(abs(trPaylines.trpAmt)) FROM payouts");
		payOutAmt.show();
	}

	/**
	 * Generate SQL to select columns as flat.
	 */
	private static String flattenSchema(StructType schema, String prefix) {
		final StringBuilder selectSQLQuery = new StringBuilder();

		for (StructField field : schema.fields()) {
			final String fieldName = field.name();

			if (fieldName.startsWith("@")) {
				continue;
			}

			String colName = prefix == null ? fieldName : (prefix + "." + fieldName);
			String colNameTarget = colName.replace(".", "_");

			if (field.dataType().getClass().equals(StructType.class)) {
				selectSQLQuery.append(flattenSchema((StructType) field.dataType(), colName));
			} else {
				selectSQLQuery.append(colName);
				selectSQLQuery.append(" as ");
				selectSQLQuery.append(colNameTarget);
			}

			selectSQLQuery.append(",");
		}

		if (selectSQLQuery.length() > 0) {
			selectSQLQuery.deleteCharAt(selectSQLQuery.length() - 1);
		}

		return selectSQLQuery.toString();
	}
}
