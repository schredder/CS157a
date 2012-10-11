/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import project.partsDB;

/**
 *
 * @author Eric Schroeder
 */
public class partsDBTester {
    partsDB db;
    
    try { db = new partsDB("jdbc:oracle:thin:@localhost:1521:XE","sjsu","sjsu"); }
    catch (SQLException e) {
        
    }
    
    
}
