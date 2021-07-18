package leetcode.amazon.assestment;

/*

    src:https://leetcode.com/problems/rectangle-overlap/

    Rectangle Overlap

    An axis-aligned rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) is the coordinate of its bottom-left corner, and (x2, y2) is the coordinate of its top-right corner. Its top and bottom edges are parallel to the X-axis, and its left and right edges are parallel to the Y-axis.

    Two rectangles overlap if the area of their intersection is positive. To be clear, two rectangles that only touch at the corner or edges do not overlap.

    Given two axis-aligned rectangles rec1 and rec2, return true if they overlap, otherwise return false.

 */

public class RectangleOverlap {

    public static void main(String[] args) {
        RectangleOverlap rectangleOverlap = new RectangleOverlap();
        RectangleOverlap.Solution solution = rectangleOverlap.new Solution();
        boolean result = solution.isRectangleOverlap(new int[]{0, 0, 2, 2}, new int[]{1, 1, 3, 3});
        System.out.println("Expected true, Result:" + result);
        /*result = solution.isRectangleOverlap(new int[]{0, 0, 1, 1}, new int[]{1, 0, 2, 1});
        System.out.println("Expected false, Result:" + result);
        result = solution.isRectangleOverlap(new int[]{0, 0, 1, 1}, new int[]{2, 2, 3, 3});
        System.out.println("Expected false, Result:" + result);
        result = solution.isRectangleOverlap(new int[]{7, 8, 13, 15}, new int[]{10, 8, 12, 20});
        System.out.println("Expected true, Result:" + result);
        result = solution.isRectangleOverlap(new int[]{2, 17, 6, 20}, new int[]{3, 8, 6, 20});
        System.out.println("Expected true, Result:" + result);
        result = solution.isRectangleOverlap(new int[]{-7, -3, 10, 5}, new int[]{-6, -5, 5, 10});
        System.out.println("Expected true, Result:" + result);
        result = solution.isRectangleOverlap(new int[]{-1, 0, 1, 1}, new int[]{0, -1, 0, 1});
        System.out.println("Expected false, Result:" + result);*/
        result = solution.isRectangleOverlap(new int[]{-193634870, -175701756, 958697367, 607619635}, new int[]{91619846, 10349052, 822028072, 696611776});
        System.out.println("Expected true, Result:" + result);
        result = solution.isRectangleOverlap(new int[]{8, 12, 12, 18}, new int[]{10, 17, 19, 20});
        System.out.println("Expected true, Result:" + result);
    }

    class Solution {
        public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

            if (rec1[0] == rec1[2] || rec1[1] == rec1[3] || rec2[0] == rec2[2] || rec2[1] == rec2[3])
                return false;

            if (rec2[0] < rec1[2] && rec2[1] < rec1[3] && rec2[2] > rec1[0] && rec2[3] > rec1[1]) {
                return true;
            }

            return false;
        }
    }

}