package Main;

import MissionHolder.*;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;

public class Main {
    
    public static void main(String[] args) {
       
        
        Connection con=Connector.getConnection();
        
        JFrame mainframe = new signup();
        mainframe.setVisible(true);

    }
}
