package hackerrank.thirtydaysofcode;

import java.util.*;

/*

    Day 1: Data Types
    src:https://www.hackerrank.com/challenges/30-data-types/problem

 */

public class Day1_DataTypes {

    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";

        Scanner scan = new Scanner(System.in);

        /* Declare second integer, double, and String variables. */
        int myInteger;
        double myDouble;
        String myString;
        /* Read and save an integer, double, and String to your variables.*/
        // Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.
        myInteger = scan.nextInt();
        myDouble = scan.nextDouble();
        myString = scan.next() + scan.nextLine();
        /* Print the sum of both integer variables on a new line. */
        System.out.println(myInteger + i);

        /* Print the sum of the double variables on a new line. */
        System.out.println(myDouble + d);

        /* Concatenate and print the String variables on a new line;
        	the 's' variable above should be printed first. */
        System.out.println(s + myString);

        scan.close();
    }
}
