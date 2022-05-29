package matrixFactorization;

import com.sun.org.apache.bcel.internal.generic.NEW;
import es.upm.etsisi.cf4j.data.DataModel;
import es.upm.etsisi.cf4j.qualityMeasure.prediction.MSE;
import es.upm.etsisi.cf4j.recommender.matrixFactorization.*;
import es.upm.etsisi.cf4j.util.optimization.GridSearchCV;
import es.upm.etsisi.cf4j.util.optimization.ParamsGrid;

import java.io.IOException;

import java.util.Map;

public class OptimizationMethods {

    /*Esta clase incluye los metodos de optimización para optimizar los hyper-parametros de cada algoritmo de matrix factorization*/


    //listo
    public static Map<String, Object> OPBeMF(DataModel datamodel, double [] ratings){


        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numFactors", new int[]{40,80,90,100});
        paramsGrid.addParam("numIters", new int[]{500,600,800,900});
        paramsGrid.addParam("learningRate", new double[]{0.0001,0.001,0.01});
        paramsGrid.addParam("regularization", new double[]{2.5,3,3.5,4.5,5.5,6.5,8.5});
        paramsGrid.addFixedParam("ratings", ratings);

        paramsGrid.addFixedParam("seed", 42L);


        GridSearchCV gridSearchCV = new GridSearchCV(datamodel, paramsGrid, BeMF.class, MSE.class, 5, 42);


        gridSearchCV.fit();
        gridSearchCV.printResults(10, true);

        return gridSearchCV.getBestParams();
    }

    public static Map<String, Object> OPBiasedMF(DataModel datamodel) {

        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numFactors", new int[]{65,70,80,90});
        paramsGrid.addParam("numIters", new int[]{600, 650, 700,750});
        paramsGrid.addParam("lambda", new double[]{0.05,0.10,0.15,0.20,0.25});
        paramsGrid.addParam("gamma", new double[]{0.002, 0.005, 0.007, 0.01});

        paramsGrid.addFixedParam("seed", 42L);

        GridSearchCV gridSearchCV = new GridSearchCV(datamodel, paramsGrid, BiasedMF.class, MSE.class, 5, 42);


        gridSearchCV.fit();
        gridSearchCV.printResults(10, true);

        return gridSearchCV.getBestParams();
    }


    public static Map<String, Object> OPBNMF(DataModel datamodel) {

        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numFactors", new int[]{5,10,15,20});
        paramsGrid.addParam("alpha", new double[]{0.5, 0.75, 0.1});
        paramsGrid.addParam("beta", new double[]{0.001,0.01, 0.1, 0.2});
        paramsGrid.addParam("numIters", new int[]{10,25,50,75,100});
        //paramsGrid.addParam("r", new double[]{0.01, 0.1, 0.5, 0.7, 1});

        paramsGrid.addFixedParam("seed", 42L);

        GridSearchCV gridSearchCV = new GridSearchCV(datamodel, paramsGrid, BNMF.class, MSE.class, 5, 42);


        gridSearchCV.fit();
        gridSearchCV.printResults(10, true);
        return gridSearchCV.getBestParams();
    }

    //descartado climMF
    // tarda mucho y es de los peores.


    //descartado
    //DeepMF

    public static Map<String, Object> OPHPF(DataModel datamodel) {

        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numFactors", new int[]{25,50,75,100});
        paramsGrid.addParam("numIters", new int[]{100,150,200,250});


        paramsGrid.addFixedParam("seed", 42L);

        GridSearchCV gridSearchCV = new GridSearchCV(datamodel, paramsGrid, HPF.class, MSE.class, 5, 42);


        gridSearchCV.fit();
        gridSearchCV.printResults(10, true);
        return gridSearchCV.getBestParams();

    }

    public static Map<String, Object> OPNMF(DataModel datamodel) {

        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numFactors", new int[]{500,1000,1500,2000,2500,3000,3500});
        paramsGrid.addParam("numIters", new int[]{20,40,60,80,100});


        paramsGrid.addFixedParam("seed", 42L);

        GridSearchCV gridSearchCV = new GridSearchCV(datamodel, paramsGrid, NMF.class, MSE.class, 5, 42);


        gridSearchCV.fit();
        gridSearchCV.printResults(10, true);
        return gridSearchCV.getBestParams();
    }

    //Ready
    public static Map<String, Object> OPPMF(DataModel datamodel){

        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numFactors", new int[]{15, 20, 25, 30, 40});
        paramsGrid.addParam("lambda", new double[]{0.001,0.1, 0.15, 0.2});
        paramsGrid.addParam("gamma", new double[]{0.001,0.005,0.01,0.1});
        paramsGrid.addParam("numIters", new int[]{750,800,850,900});

        paramsGrid.addFixedParam("seed", 42L);

        GridSearchCV gridSearchCV = new GridSearchCV(datamodel, paramsGrid, PMF.class, MSE.class, 5, 42);


        gridSearchCV.fit();
        gridSearchCV.printResults(10, true);
        //gridSearchCV.exportResults("OptimizedParameters/PMFParameters.csv", "\n", true); necesita throw IO
        return gridSearchCV.getBestParams();

    }

    public static Map<String, Object> OPSVD(DataModel datamodel) {

        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numFactors", new int[]{2, 4, 6, 8, 10});
        paramsGrid.addParam("numIters", new int[]{25, 50, 75, 100});
        paramsGrid.addParam("gamma", new double[]{0.001, 0.015, 0.02});
        paramsGrid.addParam("lambda", new double[]{0.01, 0.15, 0.2});


        paramsGrid.addFixedParam("seed", 42L);

        GridSearchCV gridSearchCV = new GridSearchCV(datamodel, paramsGrid, SVDPlusPlus.class, MSE.class, 5, 42);


        gridSearchCV.fit();
        gridSearchCV.printResults(10, true);
        return gridSearchCV.getBestParams();

    }

    public static Map<String, Object> OPBURP(DataModel datamodel, double [] ratings) {

        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numFactors", new int[]{1,3,5,7,10});
        paramsGrid.addParam("numIters", new int[]{10,15,20,25,30});
        paramsGrid.addParam("H", new double[]{0.3, 0.5, 0.7, 0.9, 1});
        paramsGrid.addFixedParam("ratings", ratings);


        paramsGrid.addFixedParam("seed", 42L);

        GridSearchCV gridSearchCV = new GridSearchCV(datamodel, paramsGrid, URP.class, MSE.class, 5, 42);

        gridSearchCV.fit();
        gridSearchCV.printResults(10, true);

        return gridSearchCV.getBestParams();
    }

    public static Map<String, Object> OPDirMF(DataModel datamodel, double [] ratings) {

        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numFactors", new int[]{2,6,10});
        paramsGrid.addParam("numIters", new int[]{850,900,950});
        paramsGrid.addParam("learningRate", new double[]{0.0001,0.001,0.01});
        paramsGrid.addParam("regularization", new double[]{0.2,0.4,0.6});
        paramsGrid.addFixedParam("ratings", ratings);


        paramsGrid.addFixedParam("seed", 42L);

        GridSearchCV gridSearchCV = new GridSearchCV(datamodel, paramsGrid, DirMF.class, MSE.class, 5, 42);

        gridSearchCV.fit();
        gridSearchCV.printResults(10, true);

        return gridSearchCV.getBestParams();
    }
}
