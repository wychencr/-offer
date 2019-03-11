/**
 * 11 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
 * 题目意思给定一个旋转的数组（部分有序），查找数组中最小值，可以采用二分查找，第一个指针始终指向前面递增数组的元素，第二个指针始终指向
 * 第二个递增数组的元素，最终两个指针相邻，此时第二个指针指向的元素是最小的元素，当两个指针指向的元素和中间位置的元素值都一样时，无法判
 * 断中间元素在第一个数组还是第二个数组中，采用顺序查找的方式
 */

public class _11 {
    public static int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (mid == low) {
                return array[high];
            }
            // 顺序查找最小值
            if (array[low] == array[mid] && array[high] == array[mid]) {
                int min = array[low];
                for (int i = low + 1; i <= high; ++i) {
                    if (min > array[i]) {
                        min = array[i];
                    }
                }
                return min;
            }
            if (array[low] <= array[mid]) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return array[high];
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 5, 1, 2};
        System.out.println(minNumberInRotateArray(array));
    }
}
