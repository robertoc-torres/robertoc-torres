package amazon.assestment;

import java.util.*;

public class CutOfTree {

    public static void main(String[] args) {
        CutOfTree cutOfTree = new CutOfTree();
        CutOfTree.Solution solution = cutOfTree.new Solution();

        List<List<Integer>> ll = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        ll.add(l);
        l = new ArrayList<>();
        l.add(0);
        l.add(0);
        l.add(4);
        ll.add(l);
        l = new ArrayList<>();
        l.add(7);
        l.add(6);
        l.add(5);
        ll.add(l);

        int result = solution.cutOffTree(ll);
        System.out.println("Expected 6, Result:" + result);
    }

    class Solution {

        int rows, cols;
        List<List<Integer>> forest;

        private int bfs(int sr, int sc, int dr, int dc) {

            int minimumSteps = -1;
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            boolean[][] seen = new boolean[rows][cols];
            Queue<int[]> queue = new LinkedList<>();

            seen[sr][sc] = true;
            queue.offer(new int[]{sr, sc});

            while (!queue.isEmpty()) {
                ++minimumSteps;
                int size = queue.size();

                while (size-- != 0) {
                    int[] curr = queue.poll();
                    if (curr[0] == dr && curr[1] == dc) {
                        return minimumSteps;
                    }

                    for (int[] direction : directions) {
                        int row = curr[0] + direction[0];
                        int col = curr[1] + direction[1];

                        if (row >= 0 && row < rows && col >= 0 && col < cols && !seen[row][col] && forest.get(row).get(col) != 0) {
                            seen[row][col] = true;
                            queue.offer(new int[]{row, col});
                        }
                    }
                }
            }

            return -1;
        }

        public int cutOffTree(List<List<Integer>> forest) {

            this.forest = forest;
            rows = forest.size();
            cols = rows == 0 ? 0 : forest.get(0).size();
            PriorityQueue<int[]> trees = new PriorityQueue<>((tree1, tree2) -> tree1[2] - tree2[2]);

            if (rows == 0 || cols == 0 || forest.get(0).get(0) == 0) {
                return -1;
            }

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (forest.get(row).get(col) > 1) {
                        trees.offer(new int[]{row, col, forest.get(row).get(col)});
                    }
                }
            }

            int minimumSteps = 0;
            int row = 0, col = 0;

            while (!trees.isEmpty()) {
                int[] tree = trees.poll();
                int minSteps = bfs(row, col, tree[0], tree[1]);
                if (minSteps == -1) {
                    return -1;
                }

                row = tree[0];
                col = tree[1];
                minimumSteps += minSteps;
            }

            return minimumSteps;
        }
    }
}
