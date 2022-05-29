package ranking;


import com.sun.applet2.AppletParameters;
import es.upm.etsisi.cf4j.data.User;
import func.functions;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class rankingMSE {

    protected List<Candidato> ranking;


    public rankingMSE(){

        ranking = new ArrayList<Candidato>(){};
    }

    public void anadir(Candidato nuevo){
        boolean anadido = false;
        // si el ranking esta vacio se le añade
        if (ranking.isEmpty()) {
            ranking.add(nuevo);
        }
        else {
            int index=0;
            while(!anadido && (index<ranking.size())){
                // si el MSEScore del nuevo candidato es menor que el del candidato(index)lo añadimos en su indice, provocando un desplazamiento de todos los elementos hacia la derecha
               if(nuevo.getMse() < ranking.get(index).getMse()) {
                   ranking.add(index, nuevo);
                   anadido = true;
               }
               index++;
            }
            // si no lo hemos añadido lo añadimos al final del arraylist
            if(!anadido)
            ranking.add(ranking.size(), nuevo);
            }
        }




    public void printRanking(){
        int rank = 1;
        for (Candidato a : ranking) {
            System.out.print("Posición: "+ rank +" "+ "Algoritmo: "+a.getNombre()+"ScoreMSE: "+a.getMse());
            System.out.println("\n");
            rank++;
        }
    }


    public void exportJSON(String path){
        JSONArray rankingJson = new JSONArray();
        for (Candidato a : ranking){

         JSONObject o = new JSONObject();
         double puntuacion = a.getMse() + a.getMae() + a.getMax() + a.getRmse()- a.getPerfect();
         o.put("name",a.getNombre());
         o.put("mse", functions.format(a.getMse(),5));
         o.put("mae",functions.format(a.getMae(),5));
         o.put("perfect",functions.format(a.getPerfect(),5));
         o.put("rmse",functions.format(a.getRmse(),5));
         o.put("max",functions.format(a.getMax(),5));
         o.put("Discovery",functions.format(a.getDiscovery(),5));
         o.put("Diversity",functions.format(a.getDiversity(),5));
         o.put("F1",functions.format(a.getF1(),5));
         o.put("NDCG",functions.format(a.getNDCG(),5));
         o.put("Novelty",functions.format(a.getNovelty(),5));
         o.put("Precision",functions.format(a.getPrecision(),5));
         o.put("Recall",functions.format(a.getRecall(),5));
         o.put("Puntuación", functions.format(puntuacion, 5));
         o.put("parametros",a.getParametros());
         rankingJson.put(o);
        }

        try{
            FileWriter file = new FileWriter(path);
            file.write(rankingJson.toString());
            file.flush();
            file.close();

        }catch (IOException e){

        }



    }


}

