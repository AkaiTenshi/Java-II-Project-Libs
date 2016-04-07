/*
This is a custom ArrayList that contains every connection
returned from the query
*/
package basics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ConnectionArray extends ArrayList{
    //private Connection connection;
    
    public ConnectionArray(int fromID, int toID) throws IOException, JSONException{
        JSONObject json = RequestAPI.readJsonFromUrl("http://transport.opendata.ch/v1/connections?from=" + fromID + "&to=" + toID + "&direct=1"); // Pull from the URL
        JSONArray connections = json.getJSONArray("connections"); // Get the connection array from the JSON
        
        Iterator connectionIt = connections.iterator();
        // While the array has elements
        while (connectionIt.hasNext()) {
            JSONObject connectionObj = (JSONObject) connectionIt.next();
            super.add(new Connection(connectionObj)); // Call super to add our connection to the final ArrayList.
        }
    }
}
