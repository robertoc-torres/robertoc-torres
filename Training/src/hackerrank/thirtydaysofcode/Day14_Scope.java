package hackerrank.thirtydaysofcode;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*

    Day 14: Scope
    src:https://www.hackerrank.com/challenges/30-scope/problem

 */

public class Day14_Scope {
    private int[] elements;
    public int maximumDifference;

    // Add your code here
    Day14_Scope(int[] elements) {
        this.elements = elements;
    }

    public void computeDifference() {
        Arrays.sort(elements);
        maximumDifference = elements[elements.length - 1] - elements[0];
    }

}
