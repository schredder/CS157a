package project;

import java.sql.*;
import oracle.jdbc.driver.*;
import java.util.*;

/**
 * Creates and manages a connection to the parts database
 * @author Eric Schroeder
 */
public class partsDB {
    private Connection oracleConn;
    private Statement oracleStmt;
    public partsDB(String connectString, String user, String password) throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        oracleConn = DriverManager.getConnection(connectString, user, password);
        oracleStmt = oracleConn.createStatement();
    }

    /**
     * Returns an array list with the contents of the supplied query.
     * @param fromTable
     * @param whereClause
     * @return An arrayList
     */
    public ArrayList<HashMap<String, String>> select(String SQLStatement) {
        /* TODO: Execute the SQL statement, and return it as an ArrayList of tuples
         * represented as HashMaps with the column as the key
         */
        ResultSet rs;
        try { rs = oracleStmt.executeQuery(SQLStatement); }
        catch (SQLException e) {
            //DoSomething("Unable to execute statement: " + SQLStatement + "\nMessage: + e.getMessage());
            //return new ArrayList<String>;
        }
        ResultSetMetaData rsMetaData = rs.getMetaData();
        
        
    }

    /**
     * Returns a Statement in case something needs to be done 
     * outside the scope of this class.
     * @return Oracle Database Statement object
     */
    public Statement getDBStatement() { return oracleStmt; }
    
    public void disconnectFromDB() throws SQLException {
        oracleConn.close();
    }

}
