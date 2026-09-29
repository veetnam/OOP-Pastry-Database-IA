package com.codebind;
import java.io.*;
import javax.swing.*;

public class delete {
    public delete(String category, String name,JFrame frame){
        File file = new File("text\\" + category + "\\" +name + ".txt"); //calls file
        file.delete(); //deletes
        frame.dispose(); //disposes of last frame
        //start of initializing interface
        JFrame repeat = new JFrame("Return");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        JLabel leave = new JLabel("Would you like to exit?");
        JButton confirm = new JButton("Yes");
        JButton deny = new JButton("No");
        confirm.addActionListener(e -> new returnMenu(repeat, category));
        deny.addActionListener(e -> {
            repeat.dispose();
            App.pastryList();
        });
        panel.add(leave);
        panel.add(confirm);
        panel.add(deny);
        repeat.add(panel);
        repeat.pack();
        repeat.setVisible(true);

    }
}
