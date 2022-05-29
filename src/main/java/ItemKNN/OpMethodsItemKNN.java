package ItemKNN;

import es.upm.etsisi.cf4j.data.DataModel;
import es.upm.etsisi.cf4j.data.Item;
import es.upm.etsisi.cf4j.qualityMeasure.prediction.MSE;
import es.upm.etsisi.cf4j.recommender.knn.ItemKNN;
import es.upm.etsisi.cf4j.recommender.knn.itemSimilarityMetric.*;
import es.upm.etsisi.cf4j.recommender.knn.userSimilarityMetric.CJMSD;
import es.upm.etsisi.cf4j.util.optimization.GridSearchCV;
import es.upm.etsisi.cf4j.util.optimization.ParamsGrid;

import java.util.Map;

public class OpMethodsItemKNN {
    public static Map<String, Object> adjustedC(DataModel datamodel) {
        ItemSimilarityMetric ac = new AdjustedCosine();
        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numberOfNeighbors", new int[]{500,550,600,650,700});
        paramsGrid.addParam("metric", new Object[]{ac});
        paramsGrid.addParam("aggregationApproach", new Object[]{
                ItemKNN.AggregationApproach.MEAN, ItemKNN.AggregationApproach.WEIGHTED_MEAN});


        GridSearchCV gridSearchCV = new GridSearchCV(datamodel, paramsGrid, ItemKNN.class, MSE.class, 5, 42);


        gridSearchCV.fit();
        gridSearchCV.printResults(10, true);
        return gridSearchCV.getBestParams();
    }

    public static Map<String, Object> correlation(DataModel datamodel) {
        ItemSimilarityMetric c = new Correlation();
        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numberOfNeighbors", new int[]{600,650,700,750,800,850});
        paramsGrid.addParam("metric", new Object[]{c});
        paramsGrid.addParam("aggregationApproach", new Object[]{
                ItemKNN.AggregationApproach.MEAN, ItemKNN.AggregationApproach.WEIGHTED_MEAN});


        GridSearchCV gridSearchCV = new GridSearchCV(datamodel, paramsGrid, ItemKNN.class, MSE.class, 5, 42);


        gridSearchCV.fit();
        gridSearchCV.printResults(10, true);
        return gridSearchCV.getBestParams();

    }
    public static Map<String, Object> singularaties(DataModel datamodel,double [] relevant, double [] notRelevant) {
        ItemSimilarityMetric sing = new Singularities(relevant,notRelevant);
        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numberOfNeighbors", new int[]{50,100,150,200,250,300,350});
        paramsGrid.addParam("metric", new Object[]{sing});
        paramsGrid.addParam("aggregationApproach", new Object[]{
                ItemKNN.AggregationApproach.MEAN, ItemKNN.AggregationApproach.WEIGHTED_MEAN});


        GridSearchCV gridSearchCV = new GridSearchCV(datamodel, paramsGrid, ItemKNN.class, MSE.class, 5, 42);


        gridSearchCV.fit();
        gridSearchCV.printResults(10, true);
        return gridSearchCV.getBestParams();

    }
    public static Map<String, Object> cosine(DataModel datamodel) {
        ItemSimilarityMetric cos = new Cosine();
        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numberOfNeighbors", new int[]{800,850,900,950,1000,1050,1100});
        paramsGrid.addParam("metric", new Object[]{cos});
        paramsGrid.addParam("aggregationApproach", new Object[]{
                ItemKNN.AggregationApproach.MEAN, ItemKNN.AggregationApproach.WEIGHTED_MEAN});


        GridSearchCV gridSearchCV = new GridSearchCV(datamodel, paramsGrid, ItemKNN.class, MSE.class, 5, 42);


        gridSearchCV.fit();
        gridSearchCV.printResults(10, true);
        return gridSearchCV.getBestParams();

    }
    public static Map<String, Object> jmsd(DataModel datamodel) {
        ItemSimilarityMetric jmsd = new JMSD();
        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numberOfNeighbors", new int[]{25,50,100,150,200});
        paramsGrid.addParam("metric", new Object[]{jmsd});
        paramsGrid.addParam("aggregationApproach", new Object[]{
                ItemKNN.AggregationApproach.MEAN, ItemKNN.AggregationApproach.WEIGHTED_MEAN});


        GridSearchCV gridSearchCV = new GridSearchCV(datamodel, paramsGrid, ItemKNN.class, MSE.class, 5, 42);


        gridSearchCV.fit();
        gridSearchCV.printResults(10, true);
        return gridSearchCV.getBestParams();

    }

    public static Map<String, Object> jaccard(DataModel datamodel) {
        ItemSimilarityMetric jaccard = new Jaccard();
        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numberOfNeighbors", new int[]{50,100,150,200,250});
        paramsGrid.addParam("metric", new Object[]{jaccard});
        paramsGrid.addParam("aggregationApproach", new Object[]{
                ItemKNN.AggregationApproach.MEAN, ItemKNN.AggregationApproach.WEIGHTED_MEAN});


        GridSearchCV gridSearchCV = new GridSearchCV(datamodel, paramsGrid, ItemKNN.class, MSE.class, 5, 42);


        gridSearchCV.fit();
        gridSearchCV.printResults(10, true);
        return gridSearchCV.getBestParams();

    }
    public static Map<String, Object> msd(DataModel datamodel) {
        ItemSimilarityMetric msd= new MSD();
        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numberOfNeighbors", new int[]{600,650,700,750,800,850});
        paramsGrid.addParam("metric", new Object[]{msd});
        paramsGrid.addParam("aggregationApproach", new Object[]{
                ItemKNN.AggregationApproach.MEAN, ItemKNN.AggregationApproach.WEIGHTED_MEAN});


        GridSearchCV gridSearchCV = new GridSearchCV(datamodel, paramsGrid, ItemKNN.class, MSE.class, 5, 42);


        gridSearchCV.fit();
        gridSearchCV.printResults(10, true);
        return gridSearchCV.getBestParams();

    }
    public static Map<String, Object> pip(DataModel datamodel) {
        ItemSimilarityMetric pip = new PIP();
        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numberOfNeighbors", new int[]{400,450,500,550,600,650});
        paramsGrid.addParam("metric", new Object[]{pip});
        paramsGrid.addParam("aggregationApproach", new Object[]{
                ItemKNN.AggregationApproach.MEAN, ItemKNN.AggregationApproach.WEIGHTED_MEAN});


        GridSearchCV gridSearchCV = new GridSearchCV(datamodel, paramsGrid, ItemKNN.class, MSE.class, 5, 42);


        gridSearchCV.fit();
        gridSearchCV.printResults(10, true);
        return gridSearchCV.getBestParams();

    }
    public static Map<String, Object> sRank(DataModel datamodel) {
        ItemSimilarityMetric SRank = new SpearmanRank();
        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numberOfNeighbors", new int[]{100,150,200,250});
        paramsGrid.addParam("metric", new Object[]{SRank});
        paramsGrid.addParam("aggregationApproach", new Object[]{
                ItemKNN.AggregationApproach.MEAN, ItemKNN.AggregationApproach.WEIGHTED_MEAN});


        GridSearchCV gridSearchCV = new GridSearchCV(datamodel, paramsGrid, ItemKNN.class, MSE.class, 5, 42);


        gridSearchCV.fit();
        gridSearchCV.printResults(10, true);
        return gridSearchCV.getBestParams();

    }
    public static Map<String, Object> correlationCons(DataModel datamodel,double median) {
        ItemSimilarityMetric CorrelationCons = new CorrelationConstrained(median); // mediana
        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numberOfNeighbors", new int[]{400,450,500,550,600,650});
        paramsGrid.addParam("metric", new Object[]{CorrelationCons});
        paramsGrid.addParam("aggregationApproach", new Object[]{
                ItemKNN.AggregationApproach.MEAN, ItemKNN.AggregationApproach.WEIGHTED_MEAN});


        GridSearchCV gridSearchCV = new GridSearchCV(datamodel, paramsGrid, ItemKNN.class, MSE.class, 5, 42);


        gridSearchCV.fit();
        gridSearchCV.printResults(10, true);
        return gridSearchCV.getBestParams();

    }
}
