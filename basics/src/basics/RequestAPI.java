/*
This is a collection of methods used to pull info from the internet
*/
package basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class RequestAPI {

    static Document doc;

    // Jsoup HTML getter for wiki, throws IOEx
    public static Document getHTML(String url) throws IOException {
        doc = Jsoup.connect(url).get();
        return doc;
    }

    //String builder to read from InputStream, throws IOEx
    private static String readAll(Reader reader) throws IOException {
        StringBuilder builder = new StringBuilder();
        int cp;
        //While the stream is not empty
        while ((cp = reader.read()) != -1) {
            builder.append((char) cp);
        }
        return builder.toString();
    }

    // Json input stream from URL, throws IO and JSON Ex
    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream input = new URL(url).openStream(); // Open the stream to the URL and read from it
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, Charset.forName("UTF-8")));
        String jsonText = readAll(reader); // Convert the buffer to a string
        JSONObject json = new JSONObject(jsonText); // And then to json
        return json;
    }
}
