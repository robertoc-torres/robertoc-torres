package hackerrank.thirtydaysofcode;

/*

    src:https://www.hackerrank.com/challenges/30-operators/problem

    Day 2: Operators

    Objective
    In this challenge, you will work with arithmetic operators. Check out the Tutorial tab for learning materials and an instructional video.

    Task
    Given the meal price (base cost of a meal), tip percent (the percentage of the meal price being added as tip), and tax percent (the percentage of the meal price being added as tax) for a meal, find and print the meal's total cost. Round the result to the nearest integer.

    Example
    A tip of 15% * 100 = 15, and the taxes are 8% * 100 = 8. Print the value  and return from the function.

 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'solve' function below.
     *
     * The function accepts following parameters:
     *  1. DOUBLE meal_cost
     *  2. INTEGER tip_percent
     *  3. INTEGER tax_percent
     */

    public static void solve(double meal_cost, int tip_percent, int tax_percent) {
        // Write your code here

        double tip = meal_cost * tip_percent / 100;
        double tax = meal_cost * tax_percent / 100;

        double r = meal_cost + tip + tax;

        long result = Math.round(r);
        System.out.println(result);

    }

}

public class Day2_Operators {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        double meal_cost = Double.parseDouble(bufferedReader.readLine().trim());

        int tip_percent = Integer.parseInt(bufferedReader.readLine().trim());

        int tax_percent = Integer.parseInt(bufferedReader.readLine().trim());

        Result.solve(meal_cost, tip_percent, tax_percent);

        bufferedReader.close();
    }
}

