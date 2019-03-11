import java.time.temporal.Temporal;

/**
 * 39 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中
 * 出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0
 *
 * 解题思路：
 * 根据题意，如果有一个数字出现的次数超过数组长度的一半，则超过了其他所有数字出现次数的和。使用两个变量，分别记录数组的元素和该元素
 * 出现的次数，遍历数组，如果与记录的数字相同，则次数加一，否则次数减一，当次数减为0时，则重新记录当前数字，设置次数为1，继续遍历。
 * 当数组遍历结束后，如果记录的次数为0则说明肯定不存在一个数出现的次数超过数组长度的一半，直接返回0；如果记录的次数大于0，说明记录的
 * 数字出现的次数可能超过数组长度的一半，因此要重新遍历数组判断是否满足条件，最终时间复杂度和空间复杂度都为O(n).
 */

public class _39 {

    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        // 分别记录数组的元素和该元素出现的次数
        int number = array[0];
        int count = 1;

        // 遍历数组，如果与记录的数字相同，则次数加一，否则次数减一，当次数减为0时，则重新记录当前数字，设置次数为1
        for (int i = 1; i < array.length; ++i) {
            if (array[i] == number) {
                ++count;
            } else {
                if (count > 0) {
                    --count;
                } else {
                    number = array[i];
                    count = 1;
                }
            }
        }

        // 如果记录的次数为0则说明肯定不存在一个数出现的次数超过数组长度的一半
        if (count == 0) {
            return 0;
        }

        // 重新遍历数组判断是否满足条件
        count = 0;
        for (int val : array) {
            if (val == number) {
                ++count;
            }
        }
        return count > array.length / 2 ? number : 0;
    }
}
