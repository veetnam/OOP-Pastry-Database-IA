package com.codebind;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class filter {
    public filter(String condition,ArrayList<String> buttons, String category, JFrame frame){
        //initializes interface components
        JLabel inputLabel = new JLabel("Input search:");
        JTextArea input = new JTextArea();
        JCheckBox alphabetically = new JCheckBox("A to Z");
            alphabetically.setSelected(true);
        JCheckBox reverseAlphabetically = new JCheckBox("Z to A");
        JCheckBox lowCost = new JCheckBox("Lowest");
        JCheckBox highCost = new JCheckBox("Highest");
        JCheckBox name = new JCheckBox("Recipe Name?");
            name.setSelected(true);
        JCheckBox ingredient = new JCheckBox("Ingredients?");
        JButton search = new JButton("Put search");
        //automatically changes the checkbox if the user clicks on a different checkbox
            alphabetically.addActionListener(e-> {reverseAlphabetically.setSelected(false);
                highCost.setSelected(false);
                lowCost.setSelected(false);});
            lowCost.addActionListener(e -> {highCost.setSelected(false);
                alphabetically.setSelected(false);
                reverseAlphabetically.setSelected(false);});
            highCost.addActionListener(e -> {lowCost.setSelected(false);
                alphabetically.setSelected(false);
                reverseAlphabetically.setSelected(false);});
            reverseAlphabetically.addActionListener(e-> {alphabetically.setSelected(false);
                highCost.setSelected(false);
                lowCost.setSelected(false);});
            name.addActionListener(e-> ingredient.setSelected(false));
            ingredient.addActionListener(e-> name.setSelected(false));
        JPanel filter1 = new JPanel(new GridLayout(2,2));
            filter1.add(alphabetically);
            filter1.add(reverseAlphabetically);
            filter1.add(highCost);
            filter1.add(lowCost);
            filter1.setBorder(BorderFactory.createLineBorder(Color.black));
        JPanel filter2 = new JPanel();
            filter2.add(name);
            filter2.add(ingredient);
            filter2.setBorder(BorderFactory.createLineBorder(Color.black));
        JPanel last = new JPanel();
            last.add(search);
        JPanel first = new JPanel();
            first.setLayout(new GridLayout(2,1));
            first.add(inputLabel);
            first.add(input);
        JPanel second = new JPanel();
            second.setLayout(new BoxLayout(second, BoxLayout.X_AXIS));
            second.add(filter1);
            second.add(filter2);
        JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
            mainPanel.add(first);
            mainPanel.add(second);
            mainPanel.add(last);
        JFrame menu = new JFrame("Filter");
            menu.add(mainPanel);
            menu.pack();
            menu.setVisible(true);

        //when user clicks search
        search.addActionListener(e -> {
            //makes booleans based on checkboxes then calls search class
            String inputVariable = input.getText();
            boolean name1 = true;
            boolean forward = true;
            boolean alphabet = true;
            if(ingredient.isSelected()){
                name1 = false;}
            if(reverseAlphabetically.isSelected()||highCost.isSelected()){forward = false;}
            if(highCost.isSelected()||lowCost.isSelected()){alphabet = false;}
            new search(buttons,category,frame,condition,inputVariable,menu, name1,forward,alphabet);

        });
    }
}
