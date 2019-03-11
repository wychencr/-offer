import java.util.PriorityQueue;

/**
 * 41 数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个
 * 数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 *
 * 解题思路：
 * 分别使用大顶堆和小顶堆实现数据流的左半边和右半边，左半边的数都小于右半边的数。堆的插入操作为O(logn)，获取堆顶数据O(1)。每次从数据流中读取一个数据，约定如果是第
 * 奇数个，则插入左边的堆，否则插入右边的堆，这样可以使两边的堆平衡，如果数据流总数为奇数个，则中位数就是左边堆的堆顶，如果是偶数个就是
 * 左右两个堆堆顶之和的平均值。
 * 在插入式还需要注意，如果是第偶数个，但是其值比左边堆的堆顶还要小，则将其插入到左边，然后再将左边堆的堆顶
 * 插入到右边堆保持平衡，同理如果是第奇数个数大于右边堆的最小值，做法一样。
 */

public class _41 {
    private PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>(((o1, o2) -> o2 - o1));
    private PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();
    private int length = 0;


    public void Insert(Integer num) {
        length++;
        if (length == 1) {
            // 第一个数直接插入即可
            leftMaxHeap.add(num);
        } else {
            // 如果是第偶数个，插入到右边
            if (length % 2 == 0) {
                if (num >= leftMaxHeap.peek()) {
                    rightMinHeap.add(num);
                } else {
                    leftMaxHeap.add(num);
                    rightMinHeap.add(leftMaxHeap.poll());
                }
            } else {
                if (num <= rightMinHeap.peek()) {
                    leftMaxHeap.add(num);
                } else {
                    rightMinHeap.add(num);
                    leftMaxHeap.add(rightMinHeap.poll());
                }
            }
        }
    }

    public Double GetMedian() {
        if (length % 2 == 0) {
            return (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
        }
        return Double.valueOf(leftMaxHeap.peek());
    }
}
