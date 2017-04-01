package Hunter;

import javax.swing.*;
import java.awt.*;

public class noTeam {
    private JPanel mainWindow;
    private JList teamList;
    private JButton joinTeamButton;
    private JPanel infoArea;
    private JLabel teamNameLabel;
    private JLabel teamRankLabel;
    private JLabel teamCaptainLabel;
    private JLabel teamRank;
    private JLabel teamCaptain;
    private JLabel teamName;

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainWindow = new JPanel();
        mainWindow.setLayout(new GridBagLayout());
        mainWindow.setPreferredSize(new Dimension(400, 550));
        teamList = new JList();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainWindow.add(teamList, gbc);
        joinTeamButton = new JButton();
        joinTeamButton.setText("Join Team!");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainWindow.add(joinTeamButton, gbc);
        infoArea = new JPanel();
        infoArea.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainWindow.add(infoArea, gbc);
        teamNameLabel = new JLabel();
        teamNameLabel.setText("Team Name:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        infoArea.add(teamNameLabel, gbc);
        teamRankLabel = new JLabel();
        teamRankLabel.setText("Team Rank:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        infoArea.add(teamRankLabel, gbc);
        teamCaptainLabel = new JLabel();
        teamCaptainLabel.setText("Team Captain:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        infoArea.add(teamCaptainLabel, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainWindow;
    }
}
