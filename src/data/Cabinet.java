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
public class Cabinet {

    private List<Student> arr = new ArrayList(); // = new ArrayList() là đủ, add() vào tính sau
    private Scanner sc = new Scanner(System.in);

    // Phễu này được gọi là phễu rỗng/empty constructor/default constructor
    public Cabinet() {
    }

    public void addAStudent() {
        String id, name;
        int yob;
        double gpa;
        System.out.println("Input student: #" + (arr.size() + 1));
        id = inputNonDuplicatedId();
        System.out.print("Input name: ");
        name = sc.nextLine().trim().toUpperCase();
        yob = MyToys.inputAnInteger("Input yob: ", "Input yob again, plz!!");
        gpa = MyToys.inputADouble("Input gpa: ", "Input gpa again, plz!!");
        arr.add(new Student(id, name, yob, gpa));
        System.out.println("Add a student successfully");
    }

    public void printStudentList() {
        if (arr.isEmpty()) {
            System.out.println("There is no student to print");
            return; // return dùng để thoát 1 hàm, break dùng để thoát 1 switch/loop 
        }
        System.out.println("There is/are " + arr.size() + " student(s)");
        for (Student x : arr) 
            x.showProfile();
    }
    
    public Student searchAStudent(String id) {  // kiểm tra xem có trong giỏ không
        if (id.isEmpty()) 
            return null;
        for (Student x : arr) 
            if (x.getId().equals(id)) 
                return x;
        return null;    
    }
    
    public void searchAStudent() {
        if (arr.isEmpty()) {
            System.out.println("There is no student to search");
            return;
        }
        String id = MyToys.inputAnId();
        if (searchAStudent(id) == null) 
            System.out.println("NOT FOUND!!");
        else 
            searchAStudent(id).showProfile();
    }
    
    public String inputNonDuplicatedId() {
        while (true) {            
            String id = MyToys.inputAnId();
            if (searchAStudent(id) == null)  // nếu mà có for thì không phải là tư duy của re-use
                return id;
            System.out.println("Input id again, plz");
        }
    }
    
    public void updateAStudent() {
        if (arr.isEmpty()) { 
            System.out.println("There is no student to update");
            return;
        }
        String id = MyToys.inputAnId();
        Student st = searchAStudent(id);
        if (searchAStudent(id) == null) 
            System.out.println("NOT FOUND!!");
        else {
            System.out.println("Before updating");
            st.showProfile();
            st.setGpa(MyToys.inputADouble("Input gpa: ", "Input gpa again, plz!!"));
            System.out.println("After updating");
            st.showProfile();
            System.out.println("Update a student successfully");
        } 
    }
    
    public void removeAStudent() {
        if (arr.isEmpty()) {
            System.out.println("There is no student to remove");
            return;
        }
        String id = MyToys.inputAnId();
        if (searchAStudent(id) == null) 
            System.out.println("NOT FOUND!!");
        else {
            arr.remove(searchAStudent(id));
            System.out.println("Remove a student successfully");
        }
    }

    public static void printMenu() {
        System.out.println("\nWelcome to FAP - FPT Academic Portal");
        System.out.println("Choose the following functions to play with");
        System.out.println("1. Add a student profile");
        System.out.println("2. Print student list");
        System.out.println("3. Search a student by id");
        System.out.println("4. Update a student profile");
        System.out.println("5. Remove a student");
        System.out.println("6. Quit");
    }

    public static void doIt() {
        Cabinet tuSE = new Cabinet();
        int choice;
        do {
            printMenu();
            choice = MyToys.inputAnInteger("Input your choice (1...6): ", "Input your choice again, plz!!");
            switch (choice) {
                case 1:
                    tuSE.addAStudent();
                    break;
                case 2:
                    tuSE.printStudentList();
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
                    System.out.println("Bye bye, see you next time");
                    break;
                default:
                    System.out.println("Please choose 1 to 6, plz!!!");
            }
        } while (choice != 6);
    }

}
