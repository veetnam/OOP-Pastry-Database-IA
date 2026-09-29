package com.codebind;
import java.io.FileWriter;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class add {
    public add(String category){
        //initializes interface
        JFrame show = new JFrame("Add a pastry");
        JLabel nameLabel = new JLabel("Name:");
        JTextArea nameField = new JTextArea();
        JLabel info = new JLabel("Information:");
        JTextArea addInfo = new JTextArea();
        JLabel ingredientLabel = new JLabel("Ingredients:");
        JTextArea ingredients = new JTextArea();
        JLabel money = new JLabel("Cost($)");
        JTextArea cost = new JTextArea();
        JLabel recipeLabel = new JLabel("Recipe:");
        JTextArea recipe = new JTextArea();
        JButton done = new JButton("Confirm");
        JButton leave = new JButton("Leave");
        JPanel edit = new JPanel();
        edit.setLayout(new BoxLayout(edit,BoxLayout.Y_AXIS));
        edit.add(nameLabel);
        edit.add(nameField);
        edit.add(info);
        edit.add(addInfo);
        edit.add(ingredientLabel);
        edit.add(ingredients);
        edit.add(money);
        edit.add(cost);
        edit.add(recipeLabel);
        edit.add(recipe);
        edit.add(done);
        edit.add(leave);
        show.add(edit);
        show.pack();
        show.setVisible(true);

        //adds function to button when they are done typing
        done.addActionListener(e -> {
            JPanel confirmPanel = new JPanel();
            confirmPanel.setLayout(new BoxLayout(confirmPanel,BoxLayout.Y_AXIS));
            JFrame confirm = new JFrame("Confirm?");
            JLabel question = new JLabel("Are you sure you would like to add this file?");
            JButton confirmCancel = new JButton("No");
            JButton confirmAnswer = new JButton("Yes");

            // if they are really done with the typing
            confirmAnswer.addActionListener(e1 -> {
                File newF = new File("text\\"+ App.category + "\\"+ nameField.getText() + ".txt");

                //new window made after file is created
                JFrame repeat = new JFrame("Add another file");
                JPanel repeatPanel = new JPanel();
                JLabel leaving = new JLabel("Would you like to add a new file?");
                JButton stay = new JButton("Yes");
                JButton exit = new JButton("No");
                stay.addActionListener(e1a -> { //if user wants to add another file (recursion)
                    repeat.dispose();
                    new add(category);
                });
                exit.addActionListener(e1b -> { //when user is done adding files
                    repeat.dispose();
                    App.GUI();
                });

                //adds everything into panel
                repeatPanel.add(leaving);
                repeatPanel.add(stay);
                repeatPanel.add(exit);
                repeat.add(repeatPanel);
                repeat.pack();
                try {
                    if (newF.createNewFile()) { //if the file is made
                        FileWriter edited = new FileWriter("text\\"+ App.category + "\\"+ nameField.getText() + ".txt");
                        String body = "Name:" + "\n" + nameField.getText() +
                                "\nInformation:" + "\n" + addInfo.getText() +
                                "\nIngredients:" + "\n" + ingredients.getText() +
                                "\nCost per serving ($):" + "\n" + cost.getText() +
                                "\nRecipe:" + "\n" + recipe.getText();
                        edited.write(body);
                        edited.close();
                        repeat.setVisible(true); //only sets visible if code works, or else will call on error class
                    } else { //if the file isn't made, error pops up
                        confirm.dispose();
                        new error();
                    }
                } catch (IOException ex) { //if try doesn't work, error class is called
                    confirm.dispose();
                    new error();
                }
                confirm.dispose();
                show.dispose();
            });
            confirmCancel.addActionListener(e2 -> confirm.dispose()); //if user doesn't want to confirm their pastry

            //adds everything into confirm panel
            confirmPanel.add(question);
            confirmPanel.add(confirmAnswer);
            confirmPanel.add(confirmCancel);
            confirm.add(confirmPanel);
            confirm.pack();
            confirm.setVisible(true);
        });
        leave.addActionListener(e -> new returnMenu(show));}} //On first frame when user wants to leave