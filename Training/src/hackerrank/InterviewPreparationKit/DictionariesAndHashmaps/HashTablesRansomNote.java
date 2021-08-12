package hackerrank.InterviewPreparationKit.DictionariesAndHashmaps;

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

    Hash Tables: Ransom Note
    src:https://www.hackerrank.com/challenges/ctci-ransom-note/problem

 */

class ResultHTRN {

    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static void checkMagazine(List<String> magazine, List<String> note) {
        // Write your code here
        /*

            1. Create HT with words in the magazine and occurrence
            2. For each word in the note check if its on the HT and decrease the occurrence
            3. Print No if the word is not present or occurrence is 0 and return

         */

        HashMap<String, Integer> d = new HashMap<>();
        for (String s : magazine) {
            if (!d.containsKey(s)) {
                d.put(s, 1);
            } else {
                d.put(s, d.get(s) + 1);
            }
        }

        for(String s : note) {
            if(d.containsKey(s) && d.get(s) > 0) {
                d.put(s, d.get(s) - 1);
            } else {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

}

public class HashTablesRansomNote {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        ResultHTRN.checkMagazine(magazine, note);

        bufferedReader.close();
    }
}
