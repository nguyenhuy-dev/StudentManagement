/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.fu.studentmanagementv2;

import data.*;

/**
 *
 * @author NGUYEN HUY
 */
public class StudentManagementV2 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Menu menu = new Menu("FAP - FPT Academic Portal");
        Cabinet tuSE = new Cabinet();
        Cabinet tuSS = new Cabinet();
        menu.addNewOption("1. Add a SE student");
        menu.addNewOption("2. Add a SS student");
        menu.addNewOption("3. Search a student profile by id");
        menu.addNewOption("4. Update a student profile by id");
        menu.addNewOption("5. Remove a student profile by id");
        menu.addNewOption("6. Print the SE student list ascending by id");
        menu.addNewOption("7. Print the SS student list ascending by id");
        menu.addNewOption("8. Print the student list ascending by name");
        menu.addNewOption("9. Quit");
        
        int choice;
        do {            
            menu.printMenu();
            choice = menu.getChoice();
            System.out.println("----------------------------------------------");
            switch (choice) {
                case 1:
                    tuSE.addAStudent();
                    break;
                case 2:
                    tuSS.addAStudent();
                    break;
                case 3:
                    tuSE.searchAStudent();
                    break;
                case 4:
                    tuSE.updateAStudent();
                    break;
                case 5:
                    tuSE.removeAStudent();
                    break;
                case 6:
                    tuSE.printStudentListAscendingByID();
                    break;
                case 7:
                    tuSS.printStudentListAscendingByID();
                    break;
                case 8:
                    tuSE.printStudentListAscendingByName();
                    break;
                case 9:
                    System.out.println("Pye, see you next time");
                    break;
            }
        } while (choice != 9);
    }
    
}
