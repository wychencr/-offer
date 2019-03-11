import java.util.Arrays;

/**
 * 51 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * 解题思路：
 * 直观的扫描数组，复杂度是O(n^2),通过归并排序的方法，可以将时间复杂度降为O(nlogn)，辅助空间是O(n)。
 * 在合并有序数列时，统计逆序对数目。比如，当nums[i] > nums[j]时，i和j所在的左、右序列已经是递增顺序，以j为参照，
 * i到m之间的所有数肯定大于nums[j]，共可组成m - i + 1组逆序对
 */

public class _51 {
    private long cnt = 0;
    private int[] temp;

    public int InversePairs(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        temp = new int[array.length];
        this.mergeSort(array, 0, array.length - 1);
        return (int) (cnt % 1000000007);
    }

    /**
     * 归并排序
     * @param nums 待排序数组
     * @param l 低位
     * @param h 高位
     */
    private void mergeSort(int[] nums, int l, int h) {
        if (l == h) {
            return;
        }
        int m = (l + h) / 2;
        this.mergeSort(nums, l, m);
        this.mergeSort(nums, m+1, h);
        this.merge(nums, l, m, h);
    }

    private void merge(int[] nums, int l, int m, int h) {
        int i = l, j = m + 1, k = l;
        for (; i <= m || j <= h; ++k) {
            if (i > m) {
                temp[k] = nums[j++];
            } else if (j > h) {
                temp[k] = nums[i++];
            } else if (nums[i] < nums[j]) {
                temp[k] = nums[i++];
            /*
             * 当nums[i] > nums[j]时，i和j所在的左、右序列已经是递增顺序，以j为参照，
             * i到m之间的所有数肯定大于nums[j]，共可组成m - i + 1组逆序对*/
            } else {
                temp[k] = nums[j++];
                cnt += m - i + 1;
            }
        }
        // 将合并后的序列复制到原数组中，使其生效，注意k的范围是从l到h
        for (k = l; k <= h; k++) {
            nums[k] = temp[k];
        }
    }
}
