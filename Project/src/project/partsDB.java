package project;

import java.sql.*;
import java.util.*;
/**
 * Creates and manages a connection to the parts database
 *
 * @author Eric Schroeder
 */
public class partsDB {
    private Connection oracleConn;
    private Statement oracleStmt;
    ArrayList<HashMap> APLBUK =  new ArrayList<HashMap>();
    HashMap<String,String> column =  new HashMap<String, String>();
    
    private String maker;
    private String model;
    private int year;
    private String engine;
    
    public partsDB(String connectString, String user, String password) throws SQLException{

        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            oracleConn = DriverManager.getConnection(connectString, user, password);
            oracleStmt = oracleConn.createStatement();
            System.out.println("Connected to DB!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Returns an array list with the contents of the supplied query.
     *
     * @param fromTable
     * @param whereClause
     * @return An arrayList
     */
      public ArrayList<HashMap> select(String SQLStatement) {
      /* TODO: Execute the SQL statement, and return it as an ArrayList of
       tuples represented as HashMaps with the column as the key*/
     
      

      ResultSet rs; 
      ResultSetMetaData rsMetaData = null; 
      try { 
          rs = oracleStmt.executeQuery(SQLStatement); 
/*           This is risky. We can't guarantee Oracle will give us the same indices
             for a column every time. Instead, we should use ResultSetMetaData:
             http://docs.oracle.com/javase/7/docs/api/java/sql/ResultSetMetaData.html
             
             My proposed solution:
             */
          while(rs.next()){
          rsMetaData = rs.getMetaData();
          for (int i = 1; i <=7; i++) {
             column.put(rsMetaData.getColumnName(i), rs.getString(i));
          }
          APLBUK.add(column);
          column = new HashMap<String, String>();
          }
            System.out.println(APLBUK);
          System.out.println(APLBUK.size());

      }
/*
      try {
          rs = oracleStmt.executeQuery(SQLStatement); 
      
          
          while(rs.next()){

          column.put("model",rs.getString(1));
          column.put("year",rs.getString(2));
          column.put("desc",rs.getString(3));
          column.put("litres",rs.getString(4));
          column.put("engine",rs.getString(5));
          column.put("inches",rs.getString(6));
          column.put("rlink",rs.getString(7));
          APLBUK.add(column);
          column = new HashMap<String, String>();
          }
          oracleStmt.close();
          System.out.println(APLBUK.get(0).get("model"));
          System.out.println(APLBUK.get(0));
          System.out.println(APLBUK.size());
      }
  */    
      catch(SQLException e) { System.out.println("Unable to execute statement: " +
      SQLStatement + "\nMessage: "+ e.getMessage());
      
      //ArrayList<String>; } ResultSetMetaData rsMetaData = rs.getMetaData(); }
      }
      return APLBUK; 
      }
      
      
    /**
     * Returns a Statement in case something needs to be done outside the scope
     * of this class.
     *
     * @return Oracle Database Statement object
     */
    public Statement getDBStatement() { return oracleStmt; }

    public void disconnectFromDB() throws SQLException {
        try {
            oracleConn.close();
            System.out.println("Disconnected from DB!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * get the database connection object.
     */
    public Connection getDBConnection() { return this.oracleConn; } //method

    public void setMaker(String autoMake) {
        // TODO //
    }
    
    public void setModel(String autoModel) {
        // TODO //
    }
        
    public void setYear(int autoYear) {
        // TODO //
    }
    
    public void setEngine(String autoEngine) {
        // TODO //
    }
    
    public String[] getMaker(String autoMake) {
        // TODO //
        return new String[0];
    }
    
    public String[] getModel(String autoModel) {
        // TODO //
        return new String[0];
    }
        
    public int[] getYear(int autoYear) {
        // TODO //
        return new int[0];
    }
    
    public String[] getEngine(String autoEngine) {
        // TODO //
        return new String[0];
    }
}
