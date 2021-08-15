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

    Sherlock and Anagrams
    src:https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem

 */

class ResultSherlockAndAnagrams {

    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

/*
    public static int sherlockAndAnagrams(String str){
        int total = 0;
        for(int i=1; i<str.length(); ++i){
            int[] tmpstr = new int[26];

            for(int j=i; j>=0; --j){
                tmpstr[str.charAt(j)-'a']++;

                for(int k=0; k<j; ++k){
                    int[] chars = new int[26];
                    int x = k;
                    int count =0;
                    while(count<=i-j){
                        ++chars[str.charAt(x)-'a'];
                        ++x;
                        ++count;
                    }
                    boolean flag = true;
                    for(x=0; x<26; ++x){
                        if(tmpstr[x]!=chars[x]){
                            flag = false;
                            break;
                        }
                    }
                    if(flag) ++total;
                }

            }
        }
        return total;
    }
    */

    public static int sherlockAndAnagrams(String s) {
        // Write your code here

        HashMap<Integer, List<Integer>> d = new HashMap<>();
        List<Integer> list;
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; i + j <= s.length(); j++) {
                int l = (i + j) - i; //length of the anagram
                System.out.println("t:" + s.substring(i, i + j));
                int v = getAsciiValue(s.substring(i, i + j));
                if (!d.containsKey(l)) {
                    list = new ArrayList<>();
                    list.add(v);
                    d.put(l, list);
                } else {
                    list = d.get(l);
                    boolean c = false;
                    for (int o = 0; o < list.size() && !c; o++) {
                        System.out.println("t1:" + s.substring(i, i + j));
                        if (list.get(o) == v) {
                            sum++;
                            c = true;
                        }
                    }
                    System.out.println("sum:" + sum);
                    if (!c) {
                        list.add(v);
                        d.put(l, list);
                    }
                }
            }
        }

        return sum;
    }

    public static int getAsciiValue(String s) {
        int v = 0;
        for (int i = 0; i < s.length(); i++) {
            v += s.charAt(i);
        }
        return v;
    }

}

public class SherlockAndAnagrams {

    /*
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = ResultSherlockAndAnagrams.sherlockAndAnagrams(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
*/
    public static void main(String[] args) {
        int result = ResultSherlockAndAnagrams.sherlockAndAnagrams("cdcd");
        System.out.println(result);
    }
}
