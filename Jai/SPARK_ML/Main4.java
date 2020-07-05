import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.broadcast.Broadcast;
import org.apache.spark.ml.evaluation.RegressionEvaluator;
import org.apache.spark.ml.feature.LabeledPoint;
import org.apache.spark.ml.linalg.Vectors;
import org.apache.spark.ml.regression.LinearRegression;
import org.apache.spark.ml.regression.LinearRegressionModel;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

public class Main4 {
	
	public static void main(String[] args) {
		Logger.getLogger("org").setLevel(Level.ERROR);
		JavaSparkContext sparkContext = SparkConnection.getContext();
		SparkSession sparkSession = SparkConnection.getSession();
		
		//Load Data
		Dataset<Row> rawData = sparkSession.read().option("header", "true").csv(SparkConnection.MPG_FILE);
		rawData.show(5);
		rawData.printSchema();
		
		//Cleanse the Data
		StructType schema = DataTypes.createStructType(new StructField[] {
				DataTypes.createStructField("MPG", DataTypes.DoubleType, false),
				DataTypes.createStructField("CYLINDERS", DataTypes.DoubleType, false),
				DataTypes.createStructField("DISPLACEMENT", DataTypes.DoubleType, false),
				DataTypes.createStructField("HP", DataTypes.DoubleType, false),
				DataTypes.createStructField("WEIGHT", DataTypes.DoubleType, false),
				DataTypes.createStructField("ACCELERATION", DataTypes.DoubleType, false),
				DataTypes.createStructField("MODELYEAR", DataTypes.DoubleType, false),
				DataTypes.createStructField("NAME", DataTypes.StringType, false)
		});
		
		Broadcast<Double> avgHP = sparkContext.broadcast(80.0);
		JavaRDD<Row> rdd1 = rawData.toJavaRDD();
		/*
		 * In case of multiple nodes performing the job, and large set of data,
		 * we may want to restrict the number of partitions, by further setting the number
		 * of partitions. Ex: autoDf.toJavaRDD().coalesce(2), or autoDf.toJavaRDD().repartition(2);
		 */
		
		JavaRDD<Row> rdd2 = rdd1.map(new Function<Row, Row>() {

			@Override
			public Row call(Row iRow) throws Exception {
				double hp = (iRow.getString(3).equals("?") ? avgHP.value() : Double.valueOf(iRow.getString(3)));
				Row retRow = RowFactory.create(Double.valueOf(iRow.getString(0)),
						Double.valueOf(iRow.getString(1)),
						Double.valueOf(iRow.getString(2)),
						Double.valueOf(hp),
						Double.valueOf(iRow.getString(4)),
						Double.valueOf(iRow.getString(5)),
						Double.valueOf(iRow.getString(6)),
						iRow.getString(7)
						);
				return retRow;
			}
		});
		//Uncomment the below 2 lines to see the difference between the original and the transformed RDDs.
		//System.out.println("rdd1:" + rdd1.collect());
		//System.out.println("rdd2:" + rdd2.collect());
		
		//Create DataFrame
		Dataset<Row> cleansedDf = sparkSession.createDataFrame(rdd2, schema);
		System.out.println("Cleansed Data: ");
		cleansedDf.show(5);
		
		//Correlation analysis
		for(StructField field: schema.fields()) {
			if(!field.dataType().equals(DataTypes.StringType)) {
				System.out.println("Correlation between MPG and " + field.name() + " = " + cleansedDf.stat().corr("MPG", field.name()));
			}
		}
		
		//Prepare for ML
		//Convert to Labeled Point structure
		JavaRDD<Row> rdd3 = cleansedDf.toJavaRDD().repartition(2);
		JavaRDD<LabeledPoint> rdd4 = rdd3.map(new Function<Row, LabeledPoint>() {

			@Override
			public LabeledPoint call(Row iRow) throws Exception {
				LabeledPoint lp = new LabeledPoint(iRow.getDouble(0),
						Vectors.dense(iRow.getDouble(2),
								iRow.getDouble(4),
								iRow.getDouble(5)));
				return lp;
			}
		});
		
		Dataset<Row> autoLp = sparkSession.createDataFrame(rdd4, LabeledPoint.class);
		autoLp.show(5);
		
		//Split the data into training and test sets(10% held out for testing)
		Dataset<Row>[] splits = autoLp.randomSplit(new double[] {0.9, 0.1});
		Dataset<Row> trainingData = splits[0];
		Dataset<Row> testData = splits[1];
		
		//Perform ML
		//Create the object
		LinearRegression lr = new LinearRegression();
		//Create the model
		LinearRegressionModel lrModel = lr.fit(trainingData);
		System.out.println("Coefficients: " + lrModel.coefficients() + " Intercept: " + lrModel.intercept());
		System.out.println("Model: R2: " + lrModel.summary().r2() + " RMSE: " + lrModel.summary().rootMeanSquaredError());
		
		//Predict on test data
		Dataset<Row> predictions = lrModel.transform(testData);
		
		//View Results
		predictions.select("label", "prediction", "features").show(5);
		
		//Compute R2 for the model on test data
		RegressionEvaluator evaluator = new RegressionEvaluator().setLabelCol("label").setPredictionCol("prediction").setMetricName("r2");
		double r2 = evaluator.evaluate(predictions);
		System.out.println("R2 on test data = " + r2);
	}

}
