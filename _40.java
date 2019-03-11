import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 40 最小的K个数
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4
 *
 * 解题思路一：
 * 维护一个大小为k的大顶堆，然后遍历n个整数，如果当前数比大顶堆中的最大数小，则替换，否则继续遍历。对堆的操作时间是O(logk)，
 * 通过PriorityQueue实现，总的时间复杂度为O(nlogk)。适合处理海量数据，不需要将所有数据都读入内存中。
 *
 * 解题思路二：
 * 利用快排的思想，根据Partition函数返回的下标位置pivot，如果等于k-1（前k-1个数都小于第k个小于第k+1个），说明前k个数已经是最小的了；
 * 如果pivot大于k-1，则在前pivot-1下标的数中继续寻找，否则在后pivot+1下标的数中寻找。
 */

public class _40 {
    /**
     * 解题思路一
     * @param input 输入数组
     * @param k K个数
     * @return 返回最小的K个数列表
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (input == null || k <= 0 || k > input.length) {
            return new ArrayList<>();
        }
        // 维护一个size为k的大顶堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, ((o1, o2) -> o2 - o1));
        for (int num : input) {
            if (maxHeap.size() < k) {
                maxHeap.add(num);
            } else {
                if (num < maxHeap.peek()) {
                    maxHeap.poll();
                    maxHeap.add(num);
                }
            }
        }
        return new ArrayList<>(maxHeap);
    }

    /**
     * 解题思路二
     * @param input 输入数组
     * @param k K个数
     * @return 返回最小的K个数列表
     */
    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (input == null || k <= 0 || k > input.length) {
            return arrayList;
        }
        int low = 0; int high = input.length - 1;
        int pivot = this.Partition(input, low, high);
        // 如果pivot大于k-1，则在前pivot-1下标的数中继续寻找，否则在后pivot+1下标的数中寻找
        while (pivot != k - 1) {
            if (pivot > k - 1) {
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
            pivot = this.Partition(input, low, high);
        }
        // 此时pivot已经等于k-1，前k个数已经是最小的了
        for (int i = 0; i < k; ++i) {
            arrayList.add(input[i]);
        }
        return arrayList;
    }

    // 使pivotKey左边的数都小于input[pivotKey]，右边的数都大于input[pivotKey]
    private int Partition(int[] input, int low, int high) {
        int pivotKey = input[low];
        while (low < high) {
            while (low < high && pivotKey < input[high]) {
                high--;
            }
            swap(input, pivotKey, high);
            while (low < high && input[low] < pivotKey) {
                low++;
            }
            swap(input, low, pivotKey);
        }
        return pivotKey;
    }

    // 交换数组中下标a和b的位置
    private void swap(int[] input, int a, int b) {
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }


    public static void main(String[] args) {
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        ArrayList<Integer> arrayList = new _40().GetLeastNumbers_Solution2(input, k);
        for (Integer integer : arrayList) {
            System.out.print(integer + " ");
        }
    }
}
