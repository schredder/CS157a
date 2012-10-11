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
    public static void main(String args) {
        partsDB db;
    
        try { db = new partsDB("jdbc:oracle:thin:@localhost:1521:XE","sjsu","sjsu"); }
        catch (SQLException e) {
            System.out.println("Unable to connect: " + e.getMessage());
        }
    }
}