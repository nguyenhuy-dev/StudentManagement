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
public class MyToys {
    private static Scanner sc = new Scanner(System.in);
    
    public static String inputString(String msg1, String msg2) {  // viết hàm nhập tên (String)
        String input;
        while (true) {            
            System.out.print(msg1);
            input = sc.nextLine().trim();
            if (!input.equals("")) 
                return input;
            System.out.println(msg2);
        }
    }
    
    public static String inputAnId() {  // này là chơi lẻ, khôm liên quan tới tệp thông tin
        String format = "^(SE|SS)\\d{6}$";
        String input;
        while (true) {            
                System.out.print("Input id: ");
                input = sc.nextLine().trim().toUpperCase();
                if (input.matches(format)) 
                    return input;
                System.out.println("Input id form [SE123456], plz!!");
        }
    }
    
    public static double inputADouble(String msg1, String msg2, double lowerBound, double upperBound) {  // bắt nhập trong khoảng
        double input;
        while (true) {            
            try {
                System.out.print(msg1);
                input = Double.parseDouble(sc.nextLine());
                if (input < lowerBound || input > upperBound) 
                    throw new Exception();
                return input;
            } catch (Exception e) {
                System.out.println(msg2);
            }
        }
    }
    
    public static int inputAnInteger(String msg1, String msg2, int lowerBound, int upperBound) {
        int input;
        while (true) {            
            try {
                System.out.print(msg1);
                input = Integer.parseInt(sc.nextLine());
                if (input < lowerBound || input > upperBound) 
                    throw new Exception();
                return input;
            } catch (Exception e) {
                System.out.println(msg2);
            }
        }
    }
    
    public static int inputAnInteger(String msg1, String msg2) {
        int n;
        while (true) {            
            try {
                System.out.print(msg1);
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(msg2);
            }
        }
    }
    
    public static double inputADouble(String msg1, String msg2) {  // bắt nhập trong khoảng
        double input;
        while (true) {            
            try {
                System.out.print(msg1);
                input = Double.parseDouble(sc.nextLine());
                return input;
            } catch (Exception e) {
                System.out.println(msg2);
            }
        }
    }
    
}
