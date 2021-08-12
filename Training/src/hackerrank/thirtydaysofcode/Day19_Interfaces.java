package hackerrank.thirtydaysofcode;

import java.io.*;
import java.util.*;

/*

    Day 19: Interfaces
    src:https://www.hackerrank.com/challenges/30-interfaces/problem

 */

public class Day19_Interfaces {
}

interface AdvancedArithmetic{
    int divisorSum(int n);
}

class Calculator19 implements AdvancedArithmetic {
    public int divisorSum(int n) {
        int sum = 1;
        for(int i = 2; i <= n; i++)
            if(n % i == 0)
                sum += i;
        return sum;
    }
}

class Solution19 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();

        AdvancedArithmetic myCalculator = new Calculator19();
        int sum = myCalculator.divisorSum(n);
        System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName() );
        System.out.println(sum);
    }
}