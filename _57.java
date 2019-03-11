import java.util.ArrayList;
import java.util.Arrays;

/**
 * 57-1 和为 S 的两个数字
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 解题思路：
 * 数组是递增排序的，用两个指针分别指向两端，如果和大于目标值，则右指针向左移，否则左指针向右移动。复杂度是O(n)
 *
 * 57-2 和为 S 的连续正数序列
 * 很快的找出所有和为S的连续正数序列.输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *
 * 解题思路：
 * 同样使用两个指针，一开始分别指向1和2，如果指针之间的连续序列之和小于目标值，则右指针右移，如果小于则左指针右移，如果等于就把这个序列
 * 添加到ArrayList中。
 */
public class _57 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> arrayList = new ArrayList<>(2);
        if (array == null || array.length == 0) {
            return arrayList;
        }
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            if (array[start] + array[end] == sum) {
                arrayList.add(array[start]);
                arrayList.add(array[end]);
                break;
            } else if (array[start] + array[end] > sum) {
                end--;
            } else {
                start++;
            }
        }
        return arrayList;
    }

    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (sum < 3) {
            return arrayLists;
        }
        int start = 1;
        int end = 1 + start;
        while ((start < end) && (end < sum)) {
            int currentSum = (start + end) * (end - start + 1) / 2;
            if (currentSum == sum) {
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                arrayLists.add(new ArrayList<>(list));
                list.clear();

                end++;
                start++;
            } else if (currentSum > sum) {
                start++;
            } else {
                end++;
            }
        }
        return arrayLists;
    }
}
