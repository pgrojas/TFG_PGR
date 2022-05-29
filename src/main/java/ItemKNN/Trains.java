package ItemKNN;


import es.upm.etsisi.cf4j.data.BenchmarkDataModels;
import es.upm.etsisi.cf4j.data.DataModel;

import java.io.IOException;

public class Trains {
    public static void main (String [] args) throws IOException {
        DataModel datamodel = BenchmarkDataModels.MovieLens100K();

        //OpMethodsItemKNN.correlation(datamodel);
        System.out.println();
        //OpMethodsItemKNN.adjustedC(datamodel);
        System.out.println();
        //OpMethodsItemKNN.cosine(datamodel);
        System.out.println();
        //OpMethodsItemKNN.jmsd(datamodel);
        System.out.println();
        //OpMethodsItemKNN.jaccard(datamodel);
        System.out.println();
        //OpMethodsItemKNN.msd(datamodel);
        System.out.println();
        //OpMethodsItemKNN.pip(datamodel);
        System.out.println();
        //OpMethodsItemKNN.sRank(datamodel);
        System.out.println();
        double median = 3.0;
        OpMethodsItemKNN.correlationCons(datamodel,median);
        System.out.println();
        double [] relevant = new double[]{1.0,2.0,3.0,4.0,5.0};
        double [] notRelevant = new double[]{0.0};
        //OpMethodsItemKNN.singularaties(datamodel,relevant,notRelevant);
        System.out.println();
    }
}
