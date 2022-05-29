package matrixFactorization;

import es.upm.etsisi.cf4j.data.BenchmarkDataModels;
import es.upm.etsisi.cf4j.data.DataModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Main3 {
    public static void main(String[] args) throws IOException {

        Properties properties= new Properties();
        try {
            properties.load(new FileInputStream(new File("algorithmRanking.properties")));
            System.out.println(properties.get("USER"));

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();



    }
}
}

