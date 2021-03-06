/*
Location class describes the Location Object of the API
while also having the functionallity of the API's /location
query.
*/

package basics;

import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Location {

    private int id;
    private String name;
    private String type;
    private Coordinates coord = new Coordinates();
    JSONObject json;

    //Used to get data from Location query to the API
    public Location(String _Name) throws IOException, JSONException {
        json = RequestAPI.readJsonFromUrl("http://transport.opendata.ch/v1/locations?query=" + _Name); // Pull JSON from the URL
        
        //Parsing
        JSONArray station = json.getJSONArray("stations");
        JSONObject innerObj = station.getJSONObject(0); // We need only the first result (Highest score)
        
        id = innerObj.getInt("id");
        name = innerObj.getString("name");

        JSONObject coordinates = innerObj.getJSONObject("coordinate");
        coord.setType(coordinates.getString("type"));
        coord.setX(coordinates.getDouble("x"));
        coord.setY(coordinates.getDouble("y"));
    }

    //Used to parse data send from other queries to the API
    public Location(JSONObject json) {
        //Parsing
        id = json.getInt("id");
        name = json.getString("name");

        JSONObject coordinates = json.getJSONObject("coordinate");
        coord.setType(coordinates.getString("type"));
        coord.setX(coordinates.getDouble("x"));
        coord.setY(coordinates.getDouble("y"));
    }
    
    //Used to get data from DB or Files.
    public Location(int id, String name, double cordX, double cordY, String type){
        this.coord = new Coordinates();
        coord.setX(cordX);
        coord.setY(cordY);
        this.name = name;
        this.id = id;
        this.type = type;
    }
    
    //Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Coordinates getCoord() {
        return coord;
    }

    public void setCoord(Coordinates coord) {
        this.coord = coord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
