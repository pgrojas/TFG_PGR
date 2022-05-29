import es.upm.etsisi.cf4j.data.BenchmarkDataModels;
import es.upm.etsisi.cf4j.data.DataModel;
import es.upm.etsisi.cf4j.data.Item;
import es.upm.etsisi.cf4j.data.User;
import es.upm.etsisi.cf4j.util.plot.ColumnPlot;
import es.upm.etsisi.cf4j.util.plot.PlotSettings;
import org.nd4j.shade.protobuf.StringValue;
import oshi.json.util.JsonUtil;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class Comprobaciones {


    public static void main(String[] args) throws IOException {
        DataModel datamodel = BenchmarkDataModels.MovieLens100K();

        Map<String, Integer> count = new HashMap<>();

        for (User user : datamodel.getUsers()) {
            for (int pos = 0; pos < user.getNumberOfRatings(); pos++) {
                double rating = user.getRatingAt(pos);
                String key = String.valueOf(rating);
                int num = count.getOrDefault(key, 0);
                count.put(key, num + 1);
            }
        }

        PlotSettings.setyAxisInset(125);
        PlotSettings.setyAxisLabelDistance(3.1);

        ColumnPlot plot =
                new ColumnPlot("Rating value", "Number of ratings")
                        .addColumn("1.0", count.get("1.0"))
                        .addColumn("2.0", count.get("2.0"))
                        .addColumn("3.0", count.get("3.0"))
                        .addColumn("4.0", count.get("4.0"))
                        .addColumn("5.0", count.get("5.0"));

        plot.draw();
        plot.exportPlot("exports/column-plot.png");
        plot.printData("0");
        plot.exportData("exports/column-plot-data.csv");
    }
}