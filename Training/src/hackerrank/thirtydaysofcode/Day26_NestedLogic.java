package hackerrank.thirtydaysofcode;

import java.io.*;
import java.util.*;
/*

    Day 26: Nested Logic
    src:https://www.hackerrank.com/challenges/30-nested-logic/problem

 */

public class Day26_NestedLogic {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);

        int rDay = in.nextInt();
        int rMonth = in.nextInt();
        int rYear = in.nextInt();

        int dDay = in.nextInt();
        int dMonth = in.nextInt();
        int dYear = in.nextInt();

        in.close();

        int sameMonthFee = 15;
        int sameYearFee = 500;
        int diffYearFee = 10000;

        if (rYear > dYear) {
            System.out.println(diffYearFee);
        } else if (rYear == dYear) {
            if (rMonth > dMonth) {
                System.out.println((rMonth - dMonth) * sameYearFee);
            } else if (rMonth == dMonth){
                if (rDay > dDay) {
                    System.out.println((rDay - dDay) * sameMonthFee);
                }
            } else {
                System.out.println(0);
            }
        } else {
            System.out.println(0);
        }
    }

}