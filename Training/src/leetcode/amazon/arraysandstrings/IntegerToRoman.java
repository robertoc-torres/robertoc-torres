package leetcode.amazon.arraysandstrings;

/*
    src:https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2964/

    Integer to Roman

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
    Given an integer, convert it to a roman numeral.

 */

public class IntegerToRoman {

    public static void main(String[] args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        IntegerToRoman.Solution solution = integerToRoman.new Solution();
        String result = solution.intToRoman(71);
        System.out.println("Result:" + result);
    }

    class Solution {
        public String intToRoman(int num) {
            StringBuilder roman = new StringBuilder();
            int lastNumber = num % 10;
            int i = 0;

            String[][] symbols = new String[][]{{"I", "V", "X"}, {"X", "L", "C"}, {"C", "D", "M"}, {"M"}};

            while (num > 0) {
                if (lastNumber == 9) {
                    roman.insert(0, symbols[i][0] + symbols[i][2]);
                } else if (lastNumber == 8) {
                    roman.insert(0, symbols[i][1] + symbols[i][0] + symbols[i][0] + symbols[i][0]);
                } else if (lastNumber == 7) {
                    roman.insert(0, symbols[i][1] + symbols[i][0] + symbols[i][0]);
                } else if (lastNumber == 6) {
                    roman.insert(0, symbols[i][1] + symbols[i][0]);
                } else if (lastNumber == 5) {
                    roman.insert(0, symbols[i][1]);
                } else if (lastNumber == 4) {
                    roman.insert(0, symbols[i][0] + symbols[i][1]);
                } else if (lastNumber == 3) {
                    roman.insert(0, symbols[i][0] + symbols[i][0] + symbols[i][0]);
                } else if (lastNumber == 2) {
                    roman.insert(0, symbols[i][0] + symbols[i][0]);
                } else if (lastNumber == 1) {
                    roman.insert(0, symbols[i][0]);
                }
                i++;
                num = num / 10;
                lastNumber = num % 10;
            }
            return roman.toString();
        }
    }

/*
    class Solution {
        public String intToRoman(int num) {
            int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] symbols = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
            StringBuilder result = new StringBuilder();
            int i = 0;
            while(i < values.length && num > 0) {
                while(num >= values[i]) {
                    num -= values[i];
                    result.append(symbols[i]);
                }
                i++;
            }
            return result.toString();
        }
    }

 */
}


