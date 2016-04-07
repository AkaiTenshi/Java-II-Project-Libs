/*
Holds the Service object's parsing
*/
package basics;

import org.json.JSONObject;

public class Section {
    private Journey journey;
    private String walk;
    private Checkpoint departure, arrival;
    
    
    public Section(JSONObject json){
        // Parsing
        walk = json.get("walk").toString();
        
        JSONObject depObj = json.getJSONObject("departure");
        departure = new Checkpoint(depObj);
        JSONObject arrObj = json.getJSONObject("arrival");
        arrival = new Checkpoint(arrObj);
        
        JSONObject jourObj = json.getJSONObject("journey");
        journey = new Journey(jourObj);
        
    }

    // Getter & Setter
    public Journey getJourney() {
        return journey;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
    }

    public String getWalk() {
        return walk;
    }

    public void setWalk(String walk) {
        this.walk = walk;
    }

    public Checkpoint getDeparture() {
        return departure;
    }

    public void setDeparture(Checkpoint departure) {
        this.departure = departure;
    }

    public Checkpoint getArrival() {
        return arrival;
    }

    public void setArrival(Checkpoint arrival) {
        this.arrival = arrival;
    }

}
