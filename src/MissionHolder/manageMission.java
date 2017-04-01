/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MissionHolder;


import Main.Connector;
import static Main.signup.drawErrorDialog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author MalcolmChen
 */
public class manageMission extends javax.swing.JFrame {
    private static int itemMission=1000;
   
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    private ResultSet rs2;
    private int id;
    private PreparedStatement pst;
    /**
     * Creates new form mangageMission
     */
    public manageMission(int id) {
        initComponents();
        this.id=id;
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        tabbed.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                switch (tabbed.getSelectedIndex()){
                    case (0):
                        setItemMissionTable();
                        break;
                    case (1):
                        setHuntingMissionTable();
                        break;
                }
          }
        });
        con=Connector.getConnection();
        setItemMissionTable();
        
      
    }
    
    
    
    
    public void setHuntingMissionTable(){
        idtext.setText("");
            dltext.setText("");
            destext.setText("");
            int itemCount = itembox.getItemCount();

            for (int i = 0; i < itemCount; i++) {
                itembox.removeItemAt(0);
            }
            
        DefaultTableModel hunterTable =(DefaultTableModel) huntingtable1.getModel();
        Object itemData[]=new Object[7];
        textlabel.setText("Monster");
        try{
            stmt= con.createStatement();
            String hMissionQuery="SELECT M.HUNTINGMISSIONID, M.DESCRIPTION, mon.NAME, M.STARTTIME, M.DEADLINE, M.ACCEPTTIME " +
                    "FROM HUNTING_MISSIONS M, MMISSION_HAS_MONSTER mHM, MONSTER mon " +
                    "WHERE M.MISSIONHOLDERID =" +id+" AND mHM.HUNTINGMISSIONID = M.HUNTINGMISSIONID "
                    + "AND mon.MONSTERID = mHM.MONSTERID ";
         
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
    
    public void setItemMissionTable(){
        idtext.setText("");
            dltext.setText("");
            destext.setText("");
            int itemCount = itembox.getItemCount();

            for (int i = 0; i < itemCount; i++) {
                itembox.removeItemAt(0);
            }
        
        DefaultTableModel itemTable =(DefaultTableModel)ItemTable1.getModel();
        textlabel.setText("item");
        try{
            stmt= con.createStatement();
            String imissionQuery="SELECT M.ITEMMISSIONID, "
                    + "M.DESCRIPTION, I.ITEMNAME, M.STARTTIME, M.DEADLINE, "
                    + "M.ACCEPTTIME " +
                    "FROM ITEM_FORAGING_MISSION M, IMISSION_HAS_ITEM mHI, ITEM I " +
                    "WHERE "+ "M.MISSIONHOLDERID  = "+id 
                    + " AND mHI.ITEMMISSIONID = M.ITEMMISSIONID AND "
                    + "I.ITEMID = mHI.ITEMID";
         
            itemTable.setRowCount(0);
            Object itemData[]=new Object[6];
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
    
    
    public void setcurrentMissionTable(){
        DefaultTableModel item1=(DefaultTableModel)ItemTable1.getModel();
        DefaultTableModel hunter1=(DefaultTableModel) huntingtable1.getModel();
        Object item1data[]=new Object[6];
        try{
            stmt= con.createStatement();
            String imissionQuery="select * from Item_Foraging_Mission where  missionHolderID="+id;
            rs=stmt.executeQuery(imissionQuery);
            while(rs.next()){
                item1data[0]=rs.getInt(1);
                item1data[1]=rs.getInt(2);
                item1data[2]=rs.getString("startTime");
                item1data[3]=rs.getString("deadline");
                item1data[4]=rs.getString("acceptTime");
                int missionid=rs.getInt(1);
                String itemQuery="select ItemId from IMission_has_Item where itemMissionId="+missionid;
                rs2=stmt.executeQuery(itemQuery);
                rs2.next();
                int itemid=rs2.getInt("ItemId");
                String itemNameQuery="select itemName from item where itemID="+itemid;
                rs2=stmt.executeQuery(itemNameQuery);
                rs2.next();
                item1data[5]=rs2.getString(1);
                item1.addRow(item1data);
               
            }
             //for current HunterMission
            String hmissionQuery="select * from Hunting_missions where  missionHolderID="+id;
            ResultSet rs = stmt.executeQuery(hmissionQuery);
            
            while(rs.next()){
                item1data[0]=rs.getInt(1);
                Integer count = null;
                count=rs.getInt(2);
                item1data[1]=count;
                item1data[2]=rs.getString("startTime");
                item1data[3]=rs.getString("deadline");
                item1data[4]=rs.getString("acceptTime");
                int missionid=rs.getInt(1);
                String monsQuery="select monsterid from MMission_has_Monster where huntingMissionId="+missionid;
                rs2=stmt.executeQuery(monsQuery);
                rs2.next();
                int monsid=rs2.getInt("monsterid");
                String itemNameQuery="select name from Monster where monsterid="+monsid;
                rs2=stmt.executeQuery(itemNameQuery);
                rs2.next();
                item1data[5]=rs2.getString(1);
                hunter1.addRow(item1data);
               
            }    
                
           
            
            
        }catch(SQLException err){
            System.out.print(err);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbed = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        ItemTable1 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        huntingtable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idtext = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        dltext = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        textlabel = new javax.swing.JLabel();
        itembox = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        updatebutton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        destext = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabbed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabbedMouseClicked(evt);
            }
        });

        ItemTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Description", "Item", "Start Time", "Deadline", "Accept Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
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
        ItemTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ItemTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ItemTable1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(ItemTable1);

        tabbed.addTab("Item-Foraging Mission", jScrollPane4);

        huntingtable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Description", "Monster", "Start Time", "Deadline", "Accept Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
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
        huntingtable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                huntingtable1MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(huntingtable1);

        tabbed.addTab("Hunting Mission", jScrollPane7);

        jLabel1.setText("ID: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(idtext, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addComponent(idtext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel3.setText("Deadline:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dltext, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dltext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        textlabel.setText("Item:");

        itembox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemboxActionPerformed(evt);
            }
        });

        jButton1.setText("Create Your Own Item");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(textlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(itembox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textlabel)
                    .addComponent(itembox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        updatebutton.setText("UPDATE");
        updatebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebuttonActionPerformed(evt);
            }
        });

        jButton2.setText("DELETE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(destext);

        jLabel2.setText("Description:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(updatebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbed, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbed, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(updatebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String mid=idtext.getText();
        
            //TODO
            DefaultTableModel modelTable;
            int index;
            if(tabbed.getSelectedIndex()==0){
                modelTable = (DefaultTableModel) ItemTable1.getModel();
                index= ItemTable1.getSelectedRow();
            }else{
                modelTable = (DefaultTableModel) huntingtable1.getModel();
                index= ItemTable1.getSelectedRow();
            }
            
            modelTable.removeRow(index);
            idtext.setText("");
            dltext.setText("");
            destext.setText("");
            int itemCount = itembox.getItemCount();

            for (int i = 0; i < itemCount; i++) {
                itembox.removeItemAt(0);
            }


        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ItemTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ItemTable1MouseClicked
        // TODO add your handling code here:
        int index=ItemTable1.getSelectedRow();
        TableModel model=ItemTable1.getModel();
        String missionid=model.getValueAt(index, 0).toString();
        String description=model.getValueAt(index, 1).toString();
        String item=model.getValueAt(index, 2).toString();
        
        String deadline=model.getValueAt(index, 4).toString();
        
        idtext.setText(missionid);
        dltext.setText(deadline);
        destext.setText(description);
        itembox.addItem(item);
        
        try{
            stmt = con.createStatement();
            String itemQuery = "select ItemName from Item_Name";
            rs = stmt.executeQuery(itemQuery);
            while(rs.next()){
                itembox.addItem(rs.getString("itemName"));
            }
           

        }catch(SQLException err){
            System.out.print(err);
            drawErrorDialog(err.toString(), "SQL Exception");
        }
        
        
        
        
    }//GEN-LAST:event_ItemTable1MouseClicked

    private void updatebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebuttonActionPerformed
        String dl=dltext.getText();
        String desc=destext.getText();
        String mid=idtext.getText();
        String item=itembox.getItemAt(0).toString();
        
        try{
            stmt = con.createStatement();
            String updateQuery;
            if(tabbed.getSelectedIndex()==0){
            updateQuery= "UPDATE Item_Foraging_Mission SET description ='"+desc+"', deadline = '" +dl+ "' where itemMissionId=" + mid;
            }else{
          updateQuery= "UPDATE Hunting_missions SET description ='"+desc+"', deadline = '" +dl+ "' where huntingMissionID=" + mid;
            }
            
            int row = stmt.executeUpdate(updateQuery);
            DefaultTableModel modelTable = (DefaultTableModel) ItemTable1.getModel();
            int index = ItemTable1.getSelectedRow();
            modelTable.setValueAt(item, index, 2);
            modelTable.setValueAt(dl, index, 4);
            modelTable.setValueAt(desc, index, 1);
            
        }catch(SQLException err){
            System.out.print(err);
            drawErrorDialog(err.toString(), "SQL Exception");
        }
        
        
        
    }//GEN-LAST:event_updatebuttonActionPerformed

    private void itemboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemboxActionPerformed

    private void tabbedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabbedMouseClicked
        
    }//GEN-LAST:event_tabbedMouseClicked

    private void huntingtable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_huntingtable1MouseClicked
        // TODO add your handling code here:
        int index=huntingtable1.getSelectedRow();
        TableModel model=huntingtable1.getModel();
        String missionid=model.getValueAt(index, 0).toString();
        String description=model.getValueAt(index, 1).toString();
        String item=model.getValueAt(index, 2).toString();
        
        String deadline=model.getValueAt(index, 4).toString();
        
        idtext.setText(missionid);
        dltext.setText(deadline);
        destext.setText(description);
        itembox.addItem(item);
        
        try{
            stmt = con.createStatement();
            String itemQuery = "select name from Monster";
            rs = stmt.executeQuery(itemQuery);
            while(rs.next()){
                itembox.addItem(rs.getString("name"));
            }
           

        }catch(SQLException err){
            System.out.print(err);
            drawErrorDialog(err.toString(), "SQL Exception");
        }
    }//GEN-LAST:event_huntingtable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new createItem().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
  
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ItemTable1;
    private javax.swing.JTextPane destext;
    private javax.swing.JTextField dltext;
    private javax.swing.JTable huntingtable1;
    private javax.swing.JLabel idtext;
    private javax.swing.JComboBox<String> itembox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane tabbed;
    private javax.swing.JLabel textlabel;
    private javax.swing.JButton updatebutton;
    // End of variables declaration//GEN-END:variables
}
