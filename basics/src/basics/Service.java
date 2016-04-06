package basics;

import org.json.JSONObject;

public class Service {
    private String regular, irregular;
    
    public Service(JSONObject json){
        regular = json.get("regular").toString();
        irregular = json.get("irregular").toString();
    }

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
