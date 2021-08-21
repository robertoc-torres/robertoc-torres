package hackerrank.InterviewPreparationKit.Sorting;

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

    Fraudulent Activity Notifications
    src:https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem

 */

class ResultFraudulentActivityNotifications {

    /*
     * Complete the 'activityNotifications' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY expenditure
     *  2. INTEGER d
     */

    /*
        1. Traver all expenditures - For
        2. Find median of trailing days (d) - ?
        3. Check if current item from expenditure list is >= than 2xmedian - If
        4. Decide if notification will be sent - If

     */
    public static int activityNotifications(List<Integer> expenditure, int d) {

        int[] trailing = new int[201];
        for (int i = 0; i < d; i++) {
            trailing[expenditure.get(i)]++;
        }

        int c = 0;
        for (int i = d; i < expenditure.size(); i++) {
            if (expenditure.get(i) >= getMedian(trailing, d) * 2) {
                c++;
            }
            trailing[expenditure.get(i)]++;
            trailing[expenditure.get(i - d)]--;
        }

        return c;
    }

    public static double getMedian(int[] trailing, int d) {
        int c = 0;
        double m = 0;
        int l = -1;
        int r = -1;
        if (d % 2 == 0) {
            for (int i = 0; i < trailing.length; i++) {
                c += trailing[i];
                if (c >= d / 2 && l == -1) {
                    l = i;
                }
                if (c >= d / 2 + 1) {
                    r = i;
                    break;
                }
            }
            m = (l + r) / 2.0;
        } else {
            for (int i = 0; i < trailing.length; i++) {
                c += trailing[i];
                if (c > d / 2) {
                    m = i;
                    break;
                }
            }
        }
        return m;
    }

}

public class FraudulentActivityNotifications {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> expenditure = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = ResultFraudulentActivityNotifications.activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}