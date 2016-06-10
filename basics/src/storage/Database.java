/*
 All database actions are handled here.
 */
package storage;

import basics.DirectLink;
import basics.Location;
import java.sql.*;
import java.util.ArrayList;

public class Database {

    private static final String SQL_INSERT_CITIES = "INSERT INTO CITIES"
            + " VALUES(?, ?, ?, ?, ?)";

    private static final String SQL_INSERT_CONNECTIONS = "INSERT INTO CONNECTIONS"
            + " VALUES(?, ?, ?)";
    
    private static final String SQL_SEARCH_CITIES = "SELECT * FROM CITIES WHERE"
            + " STATIONNAME LIKE '%?%'";
    
    private static final String SQL_SEARCH_CONNECTIONS = "SELECT * FROM LINKS WHERE"
            + " FROMPOINTNAME LIKE %?% AND TOPOINTNAME LIKE '%?%'";

    //Connection to DB
    public static Connection Connect() throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver"); //Register the Driver
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//10.100.51.123:1521/orcl", "it21456", "JavaTest"); //Connect to the DB
        return con;
    }

    public static void writeCitiesToDB(ArrayList<Location> cities) throws SQLException, DBHasDataException, ClassNotFoundException {
        Connection con = Connect();
        con.setAutoCommit(false);
        PreparedStatement pstmn = con.prepareStatement(SQL_INSERT_CITIES);
        // Check if the DB is empty and throw Exception
        Statement stmn = con.createStatement();
        ResultSet rs = stmn.executeQuery("select * from cities");

        if (rs.next()) {
            throw new DBHasDataException("Database is not empty.");
        }

        // Instert all the values from cities array to the DB
        for (int i = 0; i <= cities.size() - 1; i++) {
            pstmn.setInt(1, cities.get(i).getId());
            pstmn.setString(2, cities.get(i).getName());
            pstmn.setDouble(3, cities.get(i).getCoord().getX());
            pstmn.setDouble(4, cities.get(i).getCoord().getY());
            pstmn.setString(5, cities.get(i).getType());
            pstmn.executeUpdate();
        }
        con.commit();
        con.close();
    }

    public static void writeConnectionsToDB(ArrayList<DirectLink> links) throws SQLException, DBHasDataException, ClassNotFoundException {
        Connection con = Connect();
        con.setAutoCommit(false);
        PreparedStatement pstmn = con.prepareStatement(SQL_INSERT_CONNECTIONS);
        // Check if DB is empty
        Statement stmn = con.createStatement();
        ResultSet rs = stmn.executeQuery("select * from links");
        if (rs.next()) {
            throw new DBHasDataException("Database is not empty.");
        }

        // Insert all of the links array values to the DB
        for (int i = 0; i <= links.size() - 1; i++) {
            pstmn.setString(1, links.get(i).getFrom());
            pstmn.setString(2, links.get(i).getTo());
            pstmn.setString(3, links.get(i).getType());
            pstmn.executeUpdate();
        }
        con.commit();
        con.close();
    }

    public static ArrayList<Location> readCitiesFromDB() throws SQLException, ClassNotFoundException {
        ArrayList<Location> citiesFromDB = new ArrayList<>();

        Connection con = Connect();
        Statement stmn = con.createStatement();
        ResultSet rs = stmn.executeQuery("select * from cities");
        // While the result set is not empty read the values from the DB to the Array
        while (rs.next()) {
            int id = rs.getInt("StationId");
            String stationName = rs.getString("StationName");
            double coordX = rs.getDouble("CoordX");
            double coordY = rs.getDouble("CoordY");
            String stationType = rs.getString("StationType");
            citiesFromDB.add(new Location(id, stationName, coordX, coordY, stationType));
        }
        con.close();
        return citiesFromDB;
    }

    public static ArrayList<DirectLink> readConnectionsFromDB() throws SQLException, ClassNotFoundException {
        ArrayList<DirectLink> linksFromDB = new ArrayList<>();

        Connection con = Connect();
        Statement stmn = con.createStatement();
        ResultSet rs = stmn.executeQuery("select * from links");
        // While the result set is not empty read the values from the DB to the Array
        while (rs.next()) {
            String fromPointName = rs.getString("FromPointName");
            String toPointName = rs.getString("ToPointName");
            String type = rs.getString("TypeName");
            linksFromDB.add(new DirectLink(fromPointName, toPointName, type));
        }
        con.close();
        return linksFromDB;
    }

    public static void resetDatabase() throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        Statement stmn = con.createStatement();
        // Delete the contents of the whole DB
        stmn.executeUpdate("DELETE FROM cities");
        System.out.println("DELETING");
        stmn.executeUpdate("DELETE FROM links");
        con.close();
    }
    
    public static ResultSet searchDatabase(String term, String databaseName) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pstmn = con.prepareStatement(SQL_SEARCH_CITIES);
        ResultSet rs;
        
        if(databaseName.equals("cities")){
            
        }else{
            
        }
        
        return rs;
    }
}
