/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validateemail;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Rajat
 */
public class ValidateEmail {

    private static String[] emails = new String[10];
    private static boolean stillRunning = true;
    private static int i = 0;
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        System.out.println("Enter e-mail addresses, max limit 10. Enter 'x' to quit. ");
        while(stillRunning){
            String userInput = in.nextLine();
            if(userInput.equalsIgnoreCase("x")){
                stillRunning = false;
            }else{
                if(i < 10){
                    emails[i] = userInput;
                    i++;
                }else{
                    System.out.println("Max limit reached");
                    stillRunning = false;
                }
            }
        }
        System.out.println(Arrays.toString(emails));
    }
    
    public static String[][] validate(String[] emailList){
        String[][] arrayVal = new String[2][10];
        //Enter regex validation code here 0 - validated 1 - invalid
        return arrayVal;
    }
    
    
}
