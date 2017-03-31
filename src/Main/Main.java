package Main;

<<<<<<< HEAD
import java.sql.*;
import javax.swing.JFrame;
import Hunter.*;
import Main.Connect;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static Connection myDBCon;
    private static Statement st;
    private ResultSet rs;

    public static void main(String[] args) {
        
            
//	try{
//            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
//            System.out.println("Making connection");
//        }catch(Exception e){
//            System.err.println("Error: "+e);
//        }
//        
//        try{
//            myDBCon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:ug", "ora_n9k0b", "a46778156");
//            System.out.println("");
//            st=myDBCon.createStatement();
//            System.out.print("Success :)");
//        }catch(Exception e){
//            System.err.print("Error: "+e);
//        }
       
        Connection con = Connect.getConnection();
        try {
            Statement stmt = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println();
        JFrame hunterGui=new HunterGUI();
        hunterGui.setVisible(true);
        
        
=======
import MissionHolder.*;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Leaderboard.LeaderBoardPanel;
import static Main.Connector.closeConnection;
import static Main.Connector.getConnection;

import javax.swing.JFrame;

public class Main {
    
    public static void main(String[] args) {        
        JFrame mainframe = new signup();
        mainframe.setVisible(true);
>>>>>>> master
    }
}
