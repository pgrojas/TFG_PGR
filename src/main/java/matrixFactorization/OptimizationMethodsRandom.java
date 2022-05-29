package matrixFactorization;

import es.upm.etsisi.cf4j.data.DataModel;
import es.upm.etsisi.cf4j.qualityMeasure.prediction.MSE;
import es.upm.etsisi.cf4j.recommender.matrixFactorization.*;
import es.upm.etsisi.cf4j.util.optimization.ParamsGrid;
import es.upm.etsisi.cf4j.util.optimization.RandomSearchCV;

import java.io.IOException;

public class OptimizationMethodsRandom {
    protected static double[] ratings = new double[]{1.0, 2.0, 3.0, 4.0, 5.0};
    protected static double coverage = 0.4;

    //listo para lanzar
    public static void OPBeMF(DataModel datamodel) throws IOException {


        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numFactors", new int[]{5, 10, 20, 50,70,90});
        paramsGrid.addParam("numIters", new int[]{25, 50, 100,800,1000});
        paramsGrid.addParam("learningRate", new double[]{0.001,0.01, 0.02, 0.05});
        paramsGrid.addParam("regularization", new double[]{3,4,5, 6.5, 8.5});
        paramsGrid.addFixedParam("ratings", ratings);

        paramsGrid.addFixedParam("seed", 42L);


        RandomSearchCV randomSearchCV = new RandomSearchCV(datamodel, paramsGrid, BeMF.class, MSE.class, 5, coverage, 42);


        randomSearchCV.fit();
        randomSearchCV.printResults(10, true);

       // randomSearchCV.exportResults("/OptimizedParameters/BeMF.csv", "\n", true);
    }
 //listo para lanzar
    public static void OPBiasedMF(DataModel datamodel) {

        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numFactors", new int[]{5, 10, 20, 30, 40, 50, 60});
        paramsGrid.addParam("numIters", new int[]{200, 400, 600, 1000});
        paramsGrid.addParam("lambda", new double[]{0.001, 0.003, 0.1, 0.15});
        paramsGrid.addParam("gamma", new double[]{0.001, 0.005, 0.007, 0.01});

        paramsGrid.addFixedParam("seed", 42L);

        RandomSearchCV randomSearchCV = new RandomSearchCV(datamodel, paramsGrid, BiasedMF.class, MSE.class, 5, coverage, 42);


        randomSearchCV.fit();
        randomSearchCV.printResults(10, true);
    }

    //16 horas de ejecución sin exito
    public static void OPBNMF(DataModel datamodel) {

        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numFactors", new int[]{2, 5, 10, 15, 20}); // 2-20
        paramsGrid.addParam("numIters", new int[]{25,50,75,100}); //como max 100
        paramsGrid.addParam("alpha", new double[]{0.001, 0.01, 0.1, 1.0}); // 0-1 se multiplica con gamma
        paramsGrid.addParam("beta", new double[]{0.001, 0.01, 0.1, 1.0}); // se multiplica con epsilon

        // parametro r fixed to 4

        paramsGrid.addFixedParam("seed", 42L);

        RandomSearchCV randomSearchCV = new RandomSearchCV(datamodel, paramsGrid, BNMF.class, MSE.class, 3, coverage, 42);


        randomSearchCV.fit();
        randomSearchCV.printResults(10, true);
    }

    //descartado climmf

    //descartado deepMF


    public static void OPHPF(DataModel datamodel) {

        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numFactors", new int[]{2, 4, 6, 8, 10});
        paramsGrid.addParam("numIters", new int[]{2, 4, 6, 8, 10});
        // a, a_prime, b_prime, c , c_prime, d_prime set default


        paramsGrid.addFixedParam("seed", 42L);

        RandomSearchCV randomSearchCV = new RandomSearchCV(datamodel, paramsGrid, HPF.class, MSE.class, 5, coverage, 42);


        randomSearchCV.fit();
        randomSearchCV.printResults(10, true);
    }

    public static void OPNMF(DataModel datamodel) {

        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numFactors", new int[]{350,450,600,700,800});
        paramsGrid.addParam("numIters", new int[]{10,20,30,40,60,100});


        paramsGrid.addFixedParam("seed", 42L);

        RandomSearchCV randomSearchCV = new RandomSearchCV(datamodel, paramsGrid, NMF.class, MSE.class, 5, coverage, 42);


        randomSearchCV.fit();
        randomSearchCV.printResults(10, true);
    }

    //Ready
    public static void OPPMF(DataModel datamodel) throws IOException {

        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numFactors", new int[]{5, 10, 20, 40, 60, 80, 100, 200});
        paramsGrid.addParam("lambda", new double[]{0.05, 0.1, 0.15, 0.2});
        paramsGrid.addParam("gamma", new double[]{0.001, 0.004, 0.005, 0.007, 0.01});
        paramsGrid.addParam("numIters", new int[]{50, 100, 150, 200, 300, 500, 700});

        paramsGrid.addFixedParam("seed", 42L);

        RandomSearchCV randomSearchCV = new RandomSearchCV(datamodel, paramsGrid, PMF.class, MSE.class, 5, coverage, 42);


        randomSearchCV.fit();
        randomSearchCV.printResults(10, true);


    }

    public static void OPSVD(DataModel datamodel) {
        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numFactors", new int[]{2, 4, 6, 8, 10});
        paramsGrid.addParam("numIters", new int[]{25, 50, 75, 100});

        // si variamos gamma y lambda, el resultado que sale es NAN.
        //paramsGrid.addParam("gamma", new double[]{0.0005,0.001, 0.002, 0.005});
        //paramsGrid.addParam("lambda", new double[]{0.001,0.01, 0.02,0.03});


        paramsGrid.addFixedParam("seed", 42L);

        RandomSearchCV randomSearchCV = new RandomSearchCV(datamodel, paramsGrid, SVDPlusPlus.class, MSE.class, 5, coverage, 42);


        randomSearchCV.fit();
        randomSearchCV.printResults(10, true);


    }

    public static void OPURP(DataModel datamodel) {

        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numFactors", new int[]{2, 3, 4, 6,8});
        paramsGrid.addParam("numIters", new int[]{5,12,15,20,25,30});
        paramsGrid.addParam("H", new double[]{0.3, 0.4, 0.45, 0.7, 2.5});
        paramsGrid.addFixedParam("ratings", ratings);


        paramsGrid.addFixedParam("seed", 42L);

        RandomSearchCV randomSearchCV = new RandomSearchCV(datamodel, paramsGrid, URP.class, MSE.class, 5, coverage, 42);


        randomSearchCV.fit();
        randomSearchCV.printResults(10, true);


    }

    public static void OPDirMF(DataModel datamodel) {

        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numFactors", new int[]{2,5,10,14,18,20});
        paramsGrid.addParam("numIters", new int[]{5,10,15,20,25});
        paramsGrid.addParam("learningRate", new double[]{0.001, 0.005, 0.008, 0.01, 0.1});
        paramsGrid.addParam("regularization", new double[]{0.5,1.5,2.5,3.5,4.5,5.5});
        paramsGrid.addFixedParam("ratings", ratings);


        paramsGrid.addFixedParam("seed", 42L);

        RandomSearchCV randomSearchCV = new RandomSearchCV(datamodel, paramsGrid, DirMF.class, MSE.class, 5, coverage, 42);

        randomSearchCV.fit();
        randomSearchCV.printResults(10, true);


    }
}
