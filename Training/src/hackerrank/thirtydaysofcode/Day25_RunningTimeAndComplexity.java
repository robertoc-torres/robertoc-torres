package hackerrank.thirtydaysofcode;

import java.io.*;
import java.util.*;

/*

    Day 25: Running Time and Complexity
    https://www.hackerrank.com/challenges/30-running-time-and-complexity/problem

 */

public class Day25_RunningTimeAndComplexity {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n > 0) {
            n--;
            isPrime(sc.nextInt());
        }
    }

    public static void isPrime(int n) {
        if(n == 1) {
            System.out.println("Not prime");
            return;
        }
        for(int i = 2; i <= n/2; i++) {
            if(n % i == 0) {
                System.out.println("Not prime");
                return;
            }
        }
        System.out.println("Prime");
    }
}