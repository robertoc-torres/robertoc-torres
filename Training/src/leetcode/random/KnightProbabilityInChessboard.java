package leetcode.random;

public class KnightProbabilityInChessboard {

    public static void main(String[] args) {
        KnightProbabilityInChessboard knightProbabilityInChessboard = new KnightProbabilityInChessboard();
        KnightProbabilityInChessboard.Solution solution = knightProbabilityInChessboard.new Solution();
        double result = solution.knightProbability(3, 2, 0, 0);
        System.out.println("Expected 1, Result:" + result);


    }

    class Solution {

        Double[][] dp;

        public double knightProbability(int n, int k, int row, int column) {
            dp = new Double[n][n];
            return fn(n, k, row, column);

        }

        private Double fn(int n, int k, int r, int c) {

            k--;
            if(k <= 0)
                return 1d;

            if(dp[r][c] != null) {
                return dp[r][c];
            }

            int in = 0;
            if (r + 1 < n) {
                if (c + 2 < n) {
                    in++;
                    fn(n, k, r + 1, c + 2);
                }
                if (c - 2 > 0) {
                    in++;
                    fn(n, k, r + 1, c - 2);
                }
            }
            if (r - 1 > 0) {
                if (c + 2 < n) {
                    in++;
                    fn(n, k, r - 1, c + 2);
                }
                if (c - 2 > 0) {
                    in++;
                    fn(n, k, r - 1, c - 2);
                }
            }
            if (r - 2 > 0) {
                if (c + 1 < n) {
                    in++;
                    fn(n, k, r - 2, c + 1);
                }
                if (c - 1 > 0) {
                    in++;
                    fn(n, k, r - 2, c - 1);
                }
            }
            if (r + 2 < n) {
                if (c + 1 < n) {
                    in++;
                    fn(n, k, r + 2, c + 1);
                }
                if (c - 1 > 0) {
                    in++;
                    fn(n, k, r + 2, c - 1);
                }
            }

            double p = (double) 2 / (double) 8;
            System.out.printf("prob:%f", p);

            dp[r][c] = p;

            return 1d;

        }

    }

}
