package amazon.arraysandstrings;

import java.util.Arrays;

/*
    src:https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2967/

    3Sum Closest

    Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    Example 1:

    Input: nums = [-1,2,1,-4], target = 1
    Output: 2
    Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 */

public class ThreeSumClosest {

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        ThreeSumClosest.Solution solution = threeSumClosest.new Solution();
        //int result = solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        //int result = solution.threeSumClosest(new int[]{0, 1, 2}, 3);
        //int result = solution.threeSumClosest(new int[]{1, 1, 1, 0}, -100);
        //int result = solution.threeSumClosest(new int[]{0, 2, 1, -3}, 1);
        //int result = solution.threeSumClosest(new int[]{-1, 0, 1, 1, 55}, 3);
        int result = solution.threeSumClosest(new int[]{3, 4, 5, 5, 7}, 13);
        System.out.println("Result:" + result);
    }

    class Solution {
        public int threeSumClosest(int[] nums, int target) {

            int sum;
            int curDiff;
            int closest = 0;
            int closestSum = 0;
            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 2; i++) {

                int lo = i + 1;
                int hi = nums.length - 1;

                while (lo < hi) {
                    sum = nums[i] + nums[lo] + nums[hi];

                    if (i == 0 && lo == 1 && hi == nums.length - 1) {
                        //First iteration
                        closest = target - sum;
                        closestSum = sum;
                        curDiff = target - sum;
                    } else {
                        curDiff = target - sum;
                        if (Math.abs(curDiff) < Math.abs(closest)) {
                            closest = curDiff;
                            closestSum = sum;
                        }
                    }
                    if (curDiff > 0) {
                        ++lo;
                        while (lo + 1 < hi && nums[lo] == nums[lo - 1])
                            ++lo;
                    } else if (curDiff < 0) {
                        --hi;
                        while (lo < hi - 1 && nums[hi] == nums[hi + 1])
                            --hi;
                    } else {
                        return sum;
                    }
                }

            }

            return closestSum;

        }
    }

}
