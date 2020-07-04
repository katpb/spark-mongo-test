import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.ml.feature.VectorAssembler;
import org.apache.spark.ml.regression.LinearRegression;
import org.apache.spark.ml.regression.LinearRegressionModel;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public class Main8 {

	public static void main(String[] args) {
		
		Logger.getLogger("org").setLevel(Level.ERROR);
		
		Dataset<Row> csvData = SparkConnection.getSession().read().option("header", "true").option("inferSchema", "true").format("csv").load("Area_Of_Triangle.csv").withColumnRenamed("Y1", "label");
		Dataset<Row> trainingData = new VectorAssembler().setInputCols(new String[] {"X1"}).setOutputCol("features").transform(csvData);
		trainingData.show();
		
		LinearRegressionModel lrModel = new LinearRegression().fit(trainingData);
		lrModel.transform(trainingData).show();
		System.out.println("Coefficients: " + lrModel.coefficients() + " Intercept: " + lrModel.intercept() + " r2: " + lrModel.summary().r2());
	}

}
