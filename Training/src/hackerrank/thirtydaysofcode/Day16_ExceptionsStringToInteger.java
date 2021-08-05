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

    Day 16: Exceptions - String to Integer
    src:https://www.hackerrank.com/challenges/30-exceptions-string-to-integer/problem

 */

public class Day16_ExceptionsStringToInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String S = bufferedReader.readLine();
        try {
            System.out.println(Integer.parseInt(S));
        } catch (NumberFormatException ex) {
            System.out.println("Bad String");
        }
        bufferedReader.close();
    }
}

