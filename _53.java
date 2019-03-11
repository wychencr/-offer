/**
 * 53 数字在排序数组中出现的次数
 * 统计一个数字在排序数组中出现的次数。
 *
 * 解题思路：
 * 使用二分查找分别找到这个数组出现的开始位置和结束位置，作差即可得到次数，时间复杂度O(logn)
 */

public class _53 {
    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (getLastTarget(array, k) != -1 && getFirstTarget(array, k) != -1) {
            return getLastTarget(array, k) - getFirstTarget(array, k) + 1;
        }
        return 0;
    }

    private int getFirstTarget(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (array[mid] > target) {
                high = mid - 1;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else if (mid - 1 >= 0 && array[mid - 1] == target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private int getLastTarget(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (array[mid] > target) {
                high = mid - 1;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else if (mid + 1 < array.length && array[mid + 1] == target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 3, 3, 4, 5};
        System.out.println(new _53().GetNumberOfK(array, 3));
    }
}
