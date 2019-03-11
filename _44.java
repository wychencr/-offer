/**
 * 44 数字序列中的某一位数字
 * 数字以 0123456789101112131415... 的格式序列化到一个字符串中，请写一个函数，求任意第n位对应的数字。
 *
 * 解题思路：
 * 通过查找规律跳过一些区间
 */

public class _44 {
    /**
     * 先找到所在位置的数字区间，然后调用函数精确找到对应的数字
     * @param index 位置
     * @return 返回任意第index位对应的数字
     */
    public int digitAtIndex(int index) {
        if (index < 0) {
            return -1;
        }
        int lengthOfNum = 1;
        while (true) {
            int cnt = lengthOfNum * this.countOfInteger(lengthOfNum);
            // 调用函数精确找到对应的数字
            if (index < cnt) {
                return this.digitAtIndex(index, lengthOfNum);
            }
            // 跳过区间
            index -= cnt;
            lengthOfNum++;
        }
    }

    /**
     * 精确查找位置
     * @param index 相对位置
     * @param lengthOfNum 数字长度
     * @return 返回对应位置的数字
     */
    private int digitAtIndex(int index, int lengthOfNum) {
        int number = this.beginNumber(lengthOfNum) + index / lengthOfNum;
        // 从右向左查找
        int indexFromRight = lengthOfNum - index % lengthOfNum;
        for (int i = 1; i < indexFromRight; ++i) {
            number /= 10;
        }
        // 返回个位即为所求
        return number % 10;
    }

    /**
     * 返回长度为lengthOfNum的所有数字个数(10, 90, 900...)
     * @param lengthOfNum 数字长度
     * @return 长度为lengthOfNum的所有数字个数
     */
    private int countOfInteger(int lengthOfNum) {
        if (lengthOfNum == 1) {
            return 10;
        }
        return (int) (9 * Math.pow(10, lengthOfNum - 1));
    }

    /**
     * 返回长度为lengthOfNum的第一个数字(0, 10, 100...)
     * @param lengthOfNum 数字长度
     * @return 长度为lengthOfNum的第一个数字
     */
    private int beginNumber(int lengthOfNum) {
        if (lengthOfNum == 1) {
            return 0;
        }
        return (int) Math.pow(10, lengthOfNum - 1);
    }
}
