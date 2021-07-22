package hackerrank.thirtydaysofcode;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*

    Day 2: Operators
    src:https://www.hackerrank.com/challenges/30-operators/problem

 */

class Result {

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

