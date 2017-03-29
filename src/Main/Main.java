package Main;

import static Main.Connector.closeConnection;
import static Main.Connector.getConnection;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

   // --- FILL THESE IN ---
    static String ORA_ACCOUNT = "ora_j5k0b";
    static String ORA_PASSWORD = "a36579143";
    
    public static void main(String[] args) {
        getConnection();
        closeConnection();
    }
}
