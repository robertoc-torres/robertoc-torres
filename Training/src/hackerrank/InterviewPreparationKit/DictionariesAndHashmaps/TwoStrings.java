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

    Two Strings
    src:https://www.hackerrank.com/challenges/two-strings/problem

 */

class ResultTwoStrings {

    /*
     * Complete the 'twoStrings' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static String twoStrings(String s1, String s2) {
        // Write your code here
        int[] d = new int[123-65];
        for(int i = 0; i < s1.length(); i++) {
            d[s1.charAt(i) - 65] = 1;
        }
        for(int i = 0; i < s2.length(); i++) {
            if(d[s2.charAt(i) - 65] == 1) {
                return "YES";
            }
        }
        return "NO";
    }

}

public class TwoStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s1 = bufferedReader.readLine();

                String s2 = bufferedReader.readLine();

                String result = ResultTwoStrings.twoStrings(s1, s2);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
