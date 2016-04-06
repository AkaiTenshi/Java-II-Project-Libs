package basics;

import java.io.IOException;

public class Test {
    public static void main(String args[]){
        Location loc1, loc2;
        Connection con;
        
        try{
            Cities.getCities();
            loc1 = new Location(Cities.SwissCities.get(0));
            loc2 = new Location(Cities.SwissCities.get(1));
            con = new Connection(8501120, 8501008);
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        
        
    }
}
