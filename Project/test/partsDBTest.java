/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import org.junit.*;
import static org.junit.Assert.*;
import project.partsDB;

/**
 *
 * @author chirag
 */
public class partsDBTest {
    
    public partsDBTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void test() { 
        try{
        partsDB dbc = new partsDB("jdbc:oracle:thin:@localhost:1521:orcl","system","Password17");
        dbc.disconnectFromDB();
        }
        catch(SQLException ex)
        {
                    System.err.println(ex.getMessage());
        }
     }
}
