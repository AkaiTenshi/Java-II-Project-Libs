package basics;

import gui.InitializeGUI;
import java.util.ArrayList;
import storage.Database;

public class Main {
   
    public static void main(String[] args){
        ArrayList<Location> locArr = new ArrayList<>();
        //InitializeGUI.initFrame();
        
        try{
            Cities.getCities(); // Pull the names of all the cities.
            for(int i = 0; i < 10; i++){
                locArr.add(new Location(Cities.SwissCities.get(i)));
            }
        Database.writeCitiesToDB(locArr);
        
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }
}
