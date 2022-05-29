import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.stream.Stream;

import UserKNN.fitFunctions2UserKNN;
import ItemKNN.fitFunctions2ItemKNN;
import es.upm.etsisi.cf4j.data.BenchmarkDataModels;
import es.upm.etsisi.cf4j.data.DataModel;
import matrixFactorization.fitFunctions2MF;
import ranking.rankingMSE;

public class Main2 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("algorithmRanking.properties")));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        boolean sel = false;
        String database = null;
        String db100k = properties.getProperty("DATABASE100K");
        String db1M = properties.getProperty("DATABASE1M");
        while (!sel) {
            System.out.println("Options: \t movieLens100k \t movieLens1M");
            Scanner in = new Scanner(System.in);
            database = in.nextLine();
            System.out.println("Selected: " + database);
            if (database.equals(db100k) || (database.equals(db1M)))
                sel = true;
        }
        if (sel && database.equals(db100k)){
            System.out.println("Comienza el proceso de optimización para movieLens100k");

            DataModel datamodel = BenchmarkDataModels.MovieLens100K();
            String property = properties.getProperty("RATING100K");
            String property2 = properties.getProperty("RELEVANT100K");
            String property3 = properties.getProperty("NRELEVANT100K");
            String property4 = properties.getProperty("MEDIAN100K");

            double[] rating100k = Stream.of(property.split(",")).mapToDouble(Double::parseDouble).toArray();
            double[] relevant = Stream.of(property2.split(",")).mapToDouble(Double::parseDouble).toArray();
            double[] nRelevant = Stream.of(property3.split(",")).mapToDouble(Double::parseDouble).toArray();
            double median = Double.valueOf(property4);


            rankingMSE mf = new rankingMSE();
            rankingMSE userKNN = new rankingMSE();
            rankingMSE itemKNN = new rankingMSE();
            rankingMSE general = new rankingMSE();

            /* Matrix Factorization fit */

            fitFunctions2MF.PMFfit(datamodel,mf,general);
            fitFunctions2MF.BiasedMFfit(datamodel,mf,general);
            fitFunctions2MF.BeMFfit(datamodel,mf,general,rating100k);
            fitFunctions2MF.BNMFfit(datamodel,mf,general);
            fitFunctions2MF.HPFfit(datamodel,mf,general);
            fitFunctions2MF.NMFfit(datamodel,mf,general);
            fitFunctions2MF.SVDPlusfit(datamodel,mf,general);
            fitFunctions2MF.URPfit(datamodel,mf,general,rating100k);
            fitFunctions2MF.DirMF(datamodel,mf,general,rating100k);

            System.out.println();

            mf.printRanking();
            mf.exportJSON("./rank/json/movieLens100K/dataMF.json");
            System.out.println();

            /* UserKNN fit */

            fitFunctions2UserKNN.cosine(datamodel,userKNN,general);
            fitFunctions2UserKNN.adCosine(datamodel,userKNN,general);
            fitFunctions2UserKNN.correlation(datamodel,userKNN,general);
            fitFunctions2UserKNN.jmsd(datamodel,userKNN,general);
            fitFunctions2UserKNN.jaccard(datamodel,userKNN,general);
            fitFunctions2UserKNN.msd(datamodel,userKNN,general);
            fitFunctions2UserKNN.pip(datamodel,userKNN,general);
            fitFunctions2UserKNN.sRank(datamodel,userKNN,general);
            fitFunctions2UserKNN.correlationCons(datamodel,median,userKNN,general);
            fitFunctions2UserKNN.singularities(datamodel,relevant,nRelevant,userKNN,general);
            fitFunctions2UserKNN.cjmsd(datamodel,userKNN,general);

            System.out.println();

            userKNN.printRanking();
            userKNN.exportJSON("./rank/json/movieLens100K/dataUserKNN.json");
            System.out.println();

            /* ItemKNN fit */

            fitFunctions2ItemKNN.cosine(datamodel,itemKNN,general);
            fitFunctions2ItemKNN.adCosine(datamodel,itemKNN,general);
            fitFunctions2ItemKNN.correlation(datamodel,itemKNN,general);
            fitFunctions2ItemKNN.jmsd(datamodel,itemKNN,general);
            fitFunctions2ItemKNN.jaccard(datamodel,itemKNN,general);
            fitFunctions2ItemKNN.msd(datamodel,itemKNN,general);
            fitFunctions2ItemKNN.pip(datamodel,itemKNN,general);
            fitFunctions2ItemKNN.sRank(datamodel,itemKNN,general);
            fitFunctions2ItemKNN.correlationCons(datamodel,median,itemKNN,general);
            fitFunctions2ItemKNN.singularities(datamodel,relevant,nRelevant,itemKNN,general);

            System.out.println();

            itemKNN.printRanking();
            itemKNN.exportJSON("./rank/json/movieLens100K/dataItemKNN.json");
            System.out.println();

            general.printRanking();
            general.exportJSON("./rank/json/movieLens100K/dataMovieLens100K.json");
        }
        /* MOVIELENS 1M */

        if (sel && database.equals(db1M)){

            System.out.println("Comienza el proceso de optimización para movieLens1M");

            DataModel datamodel = BenchmarkDataModels.MovieLens1M();
            String property = properties.getProperty("RATING1M");
            String property2 = properties.getProperty("RELEVANT1M");
            String property3 = properties.getProperty("NRELEVANT1M");
            String property4 = properties.getProperty("MEDIAN1M");

            double[] rating1M = Stream.of(property.split(",")).mapToDouble(Double::parseDouble).toArray();
            double[] relevant = Stream.of(property2.split(",")).mapToDouble(Double::parseDouble).toArray();
            double[] nRelevant = Stream.of(property3.split(",")).mapToDouble(Double::parseDouble).toArray();
            double median = Double.valueOf(property4);


            rankingMSE mf = new rankingMSE();
            rankingMSE userKNN = new rankingMSE();
            rankingMSE itemKNN = new rankingMSE();
            rankingMSE general = new rankingMSE();

            /* Matrix Factorization fit */

            fitFunctions2MF.PMFfit(datamodel,mf,general);
            fitFunctions2MF.BiasedMFfit(datamodel,mf,general);
            fitFunctions2MF.BeMFfit(datamodel,mf,general,rating1M);
            fitFunctions2MF.BNMFfit(datamodel,mf,general);
            fitFunctions2MF.HPFfit(datamodel,mf,general);
            fitFunctions2MF.NMFfit(datamodel,mf,general);
            fitFunctions2MF.SVDPlusfit(datamodel,mf,general);
            fitFunctions2MF.URPfit(datamodel,mf,general,rating1M);
            fitFunctions2MF.DirMF(datamodel,mf,general,rating1M);

            System.out.println();

            mf.printRanking();
            mf.exportJSON("./rank/json/movieLens1M/dataMF.json");
            System.out.println();

            /* UserKNN fit */

            fitFunctions2UserKNN.cosine(datamodel,userKNN,general);
            fitFunctions2UserKNN.adCosine(datamodel,userKNN,general);
            fitFunctions2UserKNN.correlation(datamodel,userKNN,general);
            fitFunctions2UserKNN.jmsd(datamodel,userKNN,general);
            fitFunctions2UserKNN.jaccard(datamodel,userKNN,general);
            fitFunctions2UserKNN.msd(datamodel,userKNN,general);
            fitFunctions2UserKNN.pip(datamodel,userKNN,general);
            fitFunctions2UserKNN.sRank(datamodel,userKNN,general);
            fitFunctions2UserKNN.correlationCons(datamodel,median,userKNN,general);
            fitFunctions2UserKNN.singularities(datamodel,relevant,nRelevant,userKNN,general);
            fitFunctions2UserKNN.cjmsd(datamodel,userKNN,general);

            System.out.println();

            userKNN.printRanking();
            userKNN.exportJSON("./rank/json/movieLens1M/dataUserKNN.json");
            System.out.println();

            /* ItemKNN fit */

            fitFunctions2ItemKNN.cosine(datamodel,itemKNN,general);
            fitFunctions2ItemKNN.adCosine(datamodel,itemKNN,general);
            fitFunctions2ItemKNN.correlation(datamodel,itemKNN,general);
            fitFunctions2ItemKNN.jmsd(datamodel,itemKNN,general);
            fitFunctions2ItemKNN.jaccard(datamodel,itemKNN,general);
            fitFunctions2ItemKNN.msd(datamodel,itemKNN,general);
            fitFunctions2ItemKNN.pip(datamodel,itemKNN,general);
            fitFunctions2ItemKNN.sRank(datamodel,itemKNN,general);
            fitFunctions2ItemKNN.correlationCons(datamodel,median,itemKNN,general);
            fitFunctions2ItemKNN.singularities(datamodel,relevant,nRelevant,itemKNN,general);

            System.out.println();

            itemKNN.printRanking();
            itemKNN.exportJSON("./rank/json/movieLens1M/dataItemKNN.json");
            System.out.println();

            general.printRanking();
            general.exportJSON("./rank/json/movieLens1M/dataMovieLens1M.json");
        }


    }
}