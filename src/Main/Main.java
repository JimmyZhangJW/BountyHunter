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
       
        DatabaseConnect myconnect=new DatabaseConnect("ora_b9j0b","a25724155");
        myconnect.connect();
        
        JFrame mainframe = new signup();
        mainframe.setVisible(true);

    }
}
