package com.codebind;
import javax.swing.*;
public class error {
    public error(){
        //initializes interface components
        JFrame error = new JFrame("An error has occurred");
        JLabel message = new JLabel("The program has failed to load your request");
        JButton confirm = new JButton("Main Menu");
        confirm.addActionListener(e -> { //if user picks to go to main menu
            error.dispose();
            App.GUI();});
        JButton end = new JButton("End Program");
        end.addActionListener(e -> System.exit(0)); //if user ends program
        JPanel panel = new JPanel();
        panel.add(message);
        panel.add(confirm);
        panel.add(end);
        error.add(panel);
        error.pack();
        error.setVisible(true);
    }
}
