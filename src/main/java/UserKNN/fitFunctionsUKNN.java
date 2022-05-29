package UserKNN;

import es.upm.etsisi.cf4j.data.DataModel;
import es.upm.etsisi.cf4j.recommender.knn.UserKNN;
import func.functions;
import ranking.*;
public class fitFunctionsUKNN {

    public static void cosine(DataModel datamodel, rankingMSE userKnn, rankingMSE general){

        UserKNN cosine = new UserKNN(datamodel,OpMethodsUserKNN.cosine(datamodel));
        System.out.println("\n");
        cosine.fit();
        System.out.println("\n");
        functions.generateQualityMeasures(cosine);
        System.out.println("\n");
        functions.generateQualityMeasuresRecommendation(cosine);
        String param = functions.getParam(cosine);
        Candidato a = new Candidato("UCosine",
                functions.generateMSE(cosine),functions.generateMAE(cosine),functions.generatePerfect(cosine),functions.generateRMSE(cosine),functions.generateMax(cosine),
                functions.generateDiscovery(cosine),functions.generateDiversity(cosine),functions.generateF1(cosine),functions.generateNDCG(cosine),functions.generateNovelty(cosine),functions.generatePrecision(cosine),functions.generateRecall(cosine),param);
        userKnn.anadir(a);
        general.anadir(a);
    }
    public static void adCosine(DataModel datamodel, rankingMSE userKnn, rankingMSE general){

        UserKNN adCosine = new UserKNN(datamodel,OpMethodsUserKNN.adjustedC(datamodel));
        System.out.println("\n");
        adCosine.fit();
        System.out.println("\n");
        functions.generateQualityMeasures(adCosine);
        System.out.println("\n");
        functions.generateQualityMeasuresRecommendation(adCosine);
        String param = functions.getParam(adCosine);
        Candidato a = new Candidato("UAdjusted Cosine",
                functions.generateMSE(adCosine),functions.generateMAE(adCosine),functions.generatePerfect(adCosine),functions.generateRMSE(adCosine),functions.generateMax(adCosine),
                functions.generateDiscovery(adCosine),functions.generateDiversity(adCosine),functions.generateF1(adCosine),functions.generateNDCG(adCosine),functions.generateNovelty(adCosine),functions.generatePrecision(adCosine),functions.generateRecall(adCosine),param);
        userKnn.anadir(a);
        general.anadir(a);
    }
    public static void correlation (DataModel datamodel, rankingMSE userKnn, rankingMSE general){

        UserKNN correlation = new UserKNN(datamodel,OpMethodsUserKNN.correlation(datamodel));
        System.out.println("\n");
        correlation.fit();
        System.out.println("\n");
        functions.generateQualityMeasures(correlation);
        System.out.println("\n");
        functions.generateQualityMeasuresRecommendation(correlation);
        String param = functions.getParam(correlation);
        Candidato a = new Candidato("UCorrelation",
                functions.generateMSE(correlation),functions.generateMAE(correlation),functions.generatePerfect(correlation),functions.generateRMSE(correlation),functions.generateMax(correlation),
                functions.generateDiscovery(correlation),functions.generateDiversity(correlation),functions.generateF1(correlation),functions.generateNDCG(correlation),functions.generateNovelty(correlation),functions.generatePrecision(correlation),functions.generateRecall(correlation),param);
        userKnn.anadir(a);
        general.anadir(a);
    }
    public static void jmsd(DataModel datamodel, rankingMSE userKnn, rankingMSE general){

        UserKNN jmsd = new UserKNN(datamodel,OpMethodsUserKNN.jmsd(datamodel));
        System.out.println("\n");
        jmsd.fit();
        System.out.println("\n");
        functions.generateQualityMeasures(jmsd);
        System.out.println("\n");
        functions.generateQualityMeasuresRecommendation(jmsd);
        String param = functions.getParam(jmsd);
        Candidato a = new Candidato("UJMSD",
                functions.generateMSE(jmsd),functions.generateMAE(jmsd),functions.generatePerfect(jmsd),functions.generateRMSE(jmsd),functions.generateMax(jmsd),
                functions.generateDiscovery(jmsd),functions.generateDiversity(jmsd),functions.generateF1(jmsd),functions.generateNDCG(jmsd),functions.generateNovelty(jmsd),functions.generatePrecision(jmsd),functions.generateRecall(jmsd),param);
        userKnn.anadir(a);
        general.anadir(a);
    }
    public static void jaccard(DataModel datamodel, rankingMSE userKnn, rankingMSE general){

        UserKNN jaccard = new UserKNN(datamodel,OpMethodsUserKNN.jaccard(datamodel));
        System.out.println("\n");
        jaccard.fit();
        System.out.println("\n");
        functions.generateQualityMeasures(jaccard);
        System.out.println("\n");
        functions.generateQualityMeasuresRecommendation(jaccard);
        String param = functions.getParam(jaccard);
        Candidato a = new Candidato("UJaccard",
                functions.generateMSE(jaccard),functions.generateMAE(jaccard),functions.generatePerfect(jaccard),functions.generateRMSE(jaccard),functions.generateMax(jaccard),
                functions.generateDiscovery(jaccard),functions.generateDiversity(jaccard),functions.generateF1(jaccard),functions.generateNDCG(jaccard),functions.generateNovelty(jaccard),functions.generatePrecision(jaccard),functions.generateRecall(jaccard),param);
        userKnn.anadir(a);
        general.anadir(a);
    }
    public static void msd(DataModel datamodel, rankingMSE userKnn, rankingMSE general){

        UserKNN msd = new UserKNN(datamodel,OpMethodsUserKNN.msd(datamodel));
        System.out.println("\n");
        msd.fit();
        System.out.println("\n");
        functions.generateQualityMeasures(msd);
        System.out.println("\n");
        functions.generateQualityMeasuresRecommendation(msd);
        String param = functions.getParam(msd);
        Candidato a = new Candidato("UMSD",
                functions.generateMSE(msd),functions.generateMAE(msd),functions.generatePerfect(msd),functions.generateRMSE(msd),functions.generateMax(msd),
                functions.generateDiscovery(msd),functions.generateDiversity(msd),functions.generateF1(msd),functions.generateNDCG(msd),functions.generateNovelty(msd),functions.generatePrecision(msd),functions.generateRecall(msd),param);
        userKnn.anadir(a);
        general.anadir(a);
    }
    public static void pip(DataModel datamodel, rankingMSE userKnn, rankingMSE general){

        UserKNN pip = new UserKNN(datamodel,OpMethodsUserKNN.pip(datamodel));
        System.out.println("\n");
        pip.fit();
        System.out.println("\n");
        functions.generateQualityMeasures(pip);
        System.out.println("\n");
        functions.generateQualityMeasuresRecommendation(pip);
        String param = functions.getParam(pip);
        Candidato a = new Candidato("UPIP",
                functions.generateMSE(pip),functions.generateMAE(pip),functions.generatePerfect(pip),functions.generateRMSE(pip),functions.generateMax(pip),
                functions.generateDiscovery(pip),functions.generateDiversity(pip),functions.generateF1(pip),functions.generateNDCG(pip),functions.generateNovelty(pip),functions.generatePrecision(pip),functions.generateRecall(pip),param);
        userKnn.anadir(a);
        general.anadir(a);
    }
    public static void sRank(DataModel datamodel, rankingMSE userKnn, rankingMSE general){

        UserKNN sRank = new UserKNN(datamodel,OpMethodsUserKNN.sRank(datamodel));
        System.out.println("\n");
        sRank.fit();
        System.out.println("\n");
        functions.generateQualityMeasures(sRank);
        System.out.println("\n");
        functions.generateQualityMeasuresRecommendation(sRank);
        String param = functions.getParam(sRank);
        Candidato a = new Candidato("USpearmanRank",
                functions.generateMSE(sRank),functions.generateMAE(sRank),functions.generatePerfect(sRank),functions.generateRMSE(sRank),functions.generateMax(sRank),
                functions.generateDiscovery(sRank),functions.generateDiversity(sRank),functions.generateF1(sRank),functions.generateNDCG(sRank),functions.generateNovelty(sRank),functions.generatePrecision(sRank),functions.generateRecall(sRank),param);
        userKnn.anadir(a);
        general.anadir(a);
    }
    public static void correlationCons(DataModel datamodel, double median, rankingMSE userKnn, rankingMSE general){

        UserKNN correlationCons = new UserKNN(datamodel,OpMethodsUserKNN.correlationCons(datamodel,median));
        System.out.println("\n");
        correlationCons.fit();
        System.out.println("\n");
        functions.generateQualityMeasures(correlationCons);
        System.out.println("\n");
        functions.generateQualityMeasuresRecommendation(correlationCons);
        String param = functions.getParam(correlationCons);
        Candidato a = new Candidato("UCorrelation Constrained",
                functions.generateMSE(correlationCons),functions.generateMAE(correlationCons),functions.generatePerfect(correlationCons),functions.generateRMSE(correlationCons),functions.generateMax(correlationCons),
                functions.generateDiscovery(correlationCons),functions.generateDiversity(correlationCons),functions.generateF1(correlationCons),functions.generateNDCG(correlationCons),functions.generateNovelty(correlationCons),functions.generatePrecision(correlationCons),functions.generateRecall(correlationCons),param);
        userKnn.anadir(a);
        general.anadir(a);
    }
    public static void singularities(DataModel datamodel,double [] relevant, double [] notRelevant, rankingMSE userKnn, rankingMSE general){

        UserKNN singularities = new UserKNN(datamodel,OpMethodsUserKNN.singularaties(datamodel,relevant,notRelevant));
        System.out.println("\n");
        singularities.fit();
        System.out.println("\n");
        functions.generateQualityMeasures(singularities);
        System.out.println("\n");
        functions.generateQualityMeasuresRecommendation(singularities);
        String param = functions.getParam(singularities);
        Candidato a = new Candidato("USingularities",
                functions.generateMSE(singularities),functions.generateMAE(singularities),functions.generatePerfect(singularities),functions.generateRMSE(singularities),functions.generateMax(singularities),
                functions.generateDiscovery(singularities),functions.generateDiversity(singularities),functions.generateF1(singularities),functions.generateNDCG(singularities),functions.generateNovelty(singularities),functions.generatePrecision(singularities),functions.generateRecall(singularities),param);
        userKnn.anadir(a);
        general.anadir(a);
    }

    public static void cjmsd(DataModel datamodel, rankingMSE userKnn, rankingMSE general){

        UserKNN cjmsd = new UserKNN(datamodel,OpMethodsUserKNN.cjmsd(datamodel));
        System.out.println("\n");
        cjmsd.fit();
        System.out.println("\n");
        functions.generateQualityMeasures(cjmsd);
        System.out.println("\n");
        functions.generateQualityMeasuresRecommendation(cjmsd);
        String param = functions.getParam(cjmsd);
        Candidato a = new Candidato("UCJMSD",
                functions.generateMSE(cjmsd),functions.generateMAE(cjmsd),functions.generatePerfect(cjmsd),functions.generateRMSE(cjmsd),functions.generateMax(cjmsd),
                functions.generateDiscovery(cjmsd),functions.generateDiversity(cjmsd),functions.generateF1(cjmsd),functions.generateNDCG(cjmsd),functions.generateNovelty(cjmsd),functions.generatePrecision(cjmsd),functions.generateRecall(cjmsd),param);
        userKnn.anadir(a);
        general.anadir(a);
    }

}
