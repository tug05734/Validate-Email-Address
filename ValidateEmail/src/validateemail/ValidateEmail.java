/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validateemail;

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
        String[][] valArray = validate(emails);
        System.out.println(Arrays.deepToString(valArray));
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
    
    
}
