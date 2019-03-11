import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 59 滑动窗口的最大值
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组 {2, 3, 4, 2, 6, 2, 5, 1} 及滑动窗口的大小 3，那么一共存在 6 个滑动窗口，他们的最大值分别为 {4, 4, 6, 6, 6, 5}。
 *
 * 解题思路：
 * 使用双端队列，保存下标，队首始终保存最大的数的下标，当从队尾进来一个数时，如果前面有比它小的数，则移除。当队首的数过期时，也需要移除。
 */

public class _59 {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        if (num == null || size <= 0 || num.length < size) {
            return new ArrayList<>();
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> deque = new LinkedList<>();
        // 在前size个数中找最大的一个数放到队列中
        for (int i = 0; i < size; ++i) {
            if (deque.size() == 0) {
                deque.add(i);
                continue;
            }
            // 如果前面有比它小的数，则移除
            while (deque.size() > 0 && num[i] >= num[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.add(i);
        }
        arrayList.add(num[deque.peekFirst()]);

        for (int i = size; i < num.length; ++i) {
            // 首先判断队首的数有没有过期
            if (i - deque.peekFirst() >= size) {
                deque.pollFirst();
            }
            // 如果前面有比它小的数，则移除
            while (deque.size() > 0 && num[i] >= num[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.add(i);
            // 滑动窗口中最大的数为在队首
            arrayList.add(num[deque.peekFirst()]);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        int[] num1 = {2, 3, 4, 2, 6, 2, 5, 1};
        int[] num2 = {16, 14, 12, 10, 8, 6, 4};
        System.out.println(new _59().maxInWindows(num1, 3).toString());
        System.out.println(new _59().maxInWindows(num2, 5).toString());
    }
}
