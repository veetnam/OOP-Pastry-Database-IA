package com.codebind;
import javax.swing.*;
public class App {
    // defines all visual parts of GUI
    private JPanel app;
    private JButton viewPast;
    private JPanel mainMenu;
    private JButton choux;
    public JPanel pastryList;
    private JButton puff;
    private JButton flaky;
    private JButton shortcrust;
    private JButton filo;
    private JButton addPast;
    private JButton editPast;
    private JButton removePast;
    private JButton quit;
    private JButton cancel;
    public static String condition;
    public static String category;
    public App() { // gives function to all the buttons
        quit.addActionListener(e -> System.exit(0));
        addPast.addActionListener(e -> {
            condition = "add";
            getMainFrame().dispose();
            pastryList();
        });
        editPast.addActionListener(e -> {
            condition = "edit";
            getMainFrame().dispose();
            pastryList();
        });
        removePast.addActionListener(e -> {condition = "delete";
          getMainFrame().dispose();
            pastryList();
            });
        choux.addActionListener(e -> {
            category = "Choux";
            pastries();
        });
        viewPast.addActionListener(e -> {
            condition = "display";
            getMainFrame().dispose();
            pastryList();

        });
        cancel.addActionListener(e -> {
            getListFrame().dispose();
            GUI();
        });
        filo.addActionListener(e -> {
            category = "Filo";
            pastries();
        });
        flaky.addActionListener(e -> {
            category = "Flaky";
            pastries();
        });
        shortcrust.addActionListener(e -> {
            category = "Shortcrust";
            pastries();
        });
        puff.addActionListener(e -> {
            category = "Puff";
            pastries();
        });
    }

    public static void main(String[] args){
        GUI();
    }
    public void pastries(){
        getListFrame().dispose();
        try{
            if (condition.equals("add")) {
                new add(category);
            }else {
                new buttons(category);
            }
        }catch(Exception ex) {
            new error();
            }
    }
    public static void GUI(){
        JFrame mainMenu = new JFrame("Main Menu");
            mainMenu.setContentPane(new App().mainMenu);
            mainMenu.pack();
            mainMenu.setVisible(true);
        }
    public static void pastryList(){
        JFrame pastryList = new JFrame("Pastry List");
        pastryList.setContentPane(new App().pastryList);
        pastryList.pack();
        pastryList.setVisible(true);
    }
    private JFrame getMainFrame() {return (JFrame) SwingUtilities.getWindowAncestor( this.mainMenu);}
    private JFrame getListFrame(){return (JFrame) SwingUtilities.getWindowAncestor(this.pastryList);}
}

