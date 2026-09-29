package com.codebind;
import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.util.*;

public class buttons {
    private static int i = 0;
    public buttons(String category){ // gets list of pastries to give
        ArrayList<String> buttonList = new ArrayList<>();
        File folder = new File( "text\\" + category);
        File[] listOfFiles = folder.listFiles(); //gets the files in the folder
        int index;
        String name;
        assert listOfFiles != null: new error();
        for (File listOfFile : listOfFiles) { //makes list of pastries
            name = listOfFile.getName();
            index = name.indexOf(".");
            name = name.substring(0, index);
            buttonList.add(name);
        }
        JFrame mainFrame = new JFrame(category + " Pastries");
        switch (App.condition) {//based on conditions from App class
            case "display" -> displayed(buttonList, category, mainFrame);
            case "delete" -> deleted(buttonList, mainFrame);
            case "edit" -> edited(buttonList, mainFrame);
        }
    }
    public static void buttonAdd(JFrame frame,JPanel panel, ArrayList<String> buttonList){ //at the end of adding the main buttons
        JButton exit = new JButton("Would you like to return?");
        exit.setPreferredSize(new Dimension(1400,50));
        exit.addActionListener(e -> new returnMenu(frame));
        JButton search = new JButton("Would you like to filter?");
        search.setPreferredSize(new Dimension(1400,50));
        search.addActionListener(e -> new filter(App.condition,buttonList,App.category,frame));
        panel.add(search);
        panel.add(exit);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);}
    public static void displayed(ArrayList<String> buttonList, String category, JFrame frame){ //if client chose to display pastries
        int size = buttonList.size();
        JButton[] buttons = new JButton[size];
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        for (int i = 0; i < buttonList.size(); i++) { //converts from arrayList to array
            buttons[i] = new JButton(buttonList.get(i));
            buttons[i].setActionCommand(buttonList.get(i));
            buttons[i].addActionListener(e -> {
                String choice = e.getActionCommand();
                display show = new display();
                show.displayInfo(category, choice);
                frame.dispose();});
            panel.add(buttons[i]);}
        JButton random = new JButton("Would you like to find a random pastry from this category?");
        random.addActionListener(e -> { // random button
            Random rand = new Random();
            int index = rand.nextInt(buttonList.size());
            String choice = buttonList.get(index);
            display show = new display();
            show.displayInfo(category, choice);
            frame.dispose();});
        panel.add(random);
        buttonAdd(frame,panel,buttonList);}

    public static void edited(ArrayList<String> buttonList, JFrame frame) { //if client chose to edit pastries
        int size = buttonList.size();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        JButton[] buttons = new JButton[size];
        for (i = 0; i < size; i++) {
            buttons[i] = new JButton(buttonList.get(i));
            buttons[i].setActionCommand(buttonList.get(i));
            buttons[i].addActionListener(e -> {
                String choice = e.getActionCommand();
                edit sh = new edit();
                frame.dispose();
                try {sh.editA(App.category, choice);
                }catch (Exception ex) {new error();}});
            panel.add(buttons[i]);}
        buttonAdd(frame,panel,buttonList);}

    public static void deleted(ArrayList<String> buttonList, JFrame frame){ //if client chose to delete a pastry
        int size = buttonList.size();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        JButton[] buttons = new JButton[size];
        for (i = 0; i < size; i++) {
            buttons[i] = new JButton(buttonList.get(i));
            buttons[i].setActionCommand(buttonList.get(i));
            buttons[i].addActionListener(e -> {
                String choice = e.getActionCommand();
                new delete(App.category, choice,frame);});
            panel.add(buttons[i]);}
        buttonAdd(frame,panel,buttonList);}}