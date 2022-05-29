import es.upm.etsisi.cf4j.data.BenchmarkDataModels;
import es.upm.etsisi.cf4j.data.DataModel;
import es.upm.etsisi.cf4j.data.User;

import java.io.IOException;

public class testUsers {

    public static void main(String[] args) throws IOException {

        DataModel datamodel = BenchmarkDataModels.MovieLens100K();
        int suma = 0;
        for (User a : datamodel.getTestUsers()) {
            suma = suma + a.getNumberOfRatings();
            System.out.printf("\n" + "Id usuario :" + a.getId() + " \t" + "Numero de ratings :" + a.getNumberOfRatings());

        }
        System.out.println("\n" + "total:" + suma);
        System.out.println("numero de usuarios para testing: " + datamodel.getNumberOfTestUsers());

    }
}