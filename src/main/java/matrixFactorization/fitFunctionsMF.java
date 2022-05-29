package matrixFactorization;

import ranking.Candidato;
import ranking.rankingMSE;
import func.functions;
import es.upm.etsisi.cf4j.data.DataModel;
import es.upm.etsisi.cf4j.recommender.matrixFactorization.*;


public class fitFunctionsMF {

/* Esta clase contiene todos los métodos de entrenamiento de todos los algoritmos de MF*/

    //ready
    public static void PMFfit(DataModel datamodel,rankingMSE mf, rankingMSE general){

    PMF pmf = new PMF (datamodel,OptimizationMethods.OPPMF(datamodel));
    System.out.println("\n");
    pmf.fit();
    System.out.println("\n");
    functions.generateQualityMeasures(pmf);
    String param = functions.getParam(pmf);
    Candidato a = new Candidato("PMF",
            functions.generateMSE(pmf), functions.generateMAE(pmf), functions.generatePerfect(pmf), functions.generateRMSE(pmf), functions.generateMax(pmf),
            functions.generateDiscovery(pmf),functions.generateDiversity(pmf),functions.generateF1(pmf),functions.generateNDCG(pmf),functions.generateNovelty(pmf),functions.generatePrecision(pmf),functions.generateRecall(pmf),param);
    mf.anadir(a);
    general.anadir(a);
    /*
        predictions = pmf.predict(datamodel.getTestUser(8));
        for (int i=0; i < predictions.length; i++){
            System.out.println("Predicción "+ i + " :"+ predictions[i]);
        }

        System.out.println("Predicciones totales : " + datamodel.getTestUser(8).getNumberOfTestRatings());

     */
    }

    //ready
    public static void BiasedMFfit(DataModel datamodel,rankingMSE mf, rankingMSE general){

        BiasedMF biasedMF = new BiasedMF (datamodel,OptimizationMethods.OPBiasedMF(datamodel));
        System.out.println("\n");
        biasedMF.fit();
        System.out.println("\n");
        functions.generateQualityMeasures(biasedMF);
        String param = functions.getParam(biasedMF);
        Candidato a = new Candidato("BiasedMF",
                functions.generateMSE(biasedMF), functions.generateMAE(biasedMF), functions.generatePerfect(biasedMF), functions.generateRMSE(biasedMF), functions.generateMax(biasedMF),
                functions.generateDiscovery(biasedMF),functions.generateDiversity(biasedMF),functions.generateF1(biasedMF),functions.generateNDCG(biasedMF),functions.generateNovelty(biasedMF),functions.generatePrecision(biasedMF),functions.generateRecall(biasedMF),param);
        mf.anadir(a);
        general.anadir(a);
    }
    //ready
    public static void BeMFfit(DataModel datamodel,rankingMSE mf, rankingMSE general, double [] ratings){

        BeMF beMF = new BeMF (datamodel,OptimizationMethods.OPBeMF(datamodel,ratings));

        System.out.println("\n");
        beMF.fit();
        System.out.println("\n");
        functions.generateQualityMeasures(beMF);
        String param = functions.getParam(beMF);
        Candidato a = new Candidato("BeMF",
                functions.generateMSE(beMF), functions.generateMAE(beMF), functions.generatePerfect(beMF), functions.generateRMSE(beMF), functions.generateMax(beMF),
                functions.generateDiscovery(beMF),functions.generateDiversity(beMF),functions.generateF1(beMF),functions.generateNDCG(beMF),functions.generateNovelty(beMF),functions.generatePrecision(beMF),functions.generateRecall(beMF),param);
        mf.anadir(a);
        general.anadir(a);
    }
    public static void BNMFfit(DataModel datamodel,rankingMSE mf, rankingMSE general){

        BNMF bnmf = new BNMF (datamodel,OptimizationMethods.OPBNMF(datamodel));

        System.out.println("\n");
        bnmf.fit();
        System.out.println("\n");
        functions.generateQualityMeasures(bnmf);
        String param = functions.getParam(bnmf);
        Candidato a = new Candidato("BNMF",
                functions.generateMSE(bnmf), functions.generateMAE(bnmf), functions.generatePerfect(bnmf), functions.generateRMSE(bnmf), functions.generateMax(bnmf),
                functions.generateDiscovery(bnmf),functions.generateDiversity(bnmf),functions.generateF1(bnmf),functions.generateNDCG(bnmf),functions.generateNovelty(bnmf),functions.generatePrecision(bnmf),functions.generateRecall(bnmf),param);
        mf.anadir(a);
        general.anadir(a);
    }

    public static void HPFfit(DataModel datamodel,rankingMSE mf, rankingMSE general){

        HPF hpf = new HPF(datamodel,OptimizationMethods.OPHPF(datamodel));

        System.out.println("\n");
        hpf.fit();
        System.out.println("\n");
        functions.generateQualityMeasures(hpf);
        String param = functions.getParam(hpf);
        Candidato a = new Candidato("HPF",
                functions.generateMSE(hpf), functions.generateMAE(hpf), functions.generatePerfect(hpf), functions.generateRMSE(hpf), functions.generateMax(hpf),
                functions.generateDiscovery(hpf),functions.generateDiversity(hpf),functions.generateF1(hpf),functions.generateNDCG(hpf),functions.generateNovelty(hpf),functions.generatePrecision(hpf),functions.generateRecall(hpf),param);
        mf.anadir(a);
        general.anadir(a);
    }
    //ready
    public static void NMFfit(DataModel datamodel,rankingMSE mf, rankingMSE general){
        //3510 //57
        //4615 //57
        NMF nmf = new NMF(datamodel, OptimizationMethods.OPNMF(datamodel));
        System.out.println("\n");
        nmf.fit();
        System.out.println("\n");
        functions.generateQualityMeasures(nmf);
        String param = functions.getParam(nmf);
        Candidato a = new Candidato("NMF",
                functions.generateMSE(nmf), functions.generateMAE(nmf), functions.generatePerfect(nmf), functions.generateRMSE(nmf), functions.generateMax(nmf),
                functions.generateDiscovery(nmf),functions.generateDiversity(nmf),functions.generateF1(nmf),functions.generateNDCG(nmf),functions.generateNovelty(nmf),functions.generatePrecision(nmf),functions.generateRecall(nmf),param);
        mf.anadir(a);
        general.anadir(a);
    }
    public static void SVDPlusfit(DataModel datamodel,rankingMSE mf, rankingMSE general){

        SVDPlusPlus svd = new SVDPlusPlus(datamodel, OptimizationMethods.OPSVD(datamodel));

        System.out.println("\n");
        svd.fit();
        System.out.println("\n");
        functions.generateQualityMeasures(svd);
        String param = functions.getParam(svd);
        Candidato a = new Candidato("SVDPlusPlus",
                functions.generateMSE(svd), functions.generateMAE(svd), functions.generatePerfect(svd), functions.generateRMSE(svd), functions.generateMax(svd),
                functions.generateDiscovery(svd),functions.generateDiversity(svd),functions.generateF1(svd),functions.generateNDCG(svd),functions.generateNovelty(svd),functions.generatePrecision(svd),functions.generateRecall(svd),param);
        mf.anadir(a);
        general.anadir(a);
    }
    public static void URPfit(DataModel datamodel,rankingMSE mf, rankingMSE general, double [] ratings){

        URP urp = new URP(datamodel,OptimizationMethods.OPBURP(datamodel,ratings));

        System.out.println("\n");
        urp.fit();
        System.out.println("\n");
        functions.generateQualityMeasures(urp);
        String param = functions.getParam(urp);
        Candidato a = new Candidato("URP",
                functions.generateMSE(urp), functions.generateMAE(urp), functions.generatePerfect(urp), functions.generateRMSE(urp), functions.generateMax(urp),
                functions.generateDiscovery(urp),functions.generateDiversity(urp),functions.generateF1(urp),functions.generateNDCG(urp),functions.generateNovelty(urp),functions.generatePrecision(urp),functions.generateRecall(urp),param);
        mf.anadir(a);
        general.anadir(a);
    }

    public static void DirMF(DataModel datamodel,rankingMSE mf, rankingMSE general, double [] ratings){

        DirMF dirMF = new DirMF (datamodel, OptimizationMethods.OPDirMF(datamodel,ratings));

        System.out.println("\n");
        dirMF.fit();
        System.out.println("\n");
        functions.generateQualityMeasures(dirMF);
        String param = functions.getParam(dirMF);
        Candidato a = new Candidato("DirMF",
                functions.generateMSE(dirMF), functions.generateMAE(dirMF), functions.generatePerfect(dirMF), functions.generateRMSE(dirMF), functions.generateMax(dirMF),
                functions.generateDiscovery(dirMF),functions.generateDiversity(dirMF),functions.generateF1(dirMF),functions.generateNDCG(dirMF),functions.generateNovelty(dirMF),functions.generatePrecision(dirMF),functions.generateRecall(dirMF),param);

        general.anadir(a);
    }
}
