package com.codebind;
import javax.swing.*;
import java.io.*;
public class edit {
    public void editA(String category, String pastry){
        //calls on pastry call
        pastry Pastry = new pastry("text\\" + category + "\\" +pastry + ".txt");
        //initializes interface
        JFrame mainWindow = new JFrame("Edit");
        JLabel nameLabel = new JLabel("Name:");
        JTextArea pastryName = new JTextArea(Pastry.Pname);
        JLabel information = new JLabel("Information:");
        JTextArea addInfo = new JTextArea(Pastry.information);
        JLabel ingredientList = new JLabel("Ingredients:");
        JTextArea ingredients = new JTextArea(Pastry.ingredients);
        JLabel costLabel = new JLabel("Cost per serving ($):");
        JTextArea cost = new JTextArea(String.valueOf(Pastry.cost)); //coverts double to string
        JLabel recipeLabel = new JLabel("Recipe:");
        JTextArea recipe = new JTextArea(Pastry.recipe);
        JButton confirmation = new JButton("Confirm");
        JButton returnButton = new JButton("Return");
        JPanel edit = new JPanel();
        edit.setLayout(new BoxLayout(edit, BoxLayout.Y_AXIS)); // makes layout to make it easier to view
        edit.add(nameLabel);
        edit.add(pastryName);
        edit.add(information);
        edit.add(addInfo);
        edit.add(ingredientList);
        edit.add(ingredients);
        edit.add(costLabel);
        edit.add(cost);
        edit.add(recipeLabel);
        edit.add(recipe);
        edit.add(confirmation);
        edit.add(returnButton);
        mainWindow.add(edit);
        mainWindow.pack();
        mainWindow.setVisible(true);
        //adds functions to buttons for when user wants to confirm
        confirmation.addActionListener(e -> {
            JPanel put = new JPanel();
            put.setLayout(new BoxLayout(put, BoxLayout.Y_AXIS));
            JFrame confirmWindow = new JFrame("Confirmation Window");
            JLabel question = new JLabel("Are you sure you would like to edit this file?");
            JButton deny = new JButton("No");
            JButton confirm = new JButton("Yes");
            confirm.addActionListener(e1 -> {//if user chooses to confirm
                confirmWindow.dispose();
                String name = "text\\";
                String newName = name;
                name += category + "\\" + pastryName.getText() + ".txt";
                File newFile = new File(name);
                if (!(pastryName.getText().equals(pastry))){ //if file is given a new name, deletes the old file
                    newName += category + "\\" + pastry + ".txt";
                    File deleteFile = new File(newName);
                    deleteFile.delete();}
                try { //part that edits the file
                    FileWriter editWriter = new FileWriter(newFile);
                    String body = "Name:"+"\n"+pastryName.getText()+
                            "\nInformation:"+"\n"+addInfo.getText()+
                            "\nIngredients:"+"\n"+ingredients.getText()+
                            "\nCost per serving ($):"+"\n"+cost.getText()+
                            "\nRecipe:"+"\n"+recipe.getText();
                    editWriter.write(body);
                    editWriter.close();
                } catch (IOException ex) {//if an error catches through
                    new error();}
                confirmWindow.dispose();
                mainWindow.dispose();
                JFrame repeat = new JFrame("New File?");
                JPanel repeatPanel = new JPanel();
                JLabel exitLabel = new JLabel("Would you like to edit a new file?");
                JButton stay = new JButton("Yes");
                JButton exit = new JButton("No");
                stay.addActionListener(e11 -> { //if client wants to edit more recipes
                    App.pastryList();
                    App.condition ="edit";
                    repeat.dispose();});
                exit.addActionListener(e112 -> {//if client wants to return to main menu
                    repeat.dispose();
                    App.GUI();});
                repeatPanel.add(exitLabel);
                repeatPanel.add(stay);
                repeatPanel.add(exit);
                repeat.add(repeatPanel);
                repeat.pack();
                repeat.setVisible(true);});
            deny.addActionListener(e12 -> confirmWindow.dispose()); //if client decides they aren't done editing
            put.add(question);
            put.add(confirm);
            put.add(deny);
            confirmWindow.add(put);
            confirmWindow.pack();
            confirmWindow.setVisible(true);});
        returnButton.addActionListener(e -> new returnMenu(mainWindow, category));}} //if client doesn't want to edit anymore


