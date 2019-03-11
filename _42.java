/**
 * 42 连续子数组的最大和
 * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,
 * 并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)
 *
 * 解题思路：
 * 设f[i]表示以第i个数字结尾的连续子数组的最大和（第i个数字一定在向量中），则有f[i] = f[i-1] + array[i]，当f[i-1] > 0；
 * 否则f[i] = array[i]，最终的结果为max{ f[i] }
 */

public class _42 {

    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException();
        }
        int[] f = new int[array.length];
        f[0] = array[0]; int result = f[0];
        for (int i = 1; i < array.length; i++) {
            f[i] = f[i-1] < 0 ? array[i] : f[i-1] + array[i];
            result = Math.max(result, f[i]);
        }
        return result;
    }
}
