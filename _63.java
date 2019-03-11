/**
 * 63 股票的最大利润
 * 找出数组中相差最大的一对数
 */

public class _63 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return -1;
        }
        int min = prices[0];
        int diff = 0;
        for (int i = 1; i < prices.length; ++i) {
            diff = Math.max(diff, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return diff;
    }
}
