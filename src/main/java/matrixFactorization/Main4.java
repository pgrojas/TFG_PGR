package matrixFactorization;

import ranking.rankingMSE;
import es.upm.etsisi.cf4j.data.BenchmarkDataModels;
import es.upm.etsisi.cf4j.data.DataModel;

import java.io.IOException;


public class Main4 {
    public static void main (String [] args) throws IOException {

        DataModel dataModel = BenchmarkDataModels.MovieLens100K();
        double [] ratings = new double[]{1.0,2.0,3.0,4.0,5.0};
        rankingMSE mf = new rankingMSE();
        rankingMSE general = new rankingMSE();
        fitFunctionsMF.BiasedMFfit(dataModel,mf,general);
        fitFunctionsMF.BeMFfit(dataModel,mf,general,ratings);
        fitFunctionsMF.PMFfit(dataModel,mf,general);
        fitFunctionsMF.BNMFfit(dataModel,mf,general);
        fitFunctionsMF.DirMF(dataModel,mf,general,ratings);
        fitFunctionsMF.HPFfit(dataModel,mf,general);
        fitFunctionsMF.NMFfit(dataModel,mf,general);
        fitFunctionsMF.SVDPlusfit(dataModel,mf,general);
        fitFunctionsMF.URPfit(dataModel,mf,general,ratings);
        System.out.println();
        mf.printRanking();
        mf.exportJSON("./rank/json/dataMF.json");
    }
}
