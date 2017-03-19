/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpsc304;

/**
 *
 * @author jingweizhang
 */
public class NewJPanel extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public NewJPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        TabbedPane = new javax.swing.JTabbedPane();
        TeamView = new javax.swing.JPanel();
        HuntingView = new javax.swing.JPanel();
        ItemView = new javax.swing.JPanel();
        LeaderBoard = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        StatusPanel = new javax.swing.JPanel();
        WelcomeField = new javax.swing.JLabel();
        balanceField = new javax.swing.JLabel();
        depositButton = new javax.swing.JButton();
        LevelField = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        experienceLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
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
        jLabel2 = new javax.swing.JLabel();

        setLayout(null);

        TabbedPane.setToolTipText("");
        TabbedPane.setName(""); // NOI18N

        TeamView.setOpaque(false);

        javax.swing.GroupLayout TeamViewLayout = new javax.swing.GroupLayout(TeamView);
        TeamView.setLayout(TeamViewLayout);
        TeamViewLayout.setHorizontalGroup(
            TeamViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 699, Short.MAX_VALUE)
        );
        TeamViewLayout.setVerticalGroup(
            TeamViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 564, Short.MAX_VALUE)
        );

        TabbedPane.addTab("ManageTeam", TeamView);

        HuntingView.setOpaque(false);

        javax.swing.GroupLayout HuntingViewLayout = new javax.swing.GroupLayout(HuntingView);
        HuntingView.setLayout(HuntingViewLayout);
        HuntingViewLayout.setHorizontalGroup(
            HuntingViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 699, Short.MAX_VALUE)
        );
        HuntingViewLayout.setVerticalGroup(
            HuntingViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 564, Short.MAX_VALUE)
        );

        TabbedPane.addTab("Hunting", HuntingView);

        ItemView.setOpaque(false);

        javax.swing.GroupLayout ItemViewLayout = new javax.swing.GroupLayout(ItemView);
        ItemView.setLayout(ItemViewLayout);
        ItemViewLayout.setHorizontalGroup(
            ItemViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 699, Short.MAX_VALUE)
        );
        ItemViewLayout.setVerticalGroup(
            ItemViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 564, Short.MAX_VALUE)
        );

        TabbedPane.addTab("Item-Foraging", ItemView);
        ItemView.getAccessibleContext().setAccessibleName("Item-");

        LeaderBoard.setOpaque(false);

        jScrollPane3.setOpaque(false);

        javax.swing.GroupLayout LeaderBoardLayout = new javax.swing.GroupLayout(LeaderBoard);
        LeaderBoard.setLayout(LeaderBoardLayout);
        LeaderBoardLayout.setHorizontalGroup(
            LeaderBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
        );
        LeaderBoardLayout.setVerticalGroup(
            LeaderBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
        );

        TabbedPane.addTab("LeaderBoard", LeaderBoard);
        LeaderBoard.getAccessibleContext().setAccessibleName("LeaderBoard");

        add(TabbedPane);
        TabbedPane.setBounds(312, 0, 720, 610);
        TabbedPane.getAccessibleContext().setAccessibleName("ManageYourTeam");

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

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 8)); // NOI18N
        jLabel1.setText("2553/9992");

        rankLabel.setText("Rank:1209");

        TeamLabel.setText("Team: Flying Over");

        TeamRankLabel.setText("TeamRank: 12");

        MissionList.setBackground(new java.awt.Color(102, 102, 102));
        MissionList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        MissionList.setOpaque(false);
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
                                        .addComponent(jLabel1))
                                    .addComponent(LevelField))
                                .addGroup(StatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(StatusPanelLayout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(rankLabel)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(StatusPanelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))))
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
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(StatusPanel);
        StatusPanel.setBounds(0, 0, 300, 600);
        StatusPanel.getAccessibleContext().setAccessibleName("");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/u=3614819154,3895031968&fm=214&gp=0.jpg"))); // NOI18N
        jLabel2.setIconTextGap(0);
        jLabel2.setIgnoreRepaint(true);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ObjectProperty.create(), jLabel2, org.jdesktop.beansbinding.BeanProperty.create("background"));
        bindingGroup.addBinding(binding);

        add(jLabel2);
        jLabel2.setBounds(-20, -90, 1070, 800);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void depositButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_depositButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HuntingView;
    private javax.swing.JList<String> ItemList;
    private javax.swing.JPanel ItemView;
    private javax.swing.JLabel JustItemLabel;
    private javax.swing.JLabel JustMissionLabel;
    private javax.swing.JPanel LeaderBoard;
    private javax.swing.JLabel LevelField;
    private javax.swing.JList<String> MissionList;
    private javax.swing.JScrollPane MissionsScrollRanel;
    private javax.swing.JPanel StatusPanel;
    private javax.swing.JTabbedPane TabbedPane;
    private javax.swing.JLabel TeamLabel;
    private javax.swing.JLabel TeamRankLabel;
    private javax.swing.JPanel TeamView;
    private javax.swing.JLabel WelcomeField;
    private javax.swing.JLabel balanceField;
    private javax.swing.JButton depositButton;
    private javax.swing.JLabel experienceLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel rankLabel;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
