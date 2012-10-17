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
    private String year;
    private String engine;
    private String litres;
    private String cubicIn;

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
        /*
         * TODO: Execute the SQL statement, and return it as an ArrayList of
         * tuples represented as HashMaps with the column as the key
         */
        ResultSet rs;
        ResultSetMetaData rsMetaData = null;
        ArrayList<HashMap> result = new ArrayList<HashMap>();
        HashMap<String, String> column;
        try {
            rs = oracleStmt.executeQuery(SQLStatement);
            /*
             * This is risky. We can't guarantee Oracle will give us the same
             * indices for a column every time. Instead, we should use
             * ResultSetMetaData:
             * http://docs.oracle.com/javase/7/docs/api/java/sql/ResultSetMetaData.html
             *
             * My proposed solution:
             */
            String columnName;
            while (rs.next()) {
                column = new HashMap<String, String>();
                rsMetaData = rs.getMetaData();
                for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
                    columnName = rsMetaData.getColumnName(i);
                    column.put(columnName, rs.getString(columnName));
                }
                result.add(column);
                column = null;
            }
//            System.out.println(result);
//            System.out.println(result.size());

        } /*
         * try { rs = oracleStmt.executeQuery(SQLStatement);          *
         *
         * while(rs.next()){
         *
         * column.put("model",rs.getString(1));
         * column.put("year",rs.getString(2));
         * column.put("desc",rs.getString(3));
         * column.put("litres",rs.getString(4));
         * column.put("engine",rs.getString(5));
         * column.put("inches",rs.getString(6));
         * column.put("rlink",rs.getString(7)); APLBUK.add(column); column = new
         * HashMap<String, String>(); } oracleStmt.close();
         * System.out.println(APLBUK.get(0).get("model"));
         * System.out.println(APLBUK.get(0)); System.out.println(APLBUK.size());
         * }
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
    }

    public void setMaker(String autoMake) {
        this.maker = autoMake;
    }

    public void setModel(String autoModel) {
        this.model = autoModel;
    }

    public void setYear(String autoYear) {
        this.year = autoYear;
    }

    public void setEngine(String autoEngine) {
        String[] split = autoEngine.split(",");
        this.engine = split[0];
        this.litres = split[1];
        this.cubicIn = split[2];
    }

    public ArrayList<HashMap> getMaker() {
        return this.select("SELECT MAK,COD FROM MAKERS");
    }

    public String[] getModel() {
        ArrayList<HashMap> resultList = this.select("SELECT DISTINCT MODEL FROM APL" + this.maker);
        String[] models = new String[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            models[i] = (String) resultList.get(i).get("MODEL");
        }

        return models;
    }

    public String[] getYear() {
        ArrayList<HashMap> resultList = this.select("SELECT DISTINCT YEAR FROM APL"
                + this.maker + " WHERE MODEL='" + this.model + "'");
        String[] years = new String[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            years[i] = (String) resultList.get(i).get("YEAR");
        }

        return years;
    }

    /**
     * @return an array of comma-delimited strings in the format ENGINE_TYPE,
     * LITRES, CUBIC_INCHES
     */
    public String[] getEngine() {
        ArrayList<HashMap> resultList = this.select("SELECT ENGINE_TYPE,LITRES,CUBIC_INCHES FROM APL"
                + this.maker + " WHERE MODEL='" + this.model + "' AND YEAR=" + this.year);
        String[] engines = new String[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            engines[i] = (String) resultList.get(i).get("ENGINE_TYPE") + ","
                    + (String) resultList.get(i).get("LITRES") + ","
                    + (String) resultList.get(i).get("CUBIC_INCHES");
        }
        return engines;
    }
    
 public ArrayList<HashMap> getParts() {
       
        this.maker="CHE";
        this.model="CAMARO";
        this.year="86";
        this.engine="L4";
        this.litres="2.5";
        this.cubicIn="151";
        ArrayList<HashMap> partsList =
                this.select("SELECT * FROM RADCRX "
                + "WHERE RLINK=(SELECT RLINK FROM APL" + this.maker
                            + " WHERE MODEL='" + this.model
                            + "' AND YEAR='" + this.year
                            + "' AND ENGINE_TYPE='" + this.engine
                            + "' AND (LITRES='" + this.litres
                            + "' OR CUBIC_INCHES=" + this.cubicIn
                            + "))");
       
        // List of part nums is in the first index of resultList
        ArrayList<HashMap> parts = new ArrayList<HashMap>();
//        HashMap<String, String> partNums = partsList.get(0);
        //for(String vendorColumn : (String[]) partNums.keySet().toArray()) {
        String[] columnArray = new String[partsList.get(0).size()];
        for (HashMap<String, String> vendorcolumn : partsList) 
          {
            int i = 0;
            Iterator column = vendorcolumn.entrySet().iterator();
            while (column.hasNext()) {
                Map.Entry current = (Map.Entry) column.next();
                columnArray[i] = current.getKey().toString();
                if(columnArray[i].equals("RLINK"))
                    continue;
              String p_number = vendorcolumn.get(columnArray[i]);
              String vendorDB = columnArray[i].substring(0, columnArray[i].length()-1);
                parts.addAll(this.select("SELECT * FROM RDIM"+vendorDB+" WHERE P_NUMBER='"+p_number+"'"));                
                i++;
            
          }
          }
            System.out.println(parts);
/*            String p_number = partNums.get(vendorColumn);
            // i.e. vendorColumn = MOD5
            String vendorDB = vendorColumn.substring(0, vendorColumn.length()-1);
            // i.e. vendorDB = MOD
            this.select("SELECT * FROM RDIM" + vendorDB + " WHERE P_NUMBER=" + p_number);
            // TODO:
            // Database for parts = "RDIM"+key (i.e. RDIMMOD RDIMARS, etc.)
            // So for each key, select("select * from RDIM"+key+"where p_number="+partNums.get(key));
            // and combine somehow. =\
        }
  */     
        return parts;
    }  
}
