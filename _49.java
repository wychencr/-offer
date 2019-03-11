/**
 * 49 丑数
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。
 * 求按从小到大的顺序的第N个丑数
 *
 * 解题思路一：
 * 依次判断每一个整数是否为丑数，直到找到目标丑数
 *
 * 解题思路二：
 * 以较小的空间换取时间，通过不断生成排序的丑数序列，直接找到目标丑数。其中，后一个丑数一定是前面某一个丑数乘以2，3，5得到的，大于当前
 * 丑数且尽量小，记录前面这个丑数的位置，每次更新后一个丑数时，更新这个位置即可。
 */

public class _49 {
    public int GetUglyNumber_Solution2(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] dp = new int[index];
        int i2 = 0, i3 = 0, i5 = 0;
        dp[0] = 1;
        for (int i = 1; i < index; i++) {
            dp[i] = Math.min(dp[i2] * 2, Math.min(dp[i3] * 3, dp[i5] * 5));
            if (dp[i] == dp[i2] * 2) {
                i2++;
            }
            if (dp[i] == dp[i3] * 3) {
                i3++;
            }
            if (dp[i] == dp[i5] * 5) {
                i5++;
            }
        }
        return dp[index - 1];
    }


    public int GetUglyNumber_Solution1(int index) {
        int number = 0;
        int uglyIndex = 0;
        while (uglyIndex < index) {
            number++;
            if (this.isUglyNumber(number)) {
                uglyIndex++;
            }
        }
        return number;
    }


    private boolean isUglyNumber(int number) {
        while (number % 2 == 0) {
            number /= 2;
        }
        while (number % 3 == 0) {
            number /= 3;
        }
        while (number % 5 == 0) {
            number /= 5;
        }
        return number == 1;
    }

    public static void main(String[] args) {
        System.out.println(new _49().GetUglyNumber_Solution1(10));
        System.out.println(new _49().GetUglyNumber_Solution2(10));
    }
}
