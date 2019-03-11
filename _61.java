import java.util.Arrays;

/**
 * 61 扑克牌顺子
 * 随机抽五张牌，判断是不是顺子，大小王可以看成是任意数字（比如0）。
 *
 * 解题思路：
 * 统计0的个数，统计空缺的数目，判断0的个数是不是大于空缺的数目
 */

public class _61 {
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length != 5) {
            return false;
        }
        Arrays.sort(numbers);
        // 统计0的个数
        int numsOfZero = 0;
        for (int i = 0; i < 5; ++i) {
            if (numbers[i] == 0) {
                numsOfZero++;
            }
        }
        // 统计空缺的数目
        int numsOfGap = 0;
        for (int i = numsOfZero + 1; i < 5; ++i) {
            if (numbers[i] == numbers[i-1]) {
                return false;
            }
            numsOfGap += (numbers[i] - numbers[i-1] - 1);
        }
        // 判断0的个数是不是大于空缺的数目
        return numsOfZero >= numsOfGap;
    }
}
