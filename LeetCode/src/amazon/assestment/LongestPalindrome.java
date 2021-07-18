package amazon.assestment;

/*
    src: https://leetcode.com/problems/longest-palindromic-substring/

    Longest Palindromic Substring

    Given a string s, return the longest palindromic substring in s.

    Example 1:

    Input: s = "babad"
    Output: "bab"
    Note: "aba" is also a valid answer.
    Example 2:

    Input: s = "cbbd"
    Output: "bb"
    Example 3:

    Input: s = "a"
    Output: "a"
    Example 4:

    Input: s = "ac"
    Output: "a"

 */

public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        LongestPalindrome.Solution solution = longestPalindrome.new Solution();
        String result = solution.longestPalindrome("babad");
        System.out.println("Expected 'bab', Result:" + result);
        result = solution.longestPalindrome("cbbd");
        System.out.println("Expected 'bb', Result:" + result);
        result = solution.longestPalindrome("ac");
        System.out.println("Expected 'a', Result:" + result);
        result = solution.longestPalindrome("aacabdkacaa");
        System.out.println("Expected 'aca', Result:" + result);
    }

    class Solution {
        public String longestPalindrome(String s) {
            int l = 0;
            String p = "" + s.charAt(0);
            for (int i = 0; i < s.length() && s.length() - i > l; i++) {
                char c = s.charAt(i);
                for (int j = s.length() - 1; j > i && j - i > l; j--) {
                    if (s.charAt(j) == c) {
                        boolean f = true;
                        int le = i;
                        int ri = j;
                        while(le < ri) {
                            if (s.charAt(le) != s.charAt(ri)) {
                                f = false;
                                break;
                            }
                            le++;
                            ri--;
                        }
                        if (f && j - i > l) {
                            l = j - i;
                            p = s.substring(i, j + 1);
                        }
                    }

                }

            }
            return p;
        }

    }
}

