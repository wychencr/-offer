/**
 * 60 n 个骰子的点数
 * 解题思路：
 * n个骰子之和的范围为6~6n，设dp[i][j]表示共i个骰子，和为j时出现的次数，则j的范围为i<=j<=i*maxValue，递推关系为dp[i][j] += dp[i-1][j-k]；
 */

public class _60 {
    public void printProbability(int n) {
        int maxValue = 6;
        double totalNum = Math.pow(maxValue, n);

        // n个骰子，6~6n
        int[][] dp = new int[n+1][maxValue*n+1];
        // 初始化，1个骰子,出现次数均为1
        for (int j = 1; j <= maxValue; j++) {
            dp[1][j] = 1;
        }
        for (int i = 2; i <= n; ++i) {
            // i个骰子，和范围是i到i*maxValue
            for (int j = i; j <= i * maxValue; ++j) {
                // 向上一面可能为1到maxValue且要保证j-k >= 1
                for (int k = 1; k <= maxValue && (j - k >= 1); ++k) {
                    dp[i][j] += dp[i-1][j-k];
                }
            }
        }
        for (int j = n; j <= maxValue*n; ++j) {
            System.out.println("sum " + j + ":\t" + dp[n][j] + "\tp " + dp[n][j] / totalNum);
        }
    }

    public static void main(String[] args) {
        new _60().printProbability(3);
    }
}