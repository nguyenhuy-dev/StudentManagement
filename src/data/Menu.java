/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.*;

/**
 *
 * @author NGUYEN HUY
 */
public class Menu {
    private String menuTitle;
    private ArrayList<String> arr = new ArrayList();
    private LinkedHashSet<String> hset = new LinkedHashSet();

    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
    }
    
    public void addNewOption(String input) {
        if (hset.add(input)) 
            arr.add(input);
    } 
    
    public void printMenu() {
        if (arr.isEmpty()) {
            System.out.println("There is no item in the menu");
            return;
        }
        System.out.println("\nWelcome to " + menuTitle);
        for (String x : arr) 
            System.out.println(x);
    }
    
    public int getChoice() {
        int maxOption = arr.size();
        String inputMsg = "Choose [1.." + maxOption + "]: ";
        String errorMsg = "You are required to choose the option 1.." + maxOption;
        return MyToys.inputAnInteger(inputMsg, errorMsg, 1, maxOption);
    }
    
}
