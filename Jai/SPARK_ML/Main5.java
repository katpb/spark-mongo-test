import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.ml.feature.VectorAssembler;
import org.apache.spark.ml.regression.LinearRegression;
import org.apache.spark.ml.regression.LinearRegressionModel;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class Main5 {

	public static void main(String[] args) {
		
		Logger.getLogger("org").setLevel(Level.ERROR);
		
		JavaSparkContext sparkContext = SparkConnection.getContext();
		SparkSession sparkSession = SparkConnection.getSession();
		
		Dataset<Row> rawData = sparkSession.read().option("header", "true").option("inferSchema", "true").format("csv").load(SparkConnection.MPG_FILE);
		VectorAssembler assembler = new VectorAssembler().setInputCols(new String[] {"CYLINDERS", "WEIGHT", "ACCELERATION"}).setOutputCol("features");
		Dataset<Row> mldf = assembler.transform(rawData).withColumnRenamed("MPG", "label").select("label", "features");
		mldf.show(5);
		
		Dataset<Row>[] splits = mldf.randomSplit(new double[] {0.9, 0.1});
		Dataset<Row> trainingData = splits[0];
		Dataset<Row> holdOutData = splits[1];
		
		LinearRegressionModel lrModel = new LinearRegression().fit(trainingData);
		System.out.println("TrainingData r^2: " + lrModel.summary().r2() + " RMSE: " + lrModel.summary().rootMeanSquaredError());
		
		//Uncomment the below line to see that the r2, rmse, and other parameters can be checked even without transforming the data(Line36)
		//System.out.println("HoldOutData r^2: " + lrModel.evaluate(holdOutData).r2() + " RMSE: " + lrModel.evaluate(holdOutData).rootMeanSquaredError());
		
		lrModel.transform(holdOutData).show(5);
		System.out.println("HoldOutData r^2: " + lrModel.evaluate(holdOutData).r2() + " RMSE: " + lrModel.evaluate(holdOutData).rootMeanSquaredError());
	}

}
