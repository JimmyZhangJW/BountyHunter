package Main;

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
        try {

            //----Make the connection----
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            System.out.println("Making connection");
	    // Use this connection string when SSH tunneling from your laptop
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1522:ug", "ora_j5k0b", "a36579143");

	    // Verify the connection is open. Then close it.           
            boolean conOpen = !con.isClosed();
            System.out.println("Closing connection");
            con.close();
            boolean conClosed = con.isClosed();

            if (conOpen && conClosed){
                System.out.println("Passed");
            } else {
                printHelp();
            }
        } catch (SQLException e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            System.out.println(exceptionAsString);
            System.out.println("---------------------------------");
            printHelp();
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
