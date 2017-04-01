/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MissionHolder;

import Main.Connector;
import static Main.Connector.getConnection;
import static Main.signup.drawErrorDialog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MalcolmChen
 */
public class MissionStats extends javax.swing.JFrame {
    private static int itemMission=1000;
   
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    private ResultSet rs2;
    private int id;
    private PreparedStatement pst;
    /**
     * Creates new form MissionStats
     */
    public MissionStats(int id) {
        initComponents();
        this.id=id;
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        con= getConnection();
        setCurrentItemMissionTable();
        setCurrentMonsterMissionTable();
        setCompleteMissionTable();
        setFailedMissionTable();
    }
    
    private void setCurrentItemMissionTable(){
        DefaultTableModel itemTable =(DefaultTableModel)ItemTable1.getModel();
        Object itemData[]=new Object[7];
        try{
            stmt= con.createStatement();
            String imissionQuery="SELECT M.ITEMMISSIONID, "
                    + "M.DESCRIPTION, I.ITEMNAME, M.STARTTIME, M.DEADLINE, "
                    + "M.ACCEPTTIME " +
                    "FROM ITEM_FORAGING_MISSION M, IMISSION_HAS_ITEM mHI, ITEM I " +
                    "WHERE "+ "M.MISSIONHOLDERID  = "+id 
                    + " AND mHI.ITEMMISSIONID = M.ITEMMISSIONID AND "
                    + "I.ITEMID = mHI.ITEMID AND M.ACCEPTTIME IS NOT NULL";
         
            itemTable.setRowCount(0);
            rs=stmt.executeQuery(imissionQuery);
            while(rs.next()){
                itemData[0]=rs.getString(1); // itemMissionID
                itemData[1]=rs.getString(2); // Description
                itemData[2] = rs.getString(3); //itemName
                itemData[3]=rs.getString("startTime");
                itemData[4]=rs.getString("deadline");
                itemData[5]=rs.getString("acceptTime");
                itemTable.addRow(itemData);
               
            }

        }catch(SQLException err){
            System.out.print(err);
            drawErrorDialog(err.toString(), "SQL Exception");
        }
    }

    private void setCurrentMonsterMissionTable(){
        DefaultTableModel hunterTable =(DefaultTableModel) huntingtable1.getModel();
        Object itemData[]=new Object[7];
        try{
            stmt= con.createStatement();
            String hMissionQuery="SELECT M.HUNTINGMISSIONID, M.DESCRIPTION, mon.NAME, M.STARTTIME, M.DEADLINE, M.ACCEPTTIME " +
                    "FROM HUNTING_MISSIONS M, MMISSION_HAS_MONSTER mHM, MONSTER mon " +
                    "WHERE M.MISSIONHOLDERID =" +id+" AND mHM.HUNTINGMISSIONID = M.HUNTINGMISSIONID "
                    + "AND mon.MONSTERID = mHM.MONSTERID AND M.ACCEPTTIME IS NOT NULL";
         
            hunterTable.setRowCount(0);
            rs=stmt.executeQuery(hMissionQuery);
            while(rs.next()){
                itemData[0]=rs.getString(1); // HuntingMissionID
                itemData[1]=rs.getString(2); // Description
                itemData[2] = rs.getString(3); //Monster Name
                itemData[3]=rs.getString("startTime");
                itemData[4]=rs.getString("deadline");
                itemData[5]=rs.getString("acceptTime");
                hunterTable.addRow(itemData);
            }

        }catch(SQLException err){
            System.out.print(err);
            drawErrorDialog(err.toString(), "SQL Exception");
        }
    }
    
    private void setCompleteMissionTable(){
        DefaultTableModel compTable =(DefaultTableModel)mCompletedMissionTable.getModel();
        Object itemData[]=new Object[7];
        
        try{
            stmt= con.createStatement();
            String Query="(SELECT M.ITEMMISSIONID ID, M.DESCRIPTION, M.ACCEPTTIME, M.DEADLINE, M.COMPLETETIME, H.NAME " +
                            "FROM ITEM_FORAGING_MISSION M, HUNTER H " +
                            "WHERE M.MISSIONHOLDERID = "+id+" AND M.ACCEPTTIME IS NOT NULL AND M.COMPLETETIME IS NOT NULL AND M.HUNTERID = H.HUNTERID) " +
                            "UNION( " +
                            "SELECT M2.HUNTINGMISSIONID ID, M2.DESCRIPTION, M2.ACCEPTTIME, M2.DEADLINE, M2.COMPLETIONTIME, H.NAME " +
                            "FROM HUNTING_MISSIONS M2, HUNTER H " +
                            "WHERE M2.MISSIONHOLDERID = "+id+" AND M2.ACCEPTTIME IS NOT NULL AND M2.COMPLETIONTIME IS NOT NULL AND M2.HUNTERID = H.HUNTERID)";

            compTable.setRowCount(0);
            rs=stmt.executeQuery(Query);
            while(rs.next()){
                itemData[0]=rs.getString(1); // ID
                itemData[1]=rs.getString(2); // Description
                itemData[2] = rs.getString(3); // AcceptTime
                itemData[3]=rs.getString(4); // Deadline
                itemData[4]=rs.getString(5); // Complete time
                itemData[5]=rs.getString(6); // Hunter Name
                compTable.addRow(itemData);
            }

        }catch(SQLException err){
            System.out.print(err);
            drawErrorDialog(err.toString(), "SQL Exception");
        }
    }
    
    private void setFailedMissionTable(){
        DefaultTableModel failTable =(DefaultTableModel)mFailedTable.getModel();
        Object itemData[]=new Object[7];
        
        try{
            stmt= con.createStatement();
            String Query="(SELECT M.ITEMMISSIONID ID, M.DESCRIPTION, M.DEADLINE\n" +
"FROM ITEM_FORAGING_MISSION M " +
"WHERE M.MISSIONHOLDERID = "+ id +"  AND M.COMPLETETIME IS NULL ) " +
"UNION(  " +
"SELECT M2.HUNTINGMISSIONID ID, M2.DESCRIPTION , M2.DEADLINE " +
"FROM HUNTING_MISSIONS M2 " +
"WHERE M2.MISSIONHOLDERID = "+id+" AND M2.COMPLETIONTIME IS NULL)";

            failTable.setRowCount(0);
            rs=stmt.executeQuery(Query);
            while(rs.next()){
                if(isPastDeadline(rs.getString(3))){
                    itemData[0]=rs.getString(1); // ID
                    itemData[1]=rs.getString(2); // Description
                    itemData[2] = rs.getString(3); // Deadline
                    failTable.addRow(itemData);
                }
            }

        }catch(SQLException err){
            System.out.print(err);
            drawErrorDialog(err.toString(), "SQL Exception");
        }
    }
    
    public static boolean isPastDeadline(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       
        Date checkDate;
        Date currentDate;
        
        try {
            checkDate = sdf.parse(date);
            currentDate = sdf.parse(sdf.format(Calendar.getInstance().getTime()));
            System.out.println("current : " + currentDate);
            System.out.println("checking : " + checkDate);
            return currentDate.after(checkDate);
            
        } catch (ParseException ex) {
            Logger.getLogger(MissionStats.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return false;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        mCompletedMissionTable = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        mFailedTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        ItemTable1 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        huntingtable1 = new javax.swing.JTable();
        mMissionStatsBackButton = new javax.swing.JButton();
        mManageMissionButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Mission History", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 24), new java.awt.Color(0, 0, 153))); // NOI18N

        mCompletedMissionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Description", "Accept Time", "Deadline", "Completion Time", "Hunter"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(mCompletedMissionTable);

        jTabbedPane2.addTab("Completed", jScrollPane5);

        mFailedTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Description", "Deadline"
            }
        ));
        jScrollPane6.setViewportView(mFailedTable);

        jTabbedPane2.addTab("Failed", jScrollPane6);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Active Missions", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 24), new java.awt.Color(0, 153, 153))); // NOI18N

        ItemTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Description", "Item", "Start Time", "Deadline", "Accept Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(ItemTable1);
        if (ItemTable1.getColumnModel().getColumnCount() > 0) {
            ItemTable1.getColumnModel().getColumn(0).setResizable(false);
        }

        jTabbedPane1.addTab("Item-Foraging Mission", jScrollPane4);

        huntingtable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Description", "Monster", "Start Time", "Deadline", "Accept Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(huntingtable1);
        if (huntingtable1.getColumnModel().getColumnCount() > 0) {
            huntingtable1.getColumnModel().getColumn(0).setResizable(false);
        }

        jTabbedPane1.addTab("Hunting Mission", jScrollPane7);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mMissionStatsBackButton.setText("Back");
        mMissionStatsBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mMissionStatsBackButtonActionPerformed(evt);
            }
        });

        mManageMissionButton.setText("Manage");
        mManageMissionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mManageMissionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(mMissionStatsBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addComponent(mManageMissionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mMissionStatsBackButton)
                    .addComponent(mManageMissionButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mMissionStatsBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mMissionStatsBackButtonActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_mMissionStatsBackButtonActionPerformed

    private void mManageMissionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mManageMissionButtonActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        manageMission manageWindow=new manageMission(id);
        manageWindow.setVisible(true);
        
    }//GEN-LAST:event_mManageMissionButtonActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ItemTable1;
    private javax.swing.JTable huntingtable1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable mCompletedMissionTable;
    private javax.swing.JTable mFailedTable;
    private javax.swing.JButton mManageMissionButton;
    private javax.swing.JButton mMissionStatsBackButton;
    // End of variables declaration//GEN-END:variables
}
