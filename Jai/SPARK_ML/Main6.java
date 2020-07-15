import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.ml.Pipeline;
import org.apache.spark.ml.PipelineModel;
import org.apache.spark.ml.PipelineStage;
import org.apache.spark.ml.classification.LogisticRegression;
import org.apache.spark.ml.feature.IndexToString;
import org.apache.spark.ml.feature.StringIndexer;
import org.apache.spark.ml.feature.VectorAssembler;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class Main6 {

	public static void main(String[] args) {
		Logger.getLogger("org").setLevel(Level.ERROR);
		
		Dataset<Row> rawData = SparkConnection.getSession().read().option("header", "true").option("inferSchema", "true").format("csv").load(SparkConnection.CRYOTHERAPY_FILE).withColumnRenamed("Result_of_Treatment", "label");
		StringIndexer sexIndexer = new StringIndexer().setInputCol("sex").setOutputCol("sexIndex");
		VectorAssembler assembler = new VectorAssembler().setInputCols(new String[] {"sexIndex", "age", "Time", "Number_of_Warts", "Type", "Area"}).setOutputCol("features");
		rawData.printSchema();
		
		Dataset<Row>[] splits = rawData.randomSplit(new double[] {0.9, 0.1});
		Dataset<Row> trainingData = splits[0];
		Dataset<Row> testData = splits[1];
		
		LogisticRegression lr = new LogisticRegression();
		Pipeline pl = new Pipeline();
		pl.setStages(new PipelineStage[] {sexIndexer, assembler, lr});
		
		PipelineModel plModel = pl.fit(trainingData);
		Dataset<Row> predictions = plModel.transform(testData);
		predictions.show();
	}

}
