package random;

public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(1));
        System.out.println(new ClimbingStairs().climbStairs(2));
        System.out.println(new ClimbingStairs().climbStairs(3));
        System.out.println(new ClimbingStairs().climbStairs(5));
        System.out.println(new ClimbingStairs().climbStairs(6));
        System.out.println(new ClimbingStairs().climbStairs(45));
        System.out.println(new ClimbingStairs().climbStairs2(45));
    }

    /*

    2
    1 + 1
    2

    3
    1 + 1 + 1
    2 + 1
    1 + 2

    5
    1 + 1 + 1 + 1 + 1
    2 + 1 + 1 + 1
    2 + 2 + 1
    2 + 1 + 2
    1 + 1 + 1 + 2
    1 + 1 + 2 + 1
    1 + 2 + 1 + 1
    2 + 1 + 1 + 1

    6
    1 + 1 + 1 + 1 + 1 + 1
    2 + 1 + 1 + 1 + 1
    2 + 2 + 1 + 1
    2 + 2 + 2
    1 + 1 + 1 + 1 + 2
    1 + 1 + 1 + 2 + 1
    1 + 1 + 2 + 1 + 1
    1 + 2 + 1 + 1 + 1

     */

    public int climbStairs(int n) {
        int posibilities = 0;
        if (n == 1) {
            posibilities++;
        }
        if (n == 2) {
            posibilities += 2;
        }
        if (n - 2 > 0) {
            posibilities += climbStairs(n - 2) + climbStairs(n - 1);
        }
        return posibilities;
    }

    public int climbStairs2(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        if (n >= 2) {
            for (int i = 2; i < n + 1; i++) {
                res[i] = res[i - 1] + res[i - 2];
            }
        }
        return res[n];
    }
}

