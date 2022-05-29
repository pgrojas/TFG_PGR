package ranking;


public class Candidato {

    private String nombre;
    private double mse;
    private double mae;
    private double perfect;
    private double rmse;
    private double max;
    private double discovery;
    private double diversity;
    private double f1;
    private double NDCG;
    private double novelty;
    private double precision;
    private double recall;
    private String parametros;


    public Candidato(String nombre, double mse, double mae, double perfect, double rmse, double max, double discovery, double diversity, double f1, double NDCG, double novelty, double precision, double recall,  String parametros){
        this.nombre = nombre;
        this.mse = mse;
        this.mae = mae;
        this.perfect = perfect;
        this.rmse = rmse;
        this.max = max;
        this.discovery = discovery;
        this.diversity = diversity;
        this.f1 = f1;
        this.NDCG = NDCG;
        this.novelty = novelty;
        this.precision = precision;
        this.recall = recall;

        this.parametros = parametros;
    }

    public double getMse() {
        return mse;
    }

    public double getMax() {
        return max;
    }

    public double getPerfect() {
        return perfect;
    }

    public double getRmse() {
        return rmse;
    }

    public double getMae() {
        return mae;
    }

    public String getNombre() {
        return nombre;
    }

    public String getParametros(){return parametros;}

    public double getDiscovery() {
        return discovery;
    }

    public double getDiversity() {
        return diversity;
    }
    public double getF1(){
        return f1;
    }

    public double getNDCG() {
        return NDCG;
    }

    public double getNovelty() {
        return novelty;
    }

    public double getPrecision() {
        return precision;
    }

    public double getRecall() {
        return recall;
    }
}

