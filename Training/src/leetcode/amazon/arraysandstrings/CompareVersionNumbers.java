package leetcode.amazon.arraysandstrings;

/*

    src: https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/502/

    Compare Version Numbers

    Given two version numbers, version1 and version2, compare them.

    Version numbers consist of one or more revisions joined by a dot '.'. Each revision consists of digits and may contain leading zeros. Every revision contains at least one character. Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, the next revision being revision 1, and so on. For example 2.5.33 and 0.1 are valid version numbers.

    To compare version numbers, compare their revisions in left-to-right order. Revisions are compared using their integer value ignoring any leading zeros. This means that revisions 1 and 001 are considered equal. If a version number does not specify a revision at an index, then treat the revision as 0. For example, version 1.0 is less than version 1.1 because their revision 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.

    Return the following:

    If version1 < version2, return -1.
    If version1 > version2, return 1.
    Otherwise, return 0.

 */

public class CompareVersionNumbers {

    public static void main(String[] args) {
        CompareVersionNumbers compareVersion = new CompareVersionNumbers();
        CompareVersionNumbers.Solution solution = compareVersion.new Solution();
        int result = solution.compareVersion("1.01", "1.001");
        System.out.println("Expected 0, Result:" + result);
        result = solution.compareVersion("0.1", "1.1");
        System.out.println("Expected -1, Result:" + result);
        result = solution.compareVersion("7.5.2.4", "7.5.3");
        System.out.println("Expected -1, Result:" + result);
        result = solution.compareVersion("1.0", "1.0.0");
        System.out.println("Expected 0, Result:" + result);
    }

    class Solution {
        public int compareVersion(String version1, String version2) {

            String[] v1 = version1.split("\\.");
            String[] v2 = version2.split("\\.");

            String[] t = new String[Math.max(v1.length, v2.length)];
            if (v1.length > v2.length) {
                for (int i = 0; i < v1.length; i++) {
                    if (i >= v2.length)
                        t[i] = "0";
                    else
                        t[i] = v2[i];
                }
                v2 = t;
            }

            if (v1.length < v2.length) {
                for (int i = 0; i < v2.length; i++) {
                    if (i >= v1.length)
                        t[i] = "0";
                    else
                        t[i] = v1[i];
                }
                v1 = t;
            }

            for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
                if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[i]))
                    return -1;
                else if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i]))
                    return 1;
            }

            return 0;

        }
    }
}
/*
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int n1 = nums1.length, n2 = nums2.length;

        // compare versions
        int i1, i2;
        for (int i = 0; i < Math.max(n1, n2); ++i) {
            i1 = i < n1 ? Integer.parseInt(nums1[i]) : 0;
            i2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;
            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }
        // the versions are equal
        return 0;
    }
}
 */
