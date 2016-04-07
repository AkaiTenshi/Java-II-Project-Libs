/*
This class handles the parsing of the connection 
objects in the query. 
*/
package basics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Connection {

    private Checkpoint toPoint, fromPoint;
    private Service service;
    private ArrayList<String> products = new ArrayList<>();
    private String capacity1st, capacity2nd, duration;
    private ArrayList<Section> sections = new ArrayList<>();

    //Constructor 
    public Connection(JSONObject json) throws IOException, JSONException {

        // Parsing
        JSONObject fromObj = json.getJSONObject("from");
        fromPoint = new Checkpoint(fromObj);
        JSONObject toObj = json.getJSONObject("to");
        toPoint = new Checkpoint(toObj);

        duration = json.getString("duration");

        JSONObject serviceObj = json.getJSONObject("service");
        service = new Service(serviceObj);

        JSONArray productsArr = json.getJSONArray("products");

        products = new ArrayList<>();
        for (int i = 0; i < productsArr.length(); i++) {
            products.add(productsArr.get(i).toString());
        }

        capacity1st = json.get("capacity1st").toString();
        capacity2nd = json.get("capacity2nd").toString();

        JSONArray sectionsArr = json.getJSONArray("sections");
        Iterator sectionsIt = sectionsArr.iterator();
        sections = new ArrayList<>();
        while (sectionsIt.hasNext()) {
            JSONObject sectionObj = (JSONObject) sectionsIt.next();
            sections.add(new Section(sectionObj));
        }
    }

    // Getters & Setters
    public Checkpoint getToPoint() {
        return toPoint;
    }

    public void setToPoint(Checkpoint toPoint) {
        this.toPoint = toPoint;
    }

    public Checkpoint getFromPoint() {
        return fromPoint;
    }

    public void setFromPoint(Checkpoint fromPoint) {
        this.fromPoint = fromPoint;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public ArrayList<String> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<String> products) {
        this.products = products;
    }

    public String getCapacity1st() {
        return capacity1st;
    }

    public void setCapacity1st(String capacity1st) {
        this.capacity1st = capacity1st;
    }

    public String getCapacity2nd() {
        return capacity2nd;
    }

    public void setCapacity2nd(String capacity2nd) {
        this.capacity2nd = capacity2nd;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public ArrayList<Section> getSections() {
        return sections;
    }

    public void setSections(ArrayList<Section> sections) {
        this.sections = sections;
    }
}
