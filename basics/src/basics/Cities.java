package basics;

import java.util.ArrayList;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Cities {

    public static ArrayList<String> SwissCities = new ArrayList<String>();
    private static Document rawCities;

    public static void getCities() {
        rawCities = RequestAPI.getInfo("https://en.wikipedia.org/wiki/List_of_cities_in_Switzerland");

        for(Element row: rawCities.select("table.wikitable.sortable tbody tr td:eq(0) a")){
            String name = row.text();
            SwissCities.add(name);
        }

    }
}
