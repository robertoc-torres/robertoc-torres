package leetcode.amazon.assestment;

/*

    src:https://leetcode.com/problems/k-closest-points-to-origin/

    K Closest Points to Origin

    Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

    The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

    You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

 */

import java.util.*;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        KClosestPointsToOrigin kClosestPointsToOrigin = new KClosestPointsToOrigin();
        KClosestPointsToOrigin.Solution solution = kClosestPointsToOrigin.new Solution();
        int[][] result = solution.kClosest(new int[][]{{0,1}, {1,0}}, 2);
        System.out.println("Expected '[[0,1],[1,0]]', Result:");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0]);
            System.out.println(result[i][1]);
        }
    }

    class Solution {
        public int[][] kClosest(int[][] points, int k) {

            double[] kpoints = new double[points.length];

            for (int i = 0; i < points.length; i++) {
                kpoints[i] = Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2);
            }

            double[] sorted = Arrays.copyOf(kpoints, kpoints.length);
            Arrays.sort(sorted);

            int[][] r = new int[k][2];
            int min = 0;
            while (k > 0) {
                for (int i = 0; i < kpoints.length; i++) {
                    if (sorted[min] == kpoints[i]) {
                        r[k - 1][0] = points[i][0];
                        r[k - 1][1] = points[i][1];
                        kpoints[i] = -1;
                        break;
                    }
                }
                min++;
                k--;
            }

            return r;
        }
    }
}
