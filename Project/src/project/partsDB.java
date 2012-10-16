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
    private String maker;
    private String model;
    private int year;
    private String engine;

    public partsDB(String connectString, String user, String password) throws SQLException {

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
        ArrayList<HashMap> result = new ArrayList<HashMap>();
        HashMap<String, String> column;
        try {
            rs = oracleStmt.executeQuery(SQLStatement);
            /* This is risky. We can't guarantee Oracle will give us the same indices
             for a column every time. Instead, we should use ResultSetMetaData:
             http://docs.oracle.com/javase/7/docs/api/java/sql/ResultSetMetaData.html
             
             My proposed solution:
             */
            String columnName;
            while (rs.next()) {
                column = new HashMap<String, String>();
                rsMetaData = rs.getMetaData();
                for (int i = 1; i <= 7; i++) {
                    columnName = rsMetaData.getColumnName(i);
                    column.put(columnName, rs.getString(columnName));
                }
                result.add(column);
                column = null;
            }
//            System.out.println(result);
//            System.out.println(result.size());

        } /*
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
         */ catch (SQLException e) {
            System.out.println("Unable to execute statement: "
                    + SQLStatement + "\nMessage: " + e.getMessage());

            //ArrayList<String>; } ResultSetMetaData rsMetaData = rs.getMetaData(); }
        }
        return result;
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

    public void setMaker(String autoMake) {
        this.maker = autoMake;
    }

    public void setModel(String autoModel) {
        this.model = autoModel;
    }

    public void setYear(int autoYear) {
        this.year = autoYear;
    }

    public void setEngine(String autoEngine) {
        this.engine = autoEngine;
    }

    public String[] getMaker() {
        // TODO //
        return new String[0];
    }

    public String[] getModel() {
        // TODO //
        return new String[0];
    }

    public int[] getYear() {
        // TODO //
        return new int[0];
    }

    public String[] getEngine() {
        // TODO //
        return new String[0];
    }
}
