package UserKNN;

import ItemKNN.OpMethodsItemKNN;
import es.upm.etsisi.cf4j.data.BenchmarkDataModels;
import es.upm.etsisi.cf4j.data.DataModel;

import java.io.IOException;

public class Trains {
    public static void main (String [] args) throws IOException{
        DataModel datamodel = BenchmarkDataModels.MovieLens100K();
        System.out.println();
        //OpMethodsUserKNN.Cosine(datamodel);
        System.out.println();
        //OpMethodsUserKNN.AdjustedC(datamodel);
        System.out.println();
        //OpMethodsUserKNN.Jaccard(datamodel);
        System.out.println();
        //OpMethodsUserKNN.msd(datamodel);
        System.out.println();
        //OpMethodsUserKNN.Jmsd(datamodel);
        System.out.println();
        //OpMethodsUserKNN.Correlation(datamodel);
        System.out.println();
        //OpMethodsUserKNN.cjmsd(datamodel);
        System.out.println();
        //OpMethodsUserKNN.pip(datamodel);
        System.out.println();
        //OpMethodsUserKNN.SRank(datamodel);
        System.out.println();
        double [] relevant = new double[]{1.0,2.0,3.0,4.0,5.0};
        double [] notRelevant = new double[]{0.0};
        OpMethodsUserKNN.singularaties(datamodel,relevant,notRelevant);
        System.out.println();
        double median = 3.0;
        OpMethodsUserKNN.correlationCons(datamodel,median);

    }
}
