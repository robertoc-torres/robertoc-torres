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

    Day 28: RegEx, Patterns, and Intro to Databases
    src:https://www.hackerrank.com/challenges/30-regex-patterns/problem

 */

public class Day28_RegExPatternsAndIntroToDatabases {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> names = new LinkedList<>();

        Pattern p = Pattern.compile(".*@gmail.com");

        IntStream.range(0, N).forEach(NItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                String firstName = firstMultipleInput[0];

                String emailID = firstMultipleInput[1];
                Matcher m = p.matcher(emailID);
                if (m.find()) {
                    names.add(firstName);
                }


            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Collections.sort(names);
        names.forEach(s -> {
            System.out.println(s);
        });

        bufferedReader.close();
    }
}