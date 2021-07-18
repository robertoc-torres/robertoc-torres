package leetcode.amazon.arraysandstrings;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        ProductOfArrayExceptSelf.Solution solution = productOfArrayExceptSelf.new Solution();
        int[] result = solution.productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println("Expected '[24,12,8,6]', Result:");
        for(int i : result) {
            System.out.print(i + " ");
        }
    }

    class Solution {
        public int[] productExceptSelf(int[] nums) {

            int[] L = new int[nums.length];
            int[] R = new int[nums.length];

            int t = 1;
            L[0] = 1;

            for (int i = 1; i < nums.length; i++) {
                t *= nums[i - 1];
                L[i] = t;
            }

            t = 1;
            R[nums.length - 1] = 1;
            for (int i = nums.length - 1; i > 0; i--) {
                t *= nums[i];
                R[i - 1] = t;
            }

            for (int i = 0; i < nums.length; i++) {
                System.out.println(L[i] + ", " + R[i]);
                nums[i] = L[i] * R[i];
            }

            return nums;
        }
    }
}
