package Main;

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
        //start sign up view
        JFrame mainframe = new signup();
        mainframe.setVisible(true);
    }
}
