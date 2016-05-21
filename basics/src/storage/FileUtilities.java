package storage;

import basics.DirectLink;
import basics.Location;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FileUtilities {

    public static void writeCitiesToFile(String filename, boolean overwrite, ArrayList<Location> cities) throws IOException {
        FileWriter fw = new FileWriter(filename, !overwrite); // For FileWriter true = append, false = overwrite, so we flip the value.
        BufferedWriter buff = new BufferedWriter(fw);
        String coordConvertor;
        
        // Write the values of the array to the file
        for (int i = 0; i <= cities.size() - 1; i++) {
            buff.write(Integer.toString(cities.get(i).getId()));
            buff.write("|");
            buff.write(cities.get(i).getName());
            buff.write("|");
            coordConvertor = Double.toString(cities.get(i).getCoord().getX());
            buff.write(coordConvertor);
            buff.write("|");
            coordConvertor = Double.toString(cities.get(i).getCoord().getY());
            buff.write(coordConvertor);
            //buff.write(cities.get(i).getType()); The WEB API returns null sometimes to this so I dont use it in the file.
            buff.newLine();
        }

        buff.close();
    }

    public static void writeConnectionsToFile(String filename, boolean overwrite, ArrayList<DirectLink> links) throws IOException {
        FileWriter fw = new FileWriter(filename, !overwrite); // For FileWriter true = append, false = overwrite, so we flip the value.
        BufferedWriter buff = new BufferedWriter(fw);
       
        // While the result set is not empty read the values from the DB to the Array
        for (int i = 0; i <= links.size() - 1; i++) {
            buff.write(links.get(i).getFrom());
            buff.write("|");
            buff.write(links.get(i).getTo());
            buff.write("|");
            buff.write(links.get(i).getType());
            buff.newLine();
        }

        buff.close();
    }

    public static ArrayList<Location> readCitiesFromFile(String filename) throws IOException {
        ArrayList<Location> arrayFromFile = new ArrayList<>();

        FileReader fr = new FileReader(filename);
        BufferedReader buff = new BufferedReader(fr);
        String line;
        
        // Read the lines from file, tokenize them and store them to the array
        while ((line = buff.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line, "|");
            while (st.hasMoreElements()) {
                int Id = Integer.parseInt(st.nextToken().replaceAll("\\p{C}", ""));// We use this regex to drop all non-visible unicode characters that get added
                String Name = st.nextToken().replaceAll("\\p{C}", "");
                double cordX = Double.parseDouble(st.nextToken().replaceAll("\\p{C}", ""));
                double cordY = Double.parseDouble(st.nextToken().replaceAll("\\p{C}", ""));
                //String Type = st.nextElement().toString();
                arrayFromFile.add(new Location(Id, Name, cordX, cordY, null));
            }
        }

        buff.close();

        return arrayFromFile;
    }

    public static ArrayList<DirectLink> readConnectionsFromFile(String filename) throws IOException {
        ArrayList<DirectLink> linksFromFile = new ArrayList<>();

        FileReader fr = new FileReader(filename);
        BufferedReader buff = new BufferedReader(fr);
        String line;

        //Read the lines from file, tokenize them and store them to the array
        while ((line = buff.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line, "|");
            while (st.hasMoreElements()) {
                String fromPointName = st.nextToken().replaceAll("\\p{C}", ""); // We use this regex to drop all non-visible unicode characters that get added
                String toPointName = st.nextToken().replaceAll("\\p{C}", "");
                String type = st.nextToken().replaceAll("\\p{C}", "");
                linksFromFile.add(new DirectLink(fromPointName, toPointName, type));
            }
        }

        buff.close();

        return linksFromFile;
    }
}
