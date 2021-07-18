package leetcode.amazon.assestment;

/*

    src:https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/

    You have d dice and each die has f faces numbered 1, 2, ..., f.

    Return the number of possible ways (out of fd total ways) modulo 109 + 7 to roll the dice so the sum of the face-up numbers equals target.

    Example 1:

    Input: d = 1, f = 6, target = 3
    Output: 1
    Explanation:
    You throw one die with 6 faces.  There is only one way to get a sum of 3.

 */

public class NumberOfDiceRollsWithTargetSum {

    public static void main(String[] args) {
        NumberOfDiceRollsWithTargetSum numberOfDiceRollsWithTargetSum = new NumberOfDiceRollsWithTargetSum();
        NumberOfDiceRollsWithTargetSum.Solution solution = numberOfDiceRollsWithTargetSum.new Solution();
        int result = solution.numRollsToTarget(3, 6, 3);
        System.out.println("Expected 1, Result:" + result);


    }

    class Solution {

        Integer[][] dp;

        public int numRollsToTarget(int d, int f, int target) {
            dp = new Integer[d + 1][target + 1];
            return fn(d, f, target);
        }

        private int fn(int d, int f, int target) {
            if (target == 0 && d == 0) {
                return 1;
            } else if (d == 0 || target <= 0) {
                return 0;
            }
            if (dp[d][target] != null) {
                return dp[d][target];
            }
            int ans = 0;
            for (int i = 1; i <= f; i++) {
                ans = (ans + fn(d - 1, f, target - i)) % 1000000007;
            }
            dp[d][target] = ans;
            return ans;
        }

    }

}
