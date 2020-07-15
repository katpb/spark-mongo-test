package com.verifone.ptc;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.*;
import com.mongodb.spark.MongoSpark;
import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.explode;


public final class TxnDBReaderAndWriter {

	public static void main(final String[] args) throws InterruptedException {


	SparkSession sparkSession = SparkSession.builder()
			      .master("local")
			      .appName("MongoSparkConnectorTest")
			      .config("spark.mongodb.input.uri", "mongodb://127.0.0.1/txnDB.transactions")
			      .config("spark.mongodb.output.uri", "mongodb://127.0.0.1/txnDB.plus")
			      .getOrCreate();
		
		
		JavaSparkContext jsc = new JavaSparkContext(sparkSession.sparkContext());

		//JavaMongoRDD<Document> rdd = MongoSpark.load(jsc);
		
		Dataset<Row> implicitDS = MongoSpark.load(jsc).toDF();

		
//		 final String querySelectSQL = flattenSchema(implicitDS.schema(), null);
		
	    implicitDS.printSchema();
	    implicitDS.show();
	    
//	    implicitDS.select("trans.trHeader.trUniqueSN").show();
	    
	    Dataset<Row>trLines = implicitDS.select(col("trans.trHeader.trUniqueSN"), col("trans.type"),explode(col("trans.trLines.trLine")).as("trLines"));
	    trLines.createOrReplaceTempView("itemlines");
	    trLines.show();
	    trLines.printSchema();
	    Dataset<Row> depCount = sparkSession.sql("SELECT sum(abs(trLines.trlLineTot)) FROM itemlines where trLines.trlDept.number = 1");		
	    depCount.show();
	    Dataset<Row> catCount = sparkSession.sql("SELECT sum(abs(trLines.trlLineTot)) FROM itemlines where trLines.trlCat.number = 9994");		
	    catCount.show();
	    
	    Dataset<Row>trPayLines = implicitDS.select(col("trans.trHeader.trUniqueSN"), col("trans.type"),(explode(col("trans.trPaylines.trPayline")).as("trPaylines")));
	    trPayLines.createOrReplaceTempView("paymentlines");
	    trPayLines.show();
	    trPayLines.printSchema();
	    Dataset<Row> creditCount = sparkSession.sql("SELECT count(trPaylines) FROM paymentlines where trPaylines.trpPaycode.value = \"CREDIT\"");		
	    creditCount.show();
//	    Dataset<Row> creditRefundCount = sparkSession.sql("SELECT count(trPaylines) FROM paymentLines where  trans.type = \"refund network sale\"");		
//	    creditRefundCount.show();
//	    Dataset<Row> creditRefundCount = sparkSession.sql("SELECT paymentlines.trans.trHeader.trUniqueSN FROM paymentlines where paymentlines.trans.type = \"sale\"");		
//	    creditRefundCount.show();
	    Dataset<Row> refundTrans =  implicitDS.filter(col("trans.type").contains("refund")).select("trans.trHeader.trUniqueSN");
	    refundTrans.createOrReplaceTempView("refundtransactions");
	    refundTrans.show();
	    Dataset<Row> refundCount = sparkSession.sql("SELECT count(trUniqueSN) From refundtransactions");
	    refundCount.show();
	    Dataset<Row> cashCount = sparkSession.sql("SELECT count(trPaylines) FROM paymentlines where trPaylines.trpPaycode.value = \"CASH\" AND trPaylines.trpAmt > 0");		
	    cashCount.show();
	    
//	    implicitDS.createOrReplaceTempView("transactions");
//      implicitDS.filter(col("trans.trValue.trTotWTax").between("0.01", "2.00")).select("trans.trHeader.trUniqueSN").show();
//	    Dataset<Row> trLines = sparkSession.sql("SELECT trans.trHeader.trUniqueSN, trans.trLines.trLine[].trlDept.value From transactions Where trans.trLines.trLine[].trlDept.number = 2");
//	  trLines.show(false);
//	    Dataset<Row> sum = sparkSession.sql("SELECT sum(trans.trValue.trTotWTax) FROM transactions where trans.type = \"sale\"");
//	    Dataset<Row> dep2 = sparkSession.sql("SELECT " + querySelectSQL + " FROM transactions");
//	    dep2.createOrReplaceTempView("dep2");
//	    dep2.show();
//	    Dataset<Row> dep2details = sparkSession.sql("SELECT trans_trLines_trLine from dep2");
//	    dep2details.show(); 
	  //  Dataset<Row> trGt5 = sparkSession.sql("SELECT trans.trHeader.trUniqueSN FROM transactions where trans.trValue.trTotWTax=  5.00");

		//MongoSpark.save(rdd.)
	    //sum.show();
//	    MongoSpark.write(transactions).option("student", "studentC").mode("overwrite").save();
	    
//		System.out.println(rdd.count());
//		for(int i=0; i < rdd.count();i++) {
//			System.out.println("StudentID" +rdd.collect().get(i).get("student_id"));
//		}
//		//while(rdd.collect().)
//		System.out.println(rdd.first().toJson());
//		jsc.close();

	}
	
    /**
    * Generate SQL to select columns as flat.
    */
    public static String flattenSchema(StructType schema, String prefix)
    {
        final StringBuilder selectSQLQuery = new StringBuilder();

        for (StructField field : schema.fields())
        {
            final String fieldName = field.name();

            if (fieldName.startsWith("@"))
            {
                continue;
            }

            String colName = prefix == null ? fieldName : (prefix + "." + fieldName);
            String colNameTarget = colName.replace(".", "_");

            if (field.dataType().getClass().equals(StructType.class))
            {
                selectSQLQuery.append(flattenSchema((StructType) field.dataType(), colName));
            }
            else
            {
                selectSQLQuery.append(colName);
                selectSQLQuery.append(" as ");
                selectSQLQuery.append(colNameTarget);
            }

            selectSQLQuery.append(",");
        }

        if (selectSQLQuery.length() > 0)
        {
            selectSQLQuery.deleteCharAt(selectSQLQuery.length() - 1);
        }

        return selectSQLQuery.toString();
    }
}

