/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author omar
 */
public class Connector {
    
       // --- FILL THESE IN ---
    static String ORA_ACCOUNT = "ora_n9k0b";
    static String ORA_PASSWORD = "a46778156";
    
    private static Connection con;
    
    static public Connection getConnection(){
        if(con == null){
            try{
                //----Make the connection----
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                System.out.println("Making connection");
                // Use this connection string when SSH tunneling from your laptop
                con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1522:ug", ORA_ACCOUNT, ORA_PASSWORD);
            }catch (SQLException e) {
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw));
                String exceptionAsString = sw.toString();
                System.out.println(exceptionAsString);
                System.out.println("---------------------------------");
                printHelp();
            }
        }

        return con;
    }
    
    static public void closeConnection(){
        try {
            con.close();
            con = null;
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static  void printHelp(){
        System.out.println("Failed");
        System.out.println("1) Ensure that you are connected to the VPN");
        System.out.println("2) Ensure you have a ssh tunneling set up");
        System.out.println("3) Double check your username and password they should look like ora_r2d2 a11223344");
        System.out.println("4) Try downloading the new JDBC Driver 'classes12.jar' http://www.oracle.com/technetwork/apps-tech/jdbc-10201-088211.html (youll need to create a free account)");
    }
}