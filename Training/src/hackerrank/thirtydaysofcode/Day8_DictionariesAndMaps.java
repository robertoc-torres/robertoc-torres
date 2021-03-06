package hackerrank.thirtydaysofcode;

import java.util.*;
import java.io.*;

/*

    Day 8: Dictionaries and Maps
    src:https://www.hackerrank.com/challenges/30-dictionaries-and-maps/problem

 */

public class Day8_DictionariesAndMaps {

    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        HashMap<String, Integer> phoneDir = new HashMap<>();

        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            phoneDir.put(name, phone);
        }
        while(in.hasNext()){
            String s = in.next();
            if(phoneDir.containsKey(s)) {
                System.out.println(s + "=" + phoneDir.get(s));
            } else {
                System.out.println("Not found");
            }
        }
        in.close();
    }

}
