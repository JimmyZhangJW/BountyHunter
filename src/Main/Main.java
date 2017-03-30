package Main;

import Leaderboard.LeaderBoardPanel;
import static Main.Connector.closeConnection;
import static Main.Connector.getConnection;
import javax.swing.JFrame;

public class Main {

   // --- FILL THESE IN ---
    static String ORA_ACCOUNT = "ora_j5k0b";
    static String ORA_PASSWORD = "a36579143";
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        LeaderBoardPanel lb = new LeaderBoardPanel();
        frame.add(lb);
        frame.setSize(1200,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
