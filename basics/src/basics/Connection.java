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
    private Iterator connectionIt;
    private ArrayList<Connection> connectionArray = new ArrayList<>();

    public Connection(int fromID, int toID) throws IOException, JSONException {
        JSONObject json = RequestAPI.readJsonFromUrl("http://transport.opendata.ch/v1/connections?from=" + fromID + "&to=" + toID + "&direct=1");
        JSONArray connections = json.getJSONArray("connections");

        connectionIt = connections.iterator();
        while (connectionIt.hasNext()) {
            JSONObject connectionObj = (JSONObject) connectionIt.next();

            JSONObject fromObj = connectionObj.getJSONObject("from");
            fromPoint = new Checkpoint(fromObj);
            JSONObject toObj = connectionObj.getJSONObject("to");
            toPoint = new Checkpoint(toObj);

            duration = connectionObj.getString("duration");

            JSONObject serviceObj = connectionObj.getJSONObject("service");
            service = new Service(serviceObj);

            JSONArray productsArr = connectionObj.getJSONArray("products");
            
            for (int i = 0; i < productsArr.length(); i++) {
                products.add(productsArr.get(i).toString());
            }

            capacity1st = connectionObj.get("capacity1st").toString();
            capacity2nd = connectionObj.get("capacity2nd").toString();

            JSONArray sectionsArr = connectionObj.getJSONArray("sections");
            Iterator sectionsIt = sectionsArr.iterator();
            while (sectionsIt.hasNext()) {
                JSONObject sectionObj = (JSONObject) sectionsIt.next();
                sections.add(new Section(sectionObj));
            }

            connectionArray.add(new Connection(getToPoint(), getFromPoint(), getDuration(), getService(), getProducts(), getCapacity1st(), getCapacity2nd(), getSections()));
        }
    }

    private Connection(Checkpoint _toPoint, Checkpoint _fromPoint, String _duration, Service _service, ArrayList<String> _products, String _capacity1st, String _capacity2nd, ArrayList<Section> _sections) {
        this.capacity1st = _capacity1st;
        this.capacity2nd = _capacity2nd;
        this.duration = _duration;
        this.fromPoint = _fromPoint;
        this.toPoint = _toPoint;
        this.products = _products;
        this.sections = _sections;
        this.service = _service;
    }

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

    public ArrayList<Connection> getConnectionArray() {
        return connectionArray;
    }

    public void setConnectionArray(ArrayList<Connection> connectionArray) {
        this.connectionArray = connectionArray;
    }

}
