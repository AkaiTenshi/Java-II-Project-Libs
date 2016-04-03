package basics;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class RequestAPI {
    static Document doc;
    public static Document getInfo(String url){
        try{
            doc = Jsoup.connect(url).get();
        }
        catch(IOException ex){
            Logger.getLogger(RequestAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doc;
    }
}
