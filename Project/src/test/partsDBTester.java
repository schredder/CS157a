/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import project.partsDB;
import java.sql.*;

/**
 *
 * @author Eric Schroeder
 */
public class partsDBTester {
    
    public static void main(String[] args) throws SQLException{
        
        try{
        partsDB dbc = new partsDB("jdbc:oracle:thin:@localhost:1521:orcl","system","Password17");
        dbc.select("Select * from APLBUK");
        dbc.disconnectFromDB();
        }
        catch(SQLException ex)
        {
                    System.err.println(ex.getMessage());
        }
    } 
}