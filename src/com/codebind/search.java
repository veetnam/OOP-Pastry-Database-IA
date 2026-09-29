package com.codebind;
import java.util.regex.*;
import java.util.*;
import javax.swing.*;

public class search {
    //initializes booleans for later
    public static boolean nameSort;
    public static String conditionToReturn;
    public static JFrame mainFrame;
    public static JFrame search;

    public static boolean lowest;

    public search(ArrayList<String> pastryList, String category,JFrame frame, String condition,String input,JFrame searchFrame,boolean typeOfSort, boolean forward, boolean words) {

        conditionToReturn = condition;
        mainFrame = frame;
        search = searchFrame;
        nameSort = words;
        lowest = forward;
        if(typeOfSort){name(input,pastryList,category);}else{ingredient(input,pastryList,category);}

    }

public void name(String input,ArrayList<String> pastryList, String category){
        ArrayList<String> newPastryList = new ArrayList<>();
        List<String> result = pastryList.stream() //converts all parts of code to lowercase
                .map(String::toLowerCase).toList();
        input = input.toLowerCase();
        for (String pastry:result) { //compares each pastry to see if user input matches the pastry name
            Pattern pattern = Pattern.compile(input);
            Matcher match = pattern.matcher(pastry);
            if (match.find()) {newPastryList.add(pastry);}}
    callback(newPastryList,category);}

    public void ingredient(String input, ArrayList<String> list,String category){
            ArrayList<String> newPastryList = new ArrayList<>();
            Pattern pattern = Pattern.compile(input); // takes input to compile
            for(String pastry:list){ // compares each pastry's ingredients to the input
                pastry specificPastry = new pastry("text\\" + category + "\\" +pastry + ".txt");
                Matcher match = pattern.matcher(specificPastry.ingredients); //checks if the input is in the list of ingredients
                if(match.find()){newPastryList.add(pastry);}
    }
    callback(newPastryList,category);}
 public void callback(ArrayList<String> newPastryList, String category){
     ArrayList<pastry> coll = new ArrayList<>();
        if(!nameSort){ //sorts by cost
            for(String pastry:newPastryList){
                pastry pastry1 =new pastry("text\\" + category + "\\" +pastry + ".txt");
                coll.add(pastry1);
            }
            coll.sort(new pastryCompare()); // sorts by cost
        }else{ //sorts by name
            Collections.sort(newPastryList);
            for(String pastry:newPastryList){
            pastry pastry1 =new pastry("text\\" + category + "\\" +pastry + ".txt");
            coll.add(pastry1);
        }}
        newPastryList.clear(); //clears new list to use later
        if(!lowest) { //reverse sort, can't use collections comparator for costs so resort to this
            for(int i = coll.size()-1;i>=0;i--){
                newPastryList.add((coll.get(i)).Pname);}
            }else{for(pastry pastry:coll){newPastryList.add(pastry.Pname);}}
     search.dispose();
     mainFrame.dispose();
     JFrame pastryFrame = new JFrame("Filtered list of " + category + " pastries");
     switch (App.condition) { //calls button display class to display new list of pastries
         case "display" -> buttons.displayed(newPastryList, category, pastryFrame);
         case "delete" -> buttons.deleted(newPastryList, pastryFrame);
         case "edit" -> buttons.edited(newPastryList, pastryFrame);
     }
 }
    public static class pastryCompare implements Comparator<pastry> {
        @Override
        public int compare(pastry p1, pastry p2) {
            int costCompare = Double.compare(p1.cost, p2.cost);
            if (costCompare != 0) {
                return costCompare;
            }
            return p1.Pname.compareTo(p1.Pname);
        }
    }
 }
