package amazon.arraysandstrings;

/*
    src:https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2962/

    String to Integer (atoi)

    Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer
    (similar to C/C++'s atoi function).

    The algorithm for myAtoi(string s) is as follows:

    Read in and ignore any leading whitespace.
    Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it
    is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
    Read in next the characters until the next non-digit charcter or the end of the input is reached. The rest of the
    string is ignored.
    Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0.
    Change the sign as necessary (from step 2).
    If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range.
    Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
    Return the integer as the final result.
    Note:

    Only the space character ' ' is considered a whitespace character.
    Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.

 */

public class StringToIntegerAtoi {

    public static void main(String[] args) {
        StringToIntegerAtoi stringToInteger = new StringToIntegerAtoi();
        StringToIntegerAtoi.Solution solution = stringToInteger.new Solution();
        int result;
        result = solution.myAtoi("4193");
        System.out.println(result);
        result = solution.myAtoi("-91283472332");
        System.out.println(result);
        result = solution.myAtoi("words and 987");
        System.out.println(result);
        result = solution.myAtoi("4193 with words");
        System.out.println(result);
    }

    class Solution {
        public int myAtoi(String s) {
            int sign = 1;
            int tmpNumber = 0;
            int number = 0;
            boolean foundSign = false;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ' ' && !foundSign) {
                    continue;
                }
                if (c == '-' && !foundSign) {
                    sign = -1;
                    foundSign = true;
                    continue;
                }
                if (c == '+' && !foundSign) {
                    sign = 1;
                    foundSign = true;
                    continue;
                }
                if (c >= '0' && c <= '9') {
                    tmpNumber = number * 10 + (c - 48);
                    if (tmpNumber / 10 != number) {
                        return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                    }
                    number = number * 10 + (c - 48);
                    foundSign = true;
                } else {
                    break;
                }
            }
            return sign * number;
        }
    }

}
