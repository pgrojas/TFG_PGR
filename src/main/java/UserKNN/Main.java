package UserKNN;

import UserKNN.fitFunctionsUKNN;
import es.upm.etsisi.cf4j.data.BenchmarkDataModels;
import es.upm.etsisi.cf4j.data.DataModel;
import org.bytedeco.opencv.presets.opencv_core;
import ranking.rankingMSE;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        DataModel datamodel = BenchmarkDataModels.MovieLens100K();
        rankingMSE Userknn = new rankingMSE();
        rankingMSE general = new rankingMSE();
        double[] relevant = new double[]{1.0, 2.0, 3.0, 4.0, 5.0};
        double[] notRelevant = new double[]{0.0};
        fitFunctionsUKNN.adCosine(datamodel, Userknn, general);
        fitFunctionsUKNN.cosine(datamodel, Userknn, general);
        fitFunctionsUKNN.correlation(datamodel, Userknn, general);
        fitFunctionsUKNN.jaccard(datamodel, Userknn, general);
        fitFunctionsUKNN.jmsd(datamodel, Userknn, general);
        fitFunctionsUKNN.msd(datamodel, Userknn, general);
        fitFunctionsUKNN.sRank(datamodel, Userknn, general);
        fitFunctionsUKNN.pip(datamodel, Userknn, general);
        double median = 3.0;
        fitFunctionsUKNN.correlationCons(datamodel,median, Userknn, general);
        fitFunctionsUKNN.singularities(datamodel, relevant, notRelevant, Userknn, general);
        fitFunctionsUKNN.cjmsd(datamodel,Userknn,general);

        Userknn.printRanking();
        Userknn.exportJSON("./rank/json/dataUserKNN.json");
    }
}
