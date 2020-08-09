package uno;

import javax.swing.*;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//    -    -    -    -    -    -    -    -    -     class / constructor

public class AddPlayerNames extends JFrame {
    public ArrayList<String> playerIds;

    public AddPlayerNames() {

        playerIds = new ArrayList<>();

        add(jPanel1);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 250));
        setSize(800, 500);
        setTitle("Uno - Menu");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { saveButton(); }
        });
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { doneButton(); }
        });
    }

    //    -    -    -    -    -    -    -    -    -     methods

    public String[] getPids() {
        String[] pids = playerIds.toArray(new String[playerIds.size()]);
        return pids;
    }

    private void saveButton() {
        if (pidTextBox.getText().isEmpty()) {
            JLabel message = new JLabel("Please enter in a name..");
            message.setFont(new Font("Arial", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message);
        }
        else {
            String name = pidTextBox.getText().trim();
            playerIds.add(name);

            if (playerIds.size() == 1) {
                pidOneLabel.setText(playerIds.get(0));
            }
            else if (playerIds.size() == 2) {
                pidOneLabel.setText(playerIds.get(0));
                pidTwoLabel.setText(playerIds.get(1));
            }
            else if (playerIds.size() == 3) {
                pidOneLabel.setText(playerIds.get(0));
                pidTwoLabel.setText(playerIds.get(1));
                pidThreeLabel.setText(playerIds.get(2));
            }
            else if (playerIds.size() == 4) {
                pidOneLabel.setText(playerIds.get(0));
                pidTwoLabel.setText(playerIds.get(1));
                pidThreeLabel.setText(playerIds.get(2));
                pidFourLabel.setText(playerIds.get(3));
            }
            if (playerIds.size() > 0 && playerIds.size() < 5) {
                // JLabel message = new JLabel("Succesfull Save!");
                // message.setFont(new Font("Arial", Font.BOLD, 48));
                // JOptionPane.showMessageDialog(null, message);
                pidTextBox.setText("");
            }
            if (playerIds.size() == 5) {
                playerIds.remove(name);
                JLabel message = new JLabel("Only have 2 - 4 Players");
                message.setFont(new Font("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message);
                pidTextBox.setText("");
            }

        }
    }

    private void doneButton() {
        if (playerIds.size() == 1 || playerIds.size() == 0) {
            JLabel message = new JLabel("must be at least 2 players");
            message.setFont(new Font("Arial", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message);
            pidTextBox.setText("");
        }
        else {
            this.dispose();
            new GameStage(playerIds).setVisible(true);
        }
    }

    //    -    -    -    -    -    -    -    -    -     main

    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddPlayerNames().setVisible(true);
            }
        });
    }

    //    -    -    -    -    -    -    -    -    -     JFrame components

    private JPanel jPanel1;
    private JTextField pidTextBox;
    private JButton doneButton;
    private JButton saveButton;
    private JLabel pidOneLabel;
    private JLabel pidTwoLabel;
    private JLabel pidFourLabel;
    private JLabel pidThreeLabel;
}
