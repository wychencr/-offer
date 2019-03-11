/**
 * 47 礼物的最大价值
 * 在一个 m*n 的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于 0）。你可以从棋盘的左上角开始拿礼格子里的礼物，并每次向右或
 * 向下移动一格，直到到达棋盘的右下角。给定一个棋盘和礼物，求你能拿到礼物的最大价值
 *
 * 解题思路：
 * 典型的动态规划问题
 */

public class _47 {
    public int getMaxValue(int[][] gift) {
        if (gift == null || gift.length == 0 || gift[0].length == 0) {
            return 0;
        }
        int row = gift.length; int col = gift[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = gift[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i > 0 && j > 0) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + gift[i][j];
                } else if (i == 0 && j > 0) {
                    dp[i][j] = dp[i][j-1] + gift[i][j];
                } else if (i > 0 && j == 0) {
                    dp[i][j] = dp[i-1][j] + gift[i][j];
                }
            }
        }
        return dp[row-1][col-1];
    }

    public static void main(String[] args) {
        int[][] gift = {{1, 10, 3, 8},
                        {12, 2, 9, 6},
                        {5, 7, 4, 11},
                        {3, 7, 16, 5}};
        // output: 53
        System.out.println(new _47().getMaxValue(gift));
    }
}
