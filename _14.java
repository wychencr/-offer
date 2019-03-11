/**
 * 14 剪绳子
 * 把一根绳子剪成多段，并且使得每段的长度乘积最大
 * <p>
 * 使用动态规划算法：
 * 第一种情况：题目规定至少剪一次绳子，每次剪绳子都是一分为二，若绳子长度为n，现在对于1到j的绳子段，在第i处剪，记f(j)是使得每段的长度
 * 乘积最大的结果，则f(j)=max_i {f(i) * f(j-i)}，其中 1<=j<=n，1<=i<j，此时表明了在将绳子分成两段时，1到i段和i+1到j段又分别至少被
 * 分割了一次；
 * 第二种情况：在将绳子分成两段时，就不再分割了，所以有f(j) = i * (j-i)；
 * 第三种情况：在将绳子分成两段时，一段分割，一段不分割，则有f(j) = f(i) * (j-i) 或 f(j) = i * f(j-i)；
 * 结论：f(j) = max_i {f(i) * f(j-i), i * (j-i), f(i) * (j-i)}，其中 1<=j<=n，1<=i<j
 * <p>
 * 使用贪心算法：
 * n >= 5时，尽可能剪长度为3的绳子，如果剩下的长度为4，则剪成2乘2的
 */

public class _14 {
    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int j = 2; j <= n; ++j) {
            for (int i = 1; i < j; ++i) {
                dp[j] = Math.max(dp[j], Math.max(i * (j - i), dp[i] * (j - i)));
            }
        }
        return dp[n];
    }

    public static int integerBreakGreed(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int timesOf3 = n / 3;
        if ((n - timesOf3 * 3) == 1) {
            timesOf3--;
        }
        int timesOf2 = (n - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3)) * (int) (Math.pow(2, timesOf2));
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(8));
        System.out.println(integerBreakGreed(8));
    }
}
