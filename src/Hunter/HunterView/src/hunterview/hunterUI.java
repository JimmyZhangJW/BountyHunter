/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hunterview;
import java.awt.Color;
import javax.swing.*;
import java.awt.Component;
/**
 *
 * @author jingweizhang
 */
public class hunterUI extends javax.swing.JPanel {

    /**
     * Creates new form hunterUI
     */
    public hunterUI() {
        initComponents();
        
    }
    
    private class TransparentPanel extends javax.swing.JPanel {
    {
        setOpaque(false);
    }
    public void paintComponent(java.awt.Graphics g) {
        g.setColor(getBackground());
        java.awt.Rectangle r = g.getClipBounds();
        g.fillRect(r.x, r.y, r.width, r.height);
        super.paintComponent(g);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        TeamPanel = new javax.swing.JPanel();
        huntingPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        StatusPanel = new javax.swing.JPanel();
        WelcomeField = new javax.swing.JLabel();
        balanceField = new javax.swing.JLabel();
        depositButton = new javax.swing.JButton();
        LevelField = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        experienceLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rankLabel = new javax.swing.JLabel();
        TeamLabel = new javax.swing.JLabel();
        TeamRankLabel = new javax.swing.JLabel();
        MissionsScrollRanel = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        MissionList = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        ItemList = new javax.swing.JList<>();
        JustItemLabel = new javax.swing.JLabel();
        JustMissionLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setLayout(null);

        TeamPanel.setOpaque(false);

        javax.swing.GroupLayout TeamPanelLayout = new javax.swing.GroupLayout(TeamPanel);
        TeamPanel.setLayout(TeamPanelLayout);
        TeamPanelLayout.setHorizontalGroup(
            TeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );
        TeamPanelLayout.setVerticalGroup(
            TeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 632, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("ManageTeam", TeamPanel);

        huntingPanel.setOpaque(false);

        javax.swing.GroupLayout huntingPanelLayout = new javax.swing.GroupLayout(huntingPanel);
        huntingPanel.setLayout(huntingPanelLayout);
        huntingPanelLayout.setHorizontalGroup(
            huntingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );
        huntingPanelLayout.setVerticalGroup(
            huntingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 632, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("HuntingMissions", huntingPanel);

        jPanel1.setOpaque(false);

        StatusPanel.setBackground(new java.awt.Color(54, 47, 47));
        StatusPanel.setForeground(new java.awt.Color(204, 102, 0));
        StatusPanel.setOpaque(false);

        WelcomeField.setFont(new java.awt.Font("Luminari", 0, 18)); // NOI18N
        WelcomeField.setText("Welcome, Jingwei!");

        balanceField.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        balanceField.setText("Balance: 233333");

        depositButton.setBackground(new java.awt.Color(0, 255, 51));
        depositButton.setFont(new java.awt.Font("Lucida Grande", 1, 10)); // NOI18N
        depositButton.setForeground(new java.awt.Color(153, 153, 153));
        depositButton.setText("DepositGold");
        depositButton.setToolTipText("");
        depositButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositButtonActionPerformed(evt);
            }
        });

        LevelField.setText("Level:S");

        jProgressBar1.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar1.setForeground(new java.awt.Color(255, 51, 102));
        jProgressBar1.setValue(47);

        experienceLabel.setText("EXP:");
        experienceLabel.setAlignmentY(0.0F);
        experienceLabel.setAutoscrolls(true);
        experienceLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.N_RESIZE_CURSOR));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 8)); // NOI18N
        jLabel2.setText("2553/9992");

        rankLabel.setText("Rank:1209");

        TeamLabel.setText("Team: Flying Over");

        TeamRankLabel.setText("TeamRank: 12");

        MissionsScrollRanel.setOpaque(false);

        MissionList.setBackground(new java.awt.Color(102, 102, 102));
        MissionList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(MissionList);

        MissionsScrollRanel.setViewportView(jScrollPane2);

        ItemList.setBackground(new java.awt.Color(153, 153, 153));
        ItemList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(ItemList);

        JustItemLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        JustItemLabel.setText("Your items:");

        JustMissionLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        JustMissionLabel.setText("YourMissions:");

        javax.swing.GroupLayout StatusPanelLayout = new javax.swing.GroupLayout(StatusPanel);
        StatusPanel.setLayout(StatusPanelLayout);
        StatusPanelLayout.setHorizontalGroup(
            StatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StatusPanelLayout.createSequentialGroup()
                .addGroup(StatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, StatusPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(StatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(StatusPanelLayout.createSequentialGroup()
                                .addGroup(StatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(StatusPanelLayout.createSequentialGroup()
                                        .addComponent(experienceLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2))
                                    .addComponent(LevelField))
                                .addGroup(StatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(StatusPanelLayout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(rankLabel)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(StatusPanelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))))
                            .addGroup(StatusPanelLayout.createSequentialGroup()
                                .addGroup(StatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(StatusPanelLayout.createSequentialGroup()
                                        .addComponent(balanceField)
                                        .addGap(18, 18, 18)
                                        .addComponent(depositButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(TeamLabel)
                                    .addComponent(TeamRankLabel)
                                    .addComponent(WelcomeField, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(MissionsScrollRanel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, StatusPanelLayout.createSequentialGroup()
                        .addGroup(StatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JustMissionLabel)
                            .addComponent(JustItemLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        StatusPanelLayout.setVerticalGroup(
            StatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StatusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(WelcomeField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(StatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(balanceField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(depositButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(StatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LevelField)
                    .addComponent(rankLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(StatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(experienceLabel)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TeamLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TeamRankLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JustMissionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MissionsScrollRanel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(JustItemLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(StatusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(207, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(StatusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab(" ItemMissions", jPanel1);

        jPanel2.setOpaque(false);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(jList1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("LeaderBoard", jPanel2);

        add(jTabbedPane1);
        jTabbedPane1.setBounds(290, 0, 511, 573);
        jTabbedPane1.getAccessibleContext().setAccessibleName("HuntingMissions");
    }// </editor-fold>//GEN-END:initComponents

    private void depositButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_depositButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> ItemList;
    private javax.swing.JLabel JustItemLabel;
    private javax.swing.JLabel JustMissionLabel;
    private javax.swing.JLabel LevelField;
    private javax.swing.JList<String> MissionList;
    private javax.swing.JScrollPane MissionsScrollRanel;
    private javax.swing.JPanel StatusPanel;
    private javax.swing.JLabel TeamLabel;
    private javax.swing.JPanel TeamPanel;
    private javax.swing.JLabel TeamRankLabel;
    private javax.swing.JLabel WelcomeField;
    private javax.swing.JLabel balanceField;
    private javax.swing.JButton depositButton;
    private javax.swing.JLabel experienceLabel;
    private javax.swing.JPanel huntingPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel rankLabel;
    // End of variables declaration//GEN-END:variables
    public static void main(String args[]){
        //Run in the EDT
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new hunterUI();
            }
        });
    }
    
    public class TransparentListCellRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            setForeground(Color.BLACK);
            setOpaque(isSelected);
            return this;
        }
    }


}


