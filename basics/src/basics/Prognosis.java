/*
Holds the Prognosis object's parsing
*/
package basics;

import org.json.JSONObject;

public class Prognosis {

    private String capacity1st, capacity2nd, platform, depTime, arrTime;

    public Prognosis(JSONObject json) {
        // Parsing
        capacity1st = json.get("capacity1st").toString();
        capacity2nd = json.get("capacity2nd").toString();
        platform = json.get("platform").toString();

        depTime = json.get("departure").toString();
        arrTime = json.get("arrival").toString();
    }

    // Getter & Setter
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

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getDepTime() {
        return depTime;
    }

    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    public String getArrTime() {
        return arrTime;
    }

    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }
}
