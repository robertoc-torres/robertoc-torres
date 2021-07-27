package hackerrank.thirtydaysofcode;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/*

    Day 10: Binary Numbers
    src:https://www.hackerrank.com/challenges/30-binary-numbers/problem

 */

public class Day10_BinaryNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int cons = 0;
        int max = -1;

        while (n > 0) {
            if(n % 2 == 0)
                cons = 0;
            else {
                cons++;
                if(max == -1 || max < cons) {
                    max = cons;
                }
            }
            n = n / 2;
        }
        System.out.println(max);
        bufferedReader.close();
    }

}
