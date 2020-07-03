import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.ml.classification.DecisionTreeClassificationModel;
import org.apache.spark.ml.classification.DecisionTreeClassifier;
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator;
import org.apache.spark.ml.feature.IndexToString;
import org.apache.spark.ml.feature.StringIndexer;
import org.apache.spark.ml.feature.StringIndexerModel;
import org.apache.spark.ml.feature.VectorAssembler;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public class Main9 {

	public static void main(String[] args) {
Logger.getLogger("org").setLevel(Level.ERROR);
		
		Dataset<Row> csvData = SparkConnection.getSession().read().option("header", "true").option("inferSchema", "true").format("csv").load(SparkConnection.DECISION_IRIS_FILE);
		
		Dataset<Row> featureAssembledDf = new VectorAssembler().setInputCols(new String[] {"sepal_length", "sepal_width", "petal_length", "petal_width"}).setOutputCol("features")
				.transform(csvData);
		StringIndexerModel siModel = new StringIndexer().setInputCol("species").setOutputCol("label").fit(featureAssembledDf);
		Dataset<Row> mLdf = siModel.transform(featureAssembledDf);
		mLdf.show();
		
		Dataset<Row>[] splits = mLdf.randomSplit(new double[] {0.9, 0.1});
		Dataset<Row> trainingData = splits[0];
		Dataset<Row> holdOutData = splits[1];
		
		IndexToString predictionConverter = new IndexToString().setInputCol("prediction").setOutputCol("Prediction_Value").setLabels(siModel.labels());
				
		DecisionTreeClassificationModel dTCModel = new DecisionTreeClassifier().fit(trainingData);
		Dataset<Row> predictions = predictionConverter.transform(dTCModel.transform(holdOutData));
		predictions.withColumnRenamed("species", "Actual_value").select("features", "Actual_value", "Prediction_Value").show();
		//predictionConverter.transform(labelConverter.transform(predictions)).show();
		
		//View a matrix of results/comparisons
		predictions.groupBy("species", "Prediction_value").count().show();
		
		MulticlassClassificationEvaluator evaluator = new MulticlassClassificationEvaluator().setLabelCol("label").setPredictionCol("prediction").setMetricName("accuracy");
		double accuracy = evaluator.evaluate(predictions);
		System.out.println("Accuracy: " + Math.round(accuracy * 100) + "%");
	}

}
