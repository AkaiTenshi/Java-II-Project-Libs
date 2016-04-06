package basics;

import org.json.JSONObject;

public class Checkpoint {
    private Location station;
    private String arrival, departure, platform;
    private Prognosis prognosis;
    
    public Checkpoint(JSONObject json){
        JSONObject stationObj = json.getJSONObject("station");
        station = new Location(stationObj);
        arrival = json.get("arrival").toString();
        departure = json.get("departure").toString();
        platform = json.get("platform").toString();
        
        JSONObject prognosisObj = json.getJSONObject("prognosis");
        prognosis = new Prognosis(prognosisObj);
        
    }

    public Location getStation() {
        return station;
    }

    public void setStation(Location station) {
        this.station = station;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Prognosis getPrognosis() {
        return prognosis;
    }

    public void setPrognosis(Prognosis prognosis) {
        this.prognosis = prognosis;
    }
}