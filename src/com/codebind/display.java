package com.codebind;
import javax.swing.*;
public class display{
    public void displayInfo(String type, String pastry){
        //initialization of files
        JFrame displayWindow = new JFrame(pastry);
        pastry file = new pastry("text\\"+ type + "\\"+ pastry + ".txt"); //calls pastry class to get info
        JLabel nameLabel = new JLabel("Name:");
        //sets all objects of pastry to text fields
        JTextArea name = new JTextArea(file.Pname);
            name.setEditable(false);
        JLabel infoLabel = new JLabel("Information:");
        JTextArea information = new JTextArea(file.information);
            information.setEditable(false);
        JLabel ingredientLabel = new JLabel("Ingredients: ");
        JTextArea ingredientList = new JTextArea(file.ingredients);
            ingredientList.setEditable(false);
        JLabel money = new JLabel("Cost ($): ");
        JTextArea cost = new JTextArea(String.valueOf(file.cost));
            cost.setEditable(false);
        JLabel recipeLabel = new JLabel("Recipe:");
        JTextArea steps = new JTextArea(file.recipe);
        steps.setEditable(false);
        JButton leave = new JButton("Would you like to exit?");
        //if user exits
        leave.addActionListener(e -> new returnMenu(displayWindow, type));
        JPanel viewer = new JPanel();
        viewer.setLayout(new BoxLayout(viewer,BoxLayout.Y_AXIS));
        JFrame questionFrame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        JLabel question = new JLabel("What would you like to do?");
        JButton informationButton = new JButton("View Information");
        //if user picked view information
        informationButton.addActionListener(e -> {
            viewer.add(infoLabel);
            viewer.add(information);
            viewer.add(leave);
            questionFrame.dispose();
            displayWindow.pack();
            displayWindow.setVisible(true);
        });
        JButton recipeB = new JButton("View Recipe");
        //if user picked view recipe
        recipeB.addActionListener(e -> {
            viewer.add(ingredientLabel);
            viewer.add(ingredientList);
            viewer.add(money);
            viewer.add(cost);
            viewer.add(recipeLabel);
            viewer.add(steps);
            viewer.add(leave);
            questionFrame.dispose();
            displayWindow.pack();
            displayWindow.setVisible(true);
        });
        JButton both = new JButton("View Both Recipe & Information");
        //if user picked to see both
        both.addActionListener(e -> {
            viewer.add(infoLabel);
            viewer.add(information);
            viewer.add(ingredientLabel);
            viewer.add(ingredientList);
            viewer.add(money);
            viewer.add(cost);
            viewer.add(recipeLabel);
            viewer.add(steps);
            viewer.add(leave);
            questionFrame.dispose();
            displayWindow.pack();
            displayWindow.setVisible(true);

        });
        panel.add(question);
        panel.add(informationButton);
        panel.add(recipeB);
        panel.add(both);
        questionFrame.add(panel);
        questionFrame.setVisible(true);
        questionFrame.pack();
        viewer.add(nameLabel);
        viewer.add(name);
        displayWindow.add(viewer);

    }
}
