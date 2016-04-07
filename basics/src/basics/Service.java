/*
Holds the Service object's parsing
*/
package basics;

import org.json.JSONObject;

public class Service {
    private String regular, irregular;
    
    public Service(JSONObject json){
        // Parsing
        regular = json.get("regular").toString();
        irregular = json.get("irregular").toString();
    }

    // Getter & Setter
    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public String getIrregular() {
        return irregular;
    }

    public void setIrregular(String irregular) {
        this.irregular = irregular;
    }
}
