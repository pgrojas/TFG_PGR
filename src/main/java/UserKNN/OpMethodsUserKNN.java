package UserKNN;

import es.upm.etsisi.cf4j.data.DataModel;
import es.upm.etsisi.cf4j.qualityMeasure.prediction.MSE;
import es.upm.etsisi.cf4j.recommender.knn.UserKNN;
import es.upm.etsisi.cf4j.recommender.knn.userSimilarityMetric.*;
import es.upm.etsisi.cf4j.util.optimization.GridSearchCV;
import es.upm.etsisi.cf4j.util.optimization.ParamsGrid;

import java.util.Map;

public class OpMethodsUserKNN {

    public static Map<String, Object> adjustedC(DataModel datamodel) {
        UserSimilarityMetric ac = new AdjustedCosine();
        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numberOfNeighbors", new int[]{320,350,370,400});
        paramsGrid.addParam("metric", new Object[]{ac});
        paramsGrid.addParam("aggregationApproach", new Object[]{
                UserKNN.AggregationApproach.MEAN, UserKNN.AggregationApproach.DEVIATION_FROM_MEAN, UserKNN.AggregationApproach.WEIGHTED_MEAN});


        GridSearchCV gridSearchCV = new GridSearchCV(datamodel, paramsGrid, UserKNN.class, MSE.class, 5, 42);


        gridSearchCV.fit();
        gridSearchCV.printResults(10, true);
        return gridSearchCV.getBestParams();
    }

    public static Map<String, Object> correlation(DataModel datamodel) {
        UserSimilarityMetric c = new Correlation();
        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numberOfNeighbors", new int[]{420,430,440,450,470,500});
        paramsGrid.addParam("metric", new Object[]{c});
        paramsGrid.addParam("aggregationApproach", new Object[]{
                UserKNN.AggregationApproach.MEAN, UserKNN.AggregationApproach.DEVIATION_FROM_MEAN, UserKNN.AggregationApproach.WEIGHTED_MEAN});


        GridSearchCV gridSearchCV = new GridSearchCV(datamodel, paramsGrid, UserKNN.class, MSE.class, 5, 42);


        gridSearchCV.fit();
        gridSearchCV.printResults(10, true);
        return gridSearchCV.getBestParams();
    }
    public static Map<String, Object> cjmsd(DataModel datamodel) {
        UserSimilarityMetric cjmsd = new CJMSD();
        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numberOfNeighbors", new int[]{650,700,720,740,750});
        paramsGrid.addParam("metric", new Object[]{cjmsd});
        paramsGrid.addParam("aggregationApproach", new Object[]{
                UserKNN.AggregationApproach.MEAN, UserKNN.AggregationApproach.DEVIATION_FROM_MEAN, UserKNN.AggregationApproach.WEIGHTED_MEAN});


        GridSearchCV gridSearchCV = new GridSearchCV(datamodel, paramsGrid, UserKNN.class, MSE.class, 5, 42);


        gridSearchCV.fit();
        gridSearchCV.printResults(10, true);
        return gridSearchCV.getBestParams();
    }
    public static Map<String,Object> cosine(DataModel datamodel) {
        UserSimilarityMetric cos = new Cosine();
        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numberOfNeighbors", new int[]{570,580,600,620,640,650,700});
        paramsGrid.addParam("metric", new Object[]{cos});
        paramsGrid.addParam("aggregationApproach", new Object[]{
                UserKNN.AggregationApproach.MEAN, UserKNN.AggregationApproach.DEVIATION_FROM_MEAN, UserKNN.AggregationApproach.WEIGHTED_MEAN});


        GridSearchCV gridSearchCV = new GridSearchCV(datamodel, paramsGrid, UserKNN.class, MSE.class, 5, 42);


        gridSearchCV.fit();
        gridSearchCV.printResults(10, true);
        return gridSearchCV.getBestParams();
    }
    public static Map<String, Object> jmsd(DataModel datamodel) {
        UserSimilarityMetric jmsd = new JMSD();
        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numberOfNeighbors", new int[]{250,280,300,320,340,360,400});
        paramsGrid.addParam("metric", new Object[]{jmsd});
        paramsGrid.addParam("aggregationApproach", new Object[]{
                UserKNN.AggregationApproach.MEAN, UserKNN.AggregationApproach.DEVIATION_FROM_MEAN, UserKNN.AggregationApproach.WEIGHTED_MEAN});


        GridSearchCV gridSearchCV = new GridSearchCV(datamodel, paramsGrid, UserKNN.class, MSE.class, 5, 42);


        gridSearchCV.fit();
        gridSearchCV.printResults(10, true);
        return gridSearchCV.getBestParams();
    }
    public static Map<String, Object> jaccard(DataModel datamodel) {
        UserSimilarityMetric jaccard = new Jaccard();
        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numberOfNeighbors", new int[]{280,300,320,340,360,400});
        paramsGrid.addParam("metric", new Object[]{jaccard});
        paramsGrid.addParam("aggregationApproach", new Object[]{
                UserKNN.AggregationApproach.MEAN, UserKNN.AggregationApproach.DEVIATION_FROM_MEAN, UserKNN.AggregationApproach.WEIGHTED_MEAN});


        GridSearchCV gridSearchCV = new GridSearchCV(datamodel, paramsGrid, UserKNN.class, MSE.class, 5, 42);


        gridSearchCV.fit();
        gridSearchCV.printResults(10, true);
        return gridSearchCV.getBestParams();
    }
    public static Map<String, Object> msd(DataModel datamodel) {
        UserSimilarityMetric msd= new MSD();
        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numberOfNeighbors", new int[]{450,500,550,600,650,700});
        paramsGrid.addParam("metric", new Object[]{msd});
        paramsGrid.addParam("aggregationApproach", new Object[]{
                UserKNN.AggregationApproach.MEAN, UserKNN.AggregationApproach.DEVIATION_FROM_MEAN, UserKNN.AggregationApproach.WEIGHTED_MEAN});


        GridSearchCV gridSearchCV = new GridSearchCV(datamodel, paramsGrid, UserKNN.class, MSE.class, 5, 42);


        gridSearchCV.fit();
        gridSearchCV.printResults(10, true);
        return gridSearchCV.getBestParams();
    }
    public static Map<String, Object> pip(DataModel datamodel) {
        UserSimilarityMetric pip = new PIP();
        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numberOfNeighbors", new int[]{400,450,450,500,550,600});
        paramsGrid.addParam("metric", new Object[]{pip});
        paramsGrid.addParam("aggregationApproach", new Object[]{
                UserKNN.AggregationApproach.MEAN, UserKNN.AggregationApproach.DEVIATION_FROM_MEAN, UserKNN.AggregationApproach.WEIGHTED_MEAN});


        GridSearchCV gridSearchCV = new GridSearchCV(datamodel, paramsGrid, UserKNN.class, MSE.class, 5, 42);


        gridSearchCV.fit();
        gridSearchCV.printResults(10, true);
        return gridSearchCV.getBestParams();
    }
    public static Map<String, Object> sRank(DataModel datamodel) {
        UserSimilarityMetric SRank = new SpearmanRank();
        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numberOfNeighbors", new int[]{50,75,100,125,150});
        paramsGrid.addParam("metric", new Object[]{SRank});
        paramsGrid.addParam("aggregationApproach", new Object[]{
                UserKNN.AggregationApproach.MEAN, UserKNN.AggregationApproach.DEVIATION_FROM_MEAN, UserKNN.AggregationApproach.WEIGHTED_MEAN});


        GridSearchCV gridSearchCV = new GridSearchCV(datamodel, paramsGrid, UserKNN.class, MSE.class, 5, 42);


        gridSearchCV.fit();
        gridSearchCV.printResults(10, true);
        return gridSearchCV.getBestParams();
    }
    public static Map<String, Object> singularaties(DataModel datamodel, double [] relevant, double [] notRelevant) {
        UserSimilarityMetric sing = new Singularities(relevant,notRelevant);
        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numberOfNeighbors", new int[]{50,100,200,300,400,500,600});
        paramsGrid.addParam("metric", new Object[]{sing});
        paramsGrid.addParam("aggregationApproach", new Object[]{
                UserKNN.AggregationApproach.MEAN, UserKNN.AggregationApproach.DEVIATION_FROM_MEAN, UserKNN.AggregationApproach.WEIGHTED_MEAN});


        GridSearchCV gridSearchCV = new GridSearchCV(datamodel, paramsGrid, UserKNN.class, MSE.class, 5, 42);


        gridSearchCV.fit();
        gridSearchCV.printResults(10, true);
        return gridSearchCV.getBestParams();
    }
    public static Map<String, Object> correlationCons(DataModel datamodel, double median) {
        UserSimilarityMetric correlationCons = new CorrelationConstrained(median);
        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numberOfNeighbors", new int[]{50,100,200,300,400,500,600});
        paramsGrid.addParam("metric", new Object[]{correlationCons});
        paramsGrid.addParam("aggregationApproach", new Object[]{
                UserKNN.AggregationApproach.MEAN, UserKNN.AggregationApproach.DEVIATION_FROM_MEAN, UserKNN.AggregationApproach.WEIGHTED_MEAN});


        GridSearchCV gridSearchCV = new GridSearchCV(datamodel, paramsGrid, UserKNN.class, MSE.class, 5, 42);


        gridSearchCV.fit();
        gridSearchCV.printResults(10, true);
        return gridSearchCV.getBestParams();
    }
}
