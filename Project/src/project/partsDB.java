package project;

import java.sql.*;
import java.sql.*;

/**
 * Creates and manages a connection to the parts database
 * @author Eric Schroeder
 */
public class partsDB {
    private Connection oracleConn;
    private Statement oracleStmt;
    public partsDB(String connectString) {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        try {
            oracleConn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","sjsu","sjsu");
        } catch (SQLException e) {
            //DoSomething("Unable to connect to database: " + e.getMessage());
            return;
        }
        
        try { oracleStmt = oracleConn.createStatement(); }
        catch (SQLException e) {
            //DoSomething("Unable to create statement: " + e.getMessage());
            return;
        }
    }
    
    /**
     * Returns an array list with the contents of the supplied query.
     * @param fromTable
     * @param whereClause
     * @return An arrayList
     */
    public ArrayList<String> select(String SQLStatement) {
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
}
