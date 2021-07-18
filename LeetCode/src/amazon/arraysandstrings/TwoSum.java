package amazon.arraysandstrings;

/*

    src:https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/508/
    Two Sum

    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.

    Example 1:

    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Output: Because nums[0] + nums[1] == 9, we return [0, 1].

 */

public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        TwoSum.Solution solution = twoSum.new Solution();
        int[] result = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println("Result:");
        twoSum.printArrayContent(result);
    }

    public void printArrayContent(int[] arr) {
        String output = "{";
        for (int i = 0; i < arr.length; i++) {
            output += arr[i] + ",";
        }
        output = output.substring(0, output.length() - 1) + "}";
        System.out.println(output);
    }

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            for (int o = 0; o < nums.length; o++) {
                int index = o;
                int aux = target - nums[o];
                for (int i = 0; i < nums.length; i++) {
                    if (i != index && aux - nums[i] == 0) {
                        return new int[]{index, i};
                    }
                }
            }
            return null;
        }
    }

}
