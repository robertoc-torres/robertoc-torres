package amazon.arraysandstrings;

/*
    src:https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2965/

    Roman to Integer

    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

    For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.
    Given a roman numeral, convert it to an integer.

 */

public class RomanToInteger {

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        RomanToInteger.Solution solution = romanToInteger.new Solution();
        int result = solution.romanToInt("LVIII");
        System.out.println("Result:" + result);
    }

    class Solution {
        public int romanToInt(String s) {
            char[] syms = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};
            int[] val = new int[]{1000, 500, 100, 50, 10, 5, 1};
            int tmpI = 0;
            int num = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                for(int j = 0; j < syms.length; j++) {
                    if(c == syms[j]) {
                        if(j >= tmpI) {
                            tmpI = j;
                            num += val[j];
                        } else {
                            num += val[j] - val[tmpI] - val[tmpI];
                        }
                    }
                }
            }
            return num;
        }
    }

}
