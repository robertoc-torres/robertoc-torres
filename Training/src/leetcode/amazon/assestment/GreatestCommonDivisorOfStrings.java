package leetcode.amazon.assestment;

/*
    src:https://leetcode.com/problems/greatest-common-divisor-of-strings/
    Greatest Common Divisor of Strings

    For two strings s and t, we say "t divides s" if and only if s = t + ... + t  (t concatenated with itself 1 or more times)

    Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

 */

public class GreatestCommonDivisorOfStrings {

    public static void main(String[] args) {
        GreatestCommonDivisorOfStrings greatestCommonDivisorOfStrings = new GreatestCommonDivisorOfStrings();
        GreatestCommonDivisorOfStrings.Solution solution = greatestCommonDivisorOfStrings.new Solution();
        String result = solution.gcdOfStrings("ABCABC", "ABC");
        System.out.println("Expected ABC, Result:" + result);
        result = solution.gcdOfStrings("ABABAB", "ABAB");
        System.out.println("Expected AB, Result:" + result);
        result = solution.gcdOfStrings("LEET", "CODE");
        System.out.println("Expected '', Result:" + result);
        result = solution.gcdOfStrings("ABCDEF", "ABC");
        System.out.println("Expected '', Result:" + result);
        result = solution.gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX");
        System.out.println("Expected 'TAUXX', Result:" + result);
        result = solution.gcdOfStrings("AABB", "AB");
        System.out.println("Expected '', Result:" + result);
        result = solution.gcdOfStrings("UETKZUETKZUETKZUETKZUETKZUETKZUETKZUETKZUETKZUETKZUETKZ", "UETKZUETKZUETKZUETKZUETKZUETKZUETKZUETKZUETKZUETKZUETKZUETKZUETKZ");
        System.out.println("Expected UETKZ, Result:" + result);
    }

    class Solution {
        public String gcdOfStrings(String str1, String str2) {

            int l1 = str1.length();
            int l2 = str2.length();

            String mn;

            if (l1 > l2) {
                mn = str2;
            } else {
                mn = str1;
            }

            String gcd = mn;
            int l = gcd.length() - 1;

            while (gcd.length() > 0) {

                String s1 = str1;
                String s2 = str2;

                while (s1.length() > 0) {
                    if (s1.startsWith(gcd)) {
                        s1 = s1.replaceFirst(gcd, "");
                    } else {
                        break;
                    }
                }
                while (s2.length() > 0) {
                    if (s2.startsWith(gcd)) {
                        s2 = s2.replaceFirst(gcd, "");
                    } else {
                        break;
                    }
                }

                if (s1.length() == 0 && s2.length() == 0) {
                    return gcd;
                } else {
                    l--;
                    while(l > 0 && mn.length() % l != 0) {
                        l--;
                    }
                    if (l > 0) {
                        gcd = gcd.substring(0, l);
                    } else {
                        return "";
                    }
                }

            }
            return "";

        }
    }

}
