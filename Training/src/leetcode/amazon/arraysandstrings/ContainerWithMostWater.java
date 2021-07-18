package leetcode.amazon.arraysandstrings;

/*
    src:https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2963/

    Container With Most Water

    Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical
    lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which,
    together with the x-axis forms a container, such that the container contains the most water.

    Notice that you may not slant the container.

 */

public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        ContainerWithMostWater.Solution solution = containerWithMostWater.new Solution();
        int result = solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println("Result:" + result);
    }

    class Solution {
        public int maxArea(int[] height) {
            int l = 0;
            int r = height.length - 1;
            int h;
            int maxArea = 0;
            while (l < r) {
                h = Math.min(height[l], height[r]);
                maxArea = Math.max(maxArea, h * (r - l));
                if (height[r] <= h) {
                    r--;
                    while (l < r && height[r] <= h) {
                        r--;
                    }
                } else {
                    l++;
                    while (l < r && height[l] <= h) {
                        l++;
                    }
                }
            }
            return maxArea;
        }
    }
}

