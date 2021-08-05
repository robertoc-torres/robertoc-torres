package hackerrank.InterviewPreparationKit.WarmUpChallenges;

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

    Repeated String
    src:https://www.hackerrank.com/challenges/repeated-string/problem

 */

class Result {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) {
        // Write your code here
        long cnt = 0;

        long limit;
        if(n < s.length())
            limit = n;
        else
            limit = s.length();

        // How many a's in s
        for(int i = 0; i < limit; i++) {
            if(s.charAt(i) == 'a'){
                cnt++;
            }
        }

        if(n <= s.length()) {
            return cnt;
        }

        if(n % s.length() == 0) {
            return cnt * (n / s.length());
        }

        cnt = cnt * (n / s.length());

        double d = n / s.length();

        int c = (int)(n - s.length() * Math.round(d));

        for(int i = 0; i < c; i++) {
            if(s.charAt(i) == 'a'){
                cnt++;
            }
        }
        return cnt;
    }

}

public class RepeatedString {
    public static void main(String[] args) throws IOException {
        long result = Result.repeatedString("ababa", 3);
        System.out.println(result);
    }
}

/*
public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
 */
