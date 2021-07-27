package hackerrank.thirtydaysofcode;

import java.io.*;
import java.util.*;

/*

    Day 6: Let's Review
    src:https://www.hackerrank.com/challenges/30-review-loop/problem

 */

public class Day6_LetsReview {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int tests = Integer.parseInt(bufferedReader.readLine());

        for (int j = 0; j < tests; j++) {
            String str = bufferedReader.readLine();
            String s1 = "";
            String s2 = "";

            for (int i = 0; i < str.length(); i++) {
                if (i % 2 == 0)
                    s1 += str.charAt(i);
                else
                    s2 += str.charAt(i);
            }

            System.out.println(s1 + " " + s2);
        }

    }

}
