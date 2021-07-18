package amazon.arraysandstrings;

/*

    src:https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2961/

    Longest Substring Without Repeating Characters

    Given a string s, find the length of the longest substring without repeating characters.

    Example 1:

    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.

 */

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        LongestSubstringWithoutRepeatingCharacters.Solution solution = longestSubstringWithoutRepeatingCharacters.new Solution();
        int result = solution.lengthOfLongestSubstring("abcabcbb");
        System.out.println("Result:" + result);
    }

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int longestSubstringLength = 0;
            if (s.length() == 1)
                return 1;
            String longestSubstring = "";
            for (int i = 0; i < s.length(); i++) {
                int auxLength = 1;
                longestSubstring = "" + s.charAt(i);
                for (int o = i + 1; o < s.length(); o++) {
                    if (longestSubstring.indexOf(s.charAt(o)) == -1) {
                        auxLength++;
                        longestSubstring += s.charAt(o);
                    } else {
                        break;
                    }
                }
                if (longestSubstringLength < auxLength) {
                    longestSubstringLength = auxLength;
                }
            }
            return longestSubstringLength;
        }

    }
}
