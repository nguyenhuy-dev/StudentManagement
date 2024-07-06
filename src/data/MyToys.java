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
    public static Scanner sc = new Scanner(System.in);
    
    public static String inputAnId() {  // này là chơi lẻ, khôm liên quan tới tệp thông tin
        String format = "^(SE|SS)\\d{6}$";
        String input;
        while (true) {            
                System.out.print("Input id: ");
                input = sc.nextLine().trim().toUpperCase();
                if (input.matches(format)) 
                    return input;
                System.out.println("Input id again, plz!!");
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
    
    public static double inputADouble(String msg1, String msg2) {
        double n;
        while (true) {            
            try {
                System.out.print(msg1);
                n = Double.parseDouble(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(msg2);
            }
        }
    }
    
}
