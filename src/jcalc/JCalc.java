package jcalc;
//Imports
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  Daniel B.
 *  Version 0.01
 *  6/14/2012
 */

/*
 * So far this program can take a simple expression and tell if it is 
 * multiplication, addition, subtraction or division.
 */

public class JCalc {
//The "one and only" calculator in java!
    public static void main(String[] args) {
        System.out.println("Welcome to the JCalc, (The 'one and only' notice the quotes) lets get started!");
        //Should the while loop come before the try/catch?
        try{
            while (true){
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("\nInput an expression: ");
                //Just going to take this as a string and go from there.
                String readInput = userInput.readLine();
                int lengthOfString = readInput.length();
                //Rather hacky here and the last substring isn't even read.
                //Good thing expressions aren't evaluated that way!
                for (int counter = 0; counter < lengthOfString; counter++)
                {
                    //This has to be done to get a string of one length.
                    String char1 = readInput.substring(counter, counter+1);
                    //Just in case somebody tries to do 5x5 or 5X5 and wonders
                    //why it doesn't work.
                    if (char1.equals("X") || char1.equals("x"))
                    {
                        System.out.println("If you are trying to multiply use * instead.");
                    }
                    if (char1.equals("+") || char1.equals("-") || char1.equals("/") || char1.equals("*"))
                    {
                        //This is probably going to go into a class to be called.
                        //Currently this switch checks which method to use.
                        switch(char1){
                            case "+":
                                System.out.println("Addition is required.");
                                String readInput1 = readInput.replace("+", " ");
                                String hi = "hello";
                                // ??? 
                                readInput1 = hi.split("hi", 3);
                                
                                //char[] charArray = readInput1.toCharArray();
                                
   //Arrays.sort(charArray);
   System.out.println(readInput1);
   //String aString = new String(charArray);
  //return aString ;

                                
                                int first = Integer.parseInt(readInput1.substring(0, 1));
                                int second = Integer.parseInt(readInput1.substring(2, 3));
                                int result = first + second;
                                System.out.println("\nThe result is " + result + ".\n");
                                break;
                            case "-":
                                System.out.println("Subtraction is required.");
                                readInput1 = readInput.replace("-", " ");
                                first = Integer.parseInt(readInput1.substring(0, 1));
                                second = Integer.parseInt(readInput1.substring(2, 3));
                                result = first - second;
                                System.out.println("\nThe result is " + result + ".\n");
                                break;
                            case "/":
                                System.out.println("Division is required.");
                                readInput1 = readInput.replace("/", " ");
                                first = Integer.parseInt(readInput1.substring(0, 1));
                                second = Integer.parseInt(readInput1.substring(2, 3));
                                result = first / second;
                                System.out.println("\nThe result is " + result + ".\n");
                                break;
                            case "*":
                                System.out.println("Multiplication is required.");
                                readInput1 = readInput.replace("*", " ");
                                first = Integer.parseInt(readInput1.substring(0, 1));
                                second = Integer.parseInt(readInput1.substring(2, 3));
                                result = first * second;
                                System.out.println("\nThe result is " + result + ".\n");                                
                                break;
                            default: 
                                System.out.println("Unsupported or invalid method!");
                                break;
                        }
                    }           
                }
                BufferedReader checker = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Would you like to calculate again? ");
                String checked = checker.readLine(); 
                //TODO fix->bug = only successfully evaluates string of one letter
                //need to have it take the charAt(1) and check.
                //String yesOrNo = checked.substring(1, 2);
                checked = checked.toUpperCase();
                if (checked.equals("N"))
                {
                    System.out.println("Have a good day!");
                    break;
                }
            }
        }
        catch (Exception e) {
            System.out.println("Fatal error has occurred."+e);
            System.exit(0);
        }
    }
}