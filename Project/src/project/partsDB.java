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
    
      public ArrayList select(String SQLStatement) {
      /* TODO: Execute the SQL statement, and return it as an ArrayList of
       tuples represented as HashMaps with the column as the key*/
     
      
      ResultSet rs; 
      try { 
          rs = oracleStmt.executeQuery(SQLStatement); 
          column.put("model",rs.getString(1));
          column.put("year",rs.getString(2));
          column.put("desc",rs.getString(3));
          column.put("litres",rs.getString(4));
          column.put("engine",rs.getString(5));
          column.put("inches",rs.getString(6));
          column.put("rlink",rs.getString(7));
          APLBUK.add(column);
      } 
      
      catch(SQLException e) { System.out.println("Unable to execute statement: " +
      SQLStatement + "\nMessage: "+ e.getMessage()); 
 
      
      return null; 
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
    public Statement getDBStatement() {
        return oracleStmt;
    }

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
    public Connection getDBConnection() {
        return this.oracleConn;
    } //method
}
