package amazon.arraysandstrings;

/*
    src:https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2968/

    Implement strStr()

    Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

    Clarification:

    What should we return when needle is an empty string? This is a great question to ask during an interview.

    For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

 */
public class ImplementStrStr {

    public static void main(String[] args) {
        ImplementStrStr implementStrStr = new ImplementStrStr();
        ImplementStrStr.Solution solution = implementStrStr.new Solution();
        int result = solution.strStr("mississippi", "si");
        System.out.println("Result:" + result);
    }

    class Solution {
        public int strStr(String haystack, String needle) {

            int index = -1;
            if (needle.length() == 0)
                return 0;

            int matchCount = 0;

            for (int i = 0; i < haystack.length(); i++) {

                char c = haystack.charAt(i);
                if (c == needle.charAt(matchCount)) {
                    if (++matchCount == needle.length()) {
                        return i - matchCount + 1;
                    }
                } else if (matchCount > 0) {
                    i = i - matchCount;
                    matchCount = 0;
                }

            }

            return index;

        }
    }

}
