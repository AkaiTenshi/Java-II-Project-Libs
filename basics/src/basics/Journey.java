/*
Holds the Journey object's parsing
*/
package basics;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class Journey {
    private String name, category, operator, destination, capacity1st, capacity2nd, number, categoryCode;
    private ArrayList<Checkpoint> passList = new ArrayList<>();
    
    public Journey(JSONObject json){
        // Parsing
        name = json.getString("name");
        category = json.getString("category");
        name = json.getString("operator");
        destination = json.getString("to");
        
        capacity1st = json.get("capacity1st").toString();
        capacity2nd = json.get("capacity2nd").toString();
        number = json.get("number").toString();
        categoryCode = json.get("categoryCode").toString();
        
        JSONArray plArr = json.getJSONArray("passList");
        Iterator plIt = plArr.iterator();
        while(plIt.hasNext()){
            JSONObject innerObj = (JSONObject) plIt.next();
            passList.add(new Checkpoint(innerObj));
        }
    }

    // Getter & Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public ArrayList<Checkpoint> getPassList() {
        return passList;
    }

    public void setPassList(ArrayList<Checkpoint> passList) {
        this.passList = passList;
    }


}
