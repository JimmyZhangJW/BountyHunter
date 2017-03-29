package Main;

import static Main.Connector.closeConnection;
import static Main.Connector.getConnection;

public class Main {

   // --- FILL THESE IN ---
    static String ORA_ACCOUNT = "ora_j5k0b";
    static String ORA_PASSWORD = "a36579143";
    
    public static void main(String[] args) {
        getConnection();
        closeConnection();
    }
}
