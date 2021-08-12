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

    Day 20: Sorting
    src:https://www.hackerrank.com/challenges/30-sorting/problem

 */

public class Day20_Sorting {

    static void bubbleSort(List<Integer> l) {

        int swaps = 0;
        for (int i = 1; i < l.size(); i++) {
            for (int j = 0; j < l.size() - i; j++) {
                if (l.get(j) > l.get(j + 1)) {
                    swaps++;
                    int tmp = l.get(j + 1);
                    l.set(j + 1, l.get(j));
                    l.set(j, tmp);
                }
            }
        }

        System.out.println("Array is sorted in " + swaps + " swaps.");
        System.out.println("First Element: " + l.get(0));
        System.out.println("Last Element: " + l.get(l.size() - 1));

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        // Write your code here
        bubbleSort(a);

        bufferedReader.close();
    }
}

