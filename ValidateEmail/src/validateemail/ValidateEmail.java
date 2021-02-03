/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validateemail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Rajat
 */
public class ValidateEmail {

    private static String[] emails = new String[10];
    private static ArrayList<String> valid = new ArrayList<>();
    private static ArrayList<String> invalid = new ArrayList<>();
    private static boolean stillRunning = true;
    private static int i = 0;
    private static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        // TODO code application logic here
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
        String[][] valArray = validate(emails);
        printEmails(valArray);
        search();
    }
    
    public static String[][] validate(String[] emailList){
        String[][] arrayVal = new String[2][10];
        int j = 0, h = 0;
        //Enter regex validation code here 0 - validated 1 - invalid
        Pattern pattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}");
        for(String i : emailList){
            if(i == null){
                break;
            }else{
                Matcher matcher = pattern.matcher(i);
                if(matcher.find()){
                    arrayVal[0][j] = i;
                    j++;
                }else{
                    arrayVal[1][h] = i;
                    h++;
                }
            }
        }
        return arrayVal;
    }
    
    public static void printEmails(String[][] array){
        int x = 0, y = 0;
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 10; j++){
                if(i == 0){
                    if(array[0][j] != null){
                        valid.add(array[0][j]);
                        x++;
                    }  
                }else{
                    if(array[1][j] != null){
                       invalid.add(array[1][j]);
                        y++;
                    }
                }
            }
        }
        System.out.println("Valid Emails: " + valid.toString());
        System.out.println("Invalid Emails: " + invalid.toString());   
    }  
    
    public static void search(){
        System.out.print("\nEnter E-mail address to search: ");
        String userIn = in.nextLine();
        if(valid.contains(userIn)){
            System.out.println("\nMatch Found! E-mail is valid");
        }else if(invalid.contains(userIn)){
            System.out.println("\nMatch Found but E-mail is invalid");
        }else{
            System.out.println("E-mail not found");
        }
    }
}
