package com.codebind;
import javax.swing.*;


public class returnMenu {
    public returnMenu(JFrame frame, String category){ //will run when user has picked specific category
        //initializes interface components
        JFrame returnFrame = new JFrame("Return");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        JLabel leaveLabel = new JLabel("Which menu would you like to go to?");
        leaveLabel.setSize(1400, 80);
        panel.add(leaveLabel);
        JButton gui = new JButton("Main Menu");
        gui.addActionListener(e -> { //when user wants to go to main menu
            frame.dispose();
            returnFrame.dispose();
            App.GUI();
        });
        gui.setSize(1400, 80);
        panel.add(gui);
        JButton categories = new JButton("Categories of pastries");
        categories.addActionListener(e -> { //when user wants to go to the 5 categories
            frame.dispose();
            returnFrame.dispose();
            App.pastryList();
        });
        panel.add(categories);
        JButton past = new JButton("List of Pastries");
         past.addActionListener(e -> { //when user wants to go to specific list of pastries
             new buttons(category);
             frame.dispose();
             returnFrame.dispose();
         });
         past.setSize(1400, 80);
            past.setSize(1400, 80);
            panel.add(past);
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(e -> returnFrame.dispose()); //cancels and the user can resume their last frame
        categories.setSize(1400, 80);
        panel.add(categories);
        panel.add(cancel);
        returnFrame.add(panel);
        returnFrame.pack();
        returnFrame.setVisible(true);
    }
    public returnMenu(JFrame frame){ //used when specific pastry category isn't necessary
        //initializes components
        JFrame returnFrame = new JFrame("Return");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        JLabel leaveLabel = new JLabel("Which menu would you like to go to?");
        leaveLabel.setSize(1400, 80);
        panel.add(leaveLabel);
        JButton displayButton = new JButton("Main Menu");
        displayButton.addActionListener(e -> { //returns to main menu
            frame.dispose();
            returnFrame.dispose();
            App.GUI();
        });
        displayButton.setSize(1400, 80);
        panel.add(displayButton);
        JButton categories = new JButton("Categories of pastries");
        categories.addActionListener(e -> { //returns to 5 categories
            frame.dispose();
            returnFrame.dispose();
            App.pastryList();
        });
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(e -> returnFrame.dispose()); //closes return window
        categories.setSize(1400, 80);
        panel.add(categories);
        panel.add(cancel);
        returnFrame.add(panel);
        returnFrame.pack();
        returnFrame.setVisible(true);
    }
}
