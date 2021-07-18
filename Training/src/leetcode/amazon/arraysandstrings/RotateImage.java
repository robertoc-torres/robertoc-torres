package leetcode.amazon.arraysandstrings;

import java.util.ArrayDeque;
import java.util.Queue;

/*
    src:https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2969/

    Rotate Image
    You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

    You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

 */

public class RotateImage {

    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();
        RotateImage.Solution solution = rotateImage.new Solution();
        //int[][] input = {{1}};
        int[][] input = {{3, 1}, {4, 2}};
        //int[][] input = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //int[][] input = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};

        System.out.println("Input Matrix");
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                System.out.print(input[i][j] + "  ");
            }
            System.out.println("");
        }

        solution.rotate(input);

        System.out.println("Rotated Matrix");
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                System.out.print(input[i][j] + "  ");
            }
            System.out.println("");
        }
    }

    class Solution {
        public void rotate(int[][] matrix) {

            Queue<Integer> cache = new ArrayDeque<>();

            int tmp;
            int dec;
            for (int j = 0; j < matrix.length / 2; j++) {
                int limit = matrix[0].length - 1 - j;

                dec = 0;
                // first row
                for (int i = j; i < limit; i++) {
                    cache.add(matrix[j][i]);
                    matrix[j][i] = matrix[limit - dec][j];
                    dec++;
                }
                // last column
                for (int i = j; i < limit; i++) {
                    tmp = matrix[i][limit];
                    matrix[i][limit] = cache.poll();
                    cache.add(tmp);
                }
                // last row
                for (int i = limit; i > j; i--) {
                    tmp = matrix[limit][i];
                    matrix[limit][i] = cache.poll();
                    cache.add(tmp);
                }
                // first column
                for (int i = limit; i > j; i--) {
                    tmp = matrix[i][j];
                    matrix[i][j] = cache.poll();
                    cache.add(tmp);
                }

                cache.clear();
            }

        }
    }

}
