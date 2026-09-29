package com.codebind;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class pastry {
    // initializes object
    String Pname;
    String information;
    String ingredients;
    double cost;
    String recipe;
    public pastry(String direction){ //reads file and gives values to variables
        File name =  new File(
                direction);
        StringBuilder textFromFile = new StringBuilder();
        try{
        Scanner sc = new Scanner(new FileReader(name));
        sc.nextLine();
            while (sc.hasNextLine()){
                textFromFile.append(sc.nextLine());
                textFromFile.append("\n");
            }
            sc.close();

        }catch (Exception ex){
            new error();
            }
        //sets each part of code into the different objects
        this.Pname = textFromFile.substring(textFromFile.indexOf("Name:") + 1,textFromFile.indexOf("Information:")-1);
        this.information = textFromFile.substring(textFromFile.indexOf("Information:")+13,textFromFile.indexOf("Ingredients:")-1);
        this.ingredients = textFromFile.substring(textFromFile.indexOf("Ingredients:") + 13,textFromFile.indexOf("Cost per serving ($):")-1);
        String tempCost = textFromFile.substring(textFromFile.indexOf("Cost per serving ($):") + 22,textFromFile.indexOf("Recipe:") - 1);
        try{
            this.cost = Double.parseDouble(tempCost);
        }catch(Exception ex){ //if the code can't read the file it will run this
            name.delete(); //the file is improperly made so is deleted
            new error();
        }
        this.recipe = textFromFile.substring(textFromFile.indexOf("Recipe:") + 8,textFromFile.length()-1);


        }
}
