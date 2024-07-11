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
        id = inputNonDuplicatedId();  // có hàm tránh lặp đây rồi
        System.out.print("Input name: ");
        name = sc.nextLine().trim().toUpperCase();
        yob = MyToys.inputAnInteger("Input yob: ", "Input yob again, plz!!");
        gpa = MyToys.inputADouble("Input gpa: ", "Input gpa again, plz!!", 0, 10);
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
        Menu updateMenu = new Menu("updating a student");
        updateMenu.addNewOption("1. Update name");
        updateMenu.addNewOption("2. Update yob");
        updateMenu.addNewOption("3. Update gpa");
        updateMenu.addNewOption("4. Quit");
        if (arr.isEmpty()) { 
            System.out.println("There is no student to update");
            return;
        }
        String id = MyToys.inputAnId();
        Student st = searchAStudent(id);
        if (st == null) 
            System.out.println("NOT FOUND!!");
        else {
            System.out.println("Before updating");
            st.showProfile();
            int choice;
            updateMenu.printMenu();
            choice = updateMenu.getChoice();
            System.out.println("----------------------------------------------");
            switch (choice) {
                case 1:
                    st.setName(MyToys.inputString("Input name: ", "Input name again, plz!!"));
                    break;
                case 2:
                    st.setYob(MyToys.inputAnInteger("Input yob: ", "Input yob again, plz!!"));
                    break;
                case 3:
                    st.setGpa(MyToys.inputADouble("Input gpa: ", "Input gpa again, plz!!", 0, 10));
                    break;
                case 4:
                    System.out.println("Update a student unsuccessfully");
                    return;
            }
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
    
    public void printStudentListAscendingByID() {
        if (arr.isEmpty()) {
            System.out.println("This list is empty. Nothing to print!");
            return;
        }
        Collections.sort(arr);
        System.out.println("Here is the student list");
        System.out.printf("|%-8s|%-25s|%4s|%5s|\n", "ID", "Name", "Yob", "Gpa");
        for (Student x : arr) 
            x.showProfile();
    }
    
    public void printStudentListAscendingByName() {
        if (arr.isEmpty()) {
            System.out.println("This list is empty. Nothing to print!");
            return;
        }
        Comparator<Student> nameBalance = new Comparator<Student>() {
            @Override
            public int compare(Student st1, Student st2) {
                return st1.getName().compareToIgnoreCase(st2.getName());
            }
        };
        Collections.sort(arr, nameBalance);
        System.out.println("Here is the student list");
        System.out.printf("|%-8s|%-25s|%4s|%5s|\n", "ID", "Name", "Yob", "Gpa");
        for (Student x : arr) 
            x.showProfile();
    }

}
