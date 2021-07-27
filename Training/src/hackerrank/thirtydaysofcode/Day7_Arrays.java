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

    Day 7: Arrays
    src:https://www.hackerrank.com/challenges/30-arrays/problem?h_r=next-challenge&h_v=zen

 */

public class Day7_Arrays {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String out = "";

        for(int i = arr.size() - 1; i >= 0; i--) {
            out += arr.get(i) + " ";
        }

        System.out.println(out);

        bufferedReader.close();
    }

}
