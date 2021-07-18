package leetcode.amazon.arraysandstrings;

/*

    src:https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/902/

    Minimum Window Substring

    Given two strings s and t of lengths m and n respectively, return the minimum window in s which will contain all the
    characters in t. If there is no such window in s that covers all characters in t, return the empty string "".

    Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.

 */

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        MinimumWindowSubstring.Solution solution = minimumWindowSubstring.new Solution();
        String result = solution.minWindow("ADOBECODEBANC", "ABC");
        System.out.println("Result:" + result);
        result = solution.minWindow("a", "aa");
        System.out.println("Result:" + result);
        result = solution.minWindow("a", "b");
        System.out.println("Result:" + result);
        result = solution.minWindow("ab", "a");
        System.out.println("Result:" + result);
        result = solution.minWindow("aa", "aa");
        System.out.println("Result:" + result);
    }

    class Solution {
        public String minWindow(String s, String t) {

            int l = 0;
            int r = 0;
            int m = -1;
            int[] chars = new int[58];
            int c = t.length();
            for (int i = 0; i < t.length(); i++) {
                chars[t.charAt(i) - 65]++;
            }
            String w = "";

            while (r < s.length()) {
                if (chars[s.charAt(r) - 65] > 0) {
                    c--;
                }
                chars[s.charAt(r) - 65]--;
                r++;
                while (c == 0) {
                    if (m < 0 || r - l < m) {
                        m = r - l;
                        w = s.substring(l, r);
                    }
                    if (chars[s.charAt(l) - 65] == 0) {
                        c++;
                    }
                    chars[s.charAt(l) - 65]++;
                    l++;
                }
            }
            return w;
        }
    }

}
