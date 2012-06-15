/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jcalc;
import java.io.*;
/**
 *
 * @author Daniel
 */
class JCalc1 {

    /**
     * @param args the command line arguments
     */
    public static void crap(String[] args) {
        System.out.println("This will be the calculator program.");
        System.out.println("This will calculate if two numbers are equal / lesser / greater!");
        try{
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a number please: ");
        String userString = userInput.readLine();
        if (userString == "")
            System.out.println("you pressed enter");
        else
            userString = userInput.readLine();
            System.out.println("You enterd something different i hope "+ userString);
        int num = Integer.parseInt(userInput.readLine());
        System.out.println("You entered the number " + num + ".");
        // lets print even numbers
        for (int i = 1; i <= num ; i++){
            if (i%2 == 1){
            System.out.print(i+",");
            }
        }
        System.exit(0);
        }
        catch(IOException ioe) {
        System.out.println("You broke it!");
        System.exit(1);
        }
                
        /*int a = 20, b = 32;
        if (a > b)
            System.out.println("a is greater then b");
        else if (a == b)
            System.out.println("they are the same value");
        else
            System.out.println("a is less then b");*/
    }
}
