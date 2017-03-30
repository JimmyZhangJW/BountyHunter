/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.HeadlessException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import oracle.jdbc.driver.OraclePreparedStatement;
import oracle.jdbc.driver.OracleResultSet;

/**
 *
 * @author MalcolmChen
 */
public class DatabaseConnect {
    private String user;
    private String pass;
    private Connection con;
    
    public DatabaseConnect(String account,String password){
        this.user=account;
        this.pass=password;
    }
    
    public void connect(){
        try {
            //connect to database server
            String ORA_ACCOUNT = this.user;
            String ORA_PASSWORD = this.pass;

            //----Make the connection----
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            System.out.println("Making Connection");
            // Use this connection string when SSH tunneling from your laptop
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1522:ug", ORA_ACCOUNT, ORA_PASSWORD);

            // Verify the connection is open. Then close it.
//            boolean conOpen = !con.isClosed();
//            System.out.println("Closing connection");
//            con.close();
//            boolean conClosed = con.isClosed();
//
//            if (conOpen && conClosed) {
//                System.out.println("Passed");
//            } else {
//                System.out.println("Failed");
//            }

        } catch (SQLException e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            System.out.println(exceptionAsString);
            System.out.println("---------------------------------");
        }
    }
    
    public Connection getConnection(){
        return con;
    }
    
    
    public void closeConnect(){
        try {
            con.close();
        }
        catch(Exception e){}
    }
    
    
}
