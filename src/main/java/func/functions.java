package func;

import es.upm.etsisi.cf4j.qualityMeasure.prediction.*;
import es.upm.etsisi.cf4j.qualityMeasure.recommendation.*;
import es.upm.etsisi.cf4j.recommender.Recommender;


public class functions {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static Double format(Double numero, Integer numeroDecimales) {
        return Math.round(numero * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales);
    }

    public static void generateQualityMeasures(Recommender rec){

    System.out.println(
            ANSI_RED+"MSE:"+ANSI_RESET+ new MSE(rec).getScore() + "\n"+
                    "Coverage:"+new Coverage(rec).getScore()+ "\n"+
                    "MAE:"+new MAE(rec).getScore()+ "\n"+
                    "MSLE:"+ new MSLE(rec).getScore()+ "\n"+
                    "MAX:" + new Max(rec).getScore()+ "\n"+
                    "RMSE:"+new RMSE(rec).getScore()+ "\n"+
                    "R2:"+new R2(rec).getScore()+ "\n"+
                    "Perfect:"+ new Perfect(rec,1.0).getScore()
    );


}
    public static double generateMSE(Recommender rec){return new MSE(rec).getScore();}

    public static double generateMAE(Recommender rec){
        return new MAE(rec).getScore();
    }

    public static double generateRMSE(Recommender rec){return new RMSE(rec).getScore();}

    public static double generatePerfect(Recommender rec){
        return new Perfect(rec,0.1).getScore();
    }

    public static double generateMax(Recommender rec){
        return new Max(rec).getScore();
    }

    public static String getParam(Recommender rec){
        String aux = rec.toString();
        String resul = aux.substring(aux.indexOf("(")+1,aux.indexOf(")"));
        return resul;
    }

   public static void generateQualityMeasuresRecommendation(Recommender rec){

        System.out.println(
                        "Discovery:" + new Discovery(rec,10).getScore() + "\n"+
                        "Diversity:"+new Diversity(rec,10).getScore()+ "\n"+
                        "F1:"+new F1(rec,10,4).getScore()+ "\n"+
                        "NDCG:"+ new NDCG(rec,10).getScore()+ "\n"+
                        "Novelty:" + new Novelty(rec,10).getScore()+ "\n"+
                        "Precision:"+new Precision(rec,10,4).getScore()+ "\n"+
                        "Recall:"+new Recall(rec,10,4).getScore()+ "\n"

        );

    }

    public static double generateDiscovery(Recommender rec){
        return new Discovery(rec,10).getScore();
    }
    public static double generateDiversity(Recommender rec){
        return new Diversity(rec,10).getScore();
    }
    public static double generateF1(Recommender rec){
        return new F1(rec,10,4).getScore();
    }
    public static double generateNDCG(Recommender rec){
        return new NDCG(rec,10).getScore();
    }
    public static double generateNovelty(Recommender rec){
        return new Novelty(rec,10).getScore();
    }
    public static double generatePrecision(Recommender rec){
        return new Precision(rec,10,4).getScore();
    }
    public static double generateRecall(Recommender rec){
        return new Recall(rec,10,4).getScore();
    }

}
