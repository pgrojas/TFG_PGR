package ItemKNN;

import es.upm.etsisi.cf4j.data.DataModel;
import es.upm.etsisi.cf4j.recommender.knn.ItemKNN;
import es.upm.etsisi.cf4j.recommender.knn.itemSimilarityMetric.*;
import func.functions;
import ranking.Candidato;
import ranking.rankingMSE;

public class fitFunctions2ItemKNN {
    public static void cosine(DataModel datamodel, rankingMSE itemKnn, rankingMSE general){
        ItemSimilarityMetric cos = new Cosine();
        ItemKNN cosine = new ItemKNN(datamodel,1000,cos,ItemKNN.AggregationApproach.WEIGHTED_MEAN);
        System.out.println("\n");
        cosine.fit();
        System.out.println("\n");
        functions.generateQualityMeasures(cosine);
        System.out.println("\n");
        functions.generateQualityMeasuresRecommendation(cosine);
        String param = functions.getParam(cosine);
        Candidato a = new Candidato("ICosine",
                functions.generateMSE(cosine),functions.generateMAE(cosine),functions.generatePerfect(cosine),functions.generateRMSE(cosine),functions.generateMax(cosine),
                functions.generateDiscovery(cosine),functions.generateDiversity(cosine),functions.generateF1(cosine),functions.generateNDCG(cosine),functions.generateNovelty(cosine),functions.generatePrecision(cosine),functions.generateRecall(cosine),param);
        itemKnn.anadir(a);
        general.anadir(a);
    }
    public static void adCosine(DataModel datamodel, rankingMSE itemKnn, rankingMSE general){
        ItemSimilarityMetric adCos = new AdjustedCosine();
        ItemKNN adCosine = new ItemKNN(datamodel,550,adCos,ItemKNN.AggregationApproach.MEAN);
        System.out.println("\n");
        adCosine.fit();
        System.out.println("\n");
        functions.generateQualityMeasures(adCosine);
        System.out.println("\n");
        functions.generateQualityMeasuresRecommendation(adCosine);
        String param = functions.getParam(adCosine);
        Candidato a = new Candidato("IAdjusted Cosine",
                functions.generateMSE(adCosine),functions.generateMAE(adCosine),functions.generatePerfect(adCosine),functions.generateRMSE(adCosine),functions.generateMax(adCosine),
                functions.generateDiscovery(adCosine),functions.generateDiversity(adCosine),functions.generateF1(adCosine),functions.generateNDCG(adCosine),functions.generateNovelty(adCosine),functions.generatePrecision(adCosine),functions.generateRecall(adCosine),param);
        itemKnn.anadir(a);
        general.anadir(a);
    }
    public static void correlation (DataModel datamodel, rankingMSE itemKnn, rankingMSE general){
        ItemSimilarityMetric corr = new Correlation();
        ItemKNN correlation = new ItemKNN(datamodel,750,corr,ItemKNN.AggregationApproach.MEAN);
        System.out.println("\n");
        correlation.fit();
        System.out.println("\n");
        functions.generateQualityMeasures(correlation);
        System.out.println("\n");
        functions.generateQualityMeasuresRecommendation(correlation);
        String param = functions.getParam(correlation);
        Candidato a = new Candidato("ICorrelation",
                functions.generateMSE(correlation),functions.generateMAE(correlation),functions.generatePerfect(correlation),functions.generateRMSE(correlation),functions.generateMax(correlation),
                functions.generateDiscovery(correlation),functions.generateDiversity(correlation),functions.generateF1(correlation),functions.generateNDCG(correlation),functions.generateNovelty(correlation),functions.generatePrecision(correlation),functions.generateRecall(correlation),param);
        itemKnn.anadir(a);
        general.anadir(a);
    }
    public static void jmsd(DataModel datamodel, rankingMSE itemKnn, rankingMSE general){
        ItemSimilarityMetric jms = new JMSD();
        ItemKNN jmsd = new ItemKNN(datamodel,150,jms,ItemKNN.AggregationApproach.WEIGHTED_MEAN);

        System.out.println("\n");
        jmsd.fit();
        System.out.println("\n");
        functions.generateQualityMeasures(jmsd);
        System.out.println("\n");
        functions.generateQualityMeasuresRecommendation(jmsd);
        String param = functions.getParam(jmsd);
        Candidato a = new Candidato("IJMSD",
                functions.generateMSE(jmsd),functions.generateMAE(jmsd),functions.generatePerfect(jmsd),functions.generateRMSE(jmsd),functions.generateMax(jmsd),
                functions.generateDiscovery(jmsd),functions.generateDiversity(jmsd),functions.generateF1(jmsd),functions.generateNDCG(jmsd),functions.generateNovelty(jmsd),functions.generatePrecision(jmsd),functions.generateRecall(jmsd),param);
        itemKnn.anadir(a);
        general.anadir(a);
    }
    public static void jaccard(DataModel datamodel, rankingMSE itemKnn, rankingMSE general){
        ItemSimilarityMetric jacc = new Jaccard();
        ItemKNN jaccard = new ItemKNN(datamodel,150,jacc,ItemKNN.AggregationApproach.WEIGHTED_MEAN);
        System.out.println("\n");
        jaccard.fit();
        System.out.println("\n");
        functions.generateQualityMeasures(jaccard);
        System.out.println("\n");
        functions.generateQualityMeasuresRecommendation(jaccard);
        String param = functions.getParam(jaccard);
        Candidato a = new Candidato("IJaccard",
                functions.generateMSE(jaccard),functions.generateMAE(jaccard),functions.generatePerfect(jaccard),functions.generateRMSE(jaccard),functions.generateMax(jaccard),
                functions.generateDiscovery(jaccard),functions.generateDiversity(jaccard),functions.generateF1(jaccard),functions.generateNDCG(jaccard),functions.generateNovelty(jaccard),functions.generatePrecision(jaccard),functions.generateRecall(jaccard),param);
        itemKnn.anadir(a);
        general.anadir(a);
    }
    public static void msd(DataModel datamodel, rankingMSE itemKnn, rankingMSE general){
        ItemSimilarityMetric ms = new MSD();
        ItemKNN msd = new ItemKNN(datamodel,650,ms,ItemKNN.AggregationApproach.WEIGHTED_MEAN);
        System.out.println("\n");
        msd.fit();
        System.out.println("\n");
        functions.generateQualityMeasures(msd);
        System.out.println("\n");
        functions.generateQualityMeasuresRecommendation(msd);
        String param = functions.getParam(msd);
        Candidato a = new Candidato("IMSD",
                functions.generateMSE(msd),functions.generateMAE(msd),functions.generatePerfect(msd),functions.generateRMSE(msd),functions.generateMax(msd),
                functions.generateDiscovery(msd),functions.generateDiversity(msd),functions.generateF1(msd),functions.generateNDCG(msd),functions.generateNovelty(msd),functions.generatePrecision(msd),functions.generateRecall(msd),param);
        itemKnn.anadir(a);
        general.anadir(a);
    }
    public static void pip(DataModel datamodel, rankingMSE itemKnn, rankingMSE general){
        ItemSimilarityMetric pi = new PIP();
        ItemKNN pip = new ItemKNN(datamodel,500,pi,ItemKNN.AggregationApproach.WEIGHTED_MEAN);

        System.out.println("\n");
        pip.fit();
        System.out.println("\n");
        functions.generateQualityMeasures(pip);
        System.out.println("\n");
        functions.generateQualityMeasuresRecommendation(pip);
        String param = functions.getParam(pip);
        Candidato a = new Candidato("IPIP",
                functions.generateMSE(pip),functions.generateMAE(pip),functions.generatePerfect(pip),functions.generateRMSE(pip),functions.generateMax(pip),
                functions.generateDiscovery(pip),functions.generateDiversity(pip),functions.generateF1(pip),functions.generateNDCG(pip),functions.generateNovelty(pip),functions.generatePrecision(pip),functions.generateRecall(pip),param);
        itemKnn.anadir(a);
        general.anadir(a);
    }
    public static void sRank(DataModel datamodel, rankingMSE itemKnn, rankingMSE general){
        ItemSimilarityMetric srank = new SpearmanRank();
        ItemKNN sRank = new ItemKNN(datamodel,150,srank,ItemKNN.AggregationApproach.MEAN);
        System.out.println("\n");
        sRank.fit();
        System.out.println("\n");
        functions.generateQualityMeasures(sRank);
        System.out.println("\n");
        functions.generateQualityMeasuresRecommendation(sRank);
        String param = functions.getParam(sRank);
        Candidato a = new Candidato("ISpearmanRank",
                functions.generateMSE(sRank),functions.generateMAE(sRank),functions.generatePerfect(sRank),functions.generateRMSE(sRank),functions.generateMax(sRank),
                functions.generateDiscovery(sRank),functions.generateDiversity(sRank),functions.generateF1(sRank),functions.generateNDCG(sRank),functions.generateNovelty(sRank),functions.generatePrecision(sRank),functions.generateRecall(sRank),param);
        itemKnn.anadir(a);
        general.anadir(a);
    }
    public static void correlationCons(DataModel datamodel, double median, rankingMSE itemKnn, rankingMSE general){
        ItemSimilarityMetric correC = new CorrelationConstrained(median);
        ItemKNN correlationCons = new ItemKNN(datamodel,550,correC,ItemKNN.AggregationApproach.MEAN);
        System.out.println("\n");
        correlationCons.fit();
        System.out.println("\n");
        functions.generateQualityMeasures(correlationCons);
        System.out.println("\n");
        functions.generateQualityMeasuresRecommendation(correlationCons);
        String param = functions.getParam(correlationCons);
        Candidato a = new Candidato("ICorrelation Constrained",
                functions.generateMSE(correlationCons),functions.generateMAE(correlationCons),functions.generatePerfect(correlationCons),functions.generateRMSE(correlationCons),functions.generateMax(correlationCons),
                functions.generateDiscovery(correlationCons),functions.generateDiversity(correlationCons),functions.generateF1(correlationCons),functions.generateNDCG(correlationCons),functions.generateNovelty(correlationCons),functions.generatePrecision(correlationCons),functions.generateRecall(correlationCons),param);
        itemKnn.anadir(a);
        general.anadir(a);
    }
    public static void singularities(DataModel datamodel,double [] relevant, double [] notRelevant, rankingMSE itemKnn, rankingMSE general){
        ItemSimilarityMetric sing = new Singularities(relevant,notRelevant);
        ItemKNN singularities = new ItemKNN(datamodel,200,sing,ItemKNN.AggregationApproach.WEIGHTED_MEAN);

        System.out.println("\n");
        singularities.fit();
        System.out.println("\n");
        functions.generateQualityMeasures(singularities);
        System.out.println("\n");
        functions.generateQualityMeasuresRecommendation(singularities);
        String param = functions.getParam(singularities);
        Candidato a = new Candidato("ISingularities",
                functions.generateMSE(singularities),functions.generateMAE(singularities),functions.generatePerfect(singularities),functions.generateRMSE(singularities),functions.generateMax(singularities),
                functions.generateDiscovery(singularities),functions.generateDiversity(singularities),functions.generateF1(singularities),functions.generateNDCG(singularities),functions.generateNovelty(singularities),functions.generatePrecision(singularities),functions.generateRecall(singularities),param);
        itemKnn.anadir(a);
        general.anadir(a);
    }
}
