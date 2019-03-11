/**
 * 21 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * 解题思路：要保持相对顺序不变，可以以空间换取时间，两次遍历，将奇数和偶数分别取出来再合并到一起
 */

public class _21 {
    public static void reOrderArray(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int[] newArray = new int[array.length];
        int index = 0;
        for (int item : array) {
            if (item % 2 == 1) {
                newArray[index++] = item;
            }
        }
        for (int item : array) {
            if (item % 2 == 0) {
                newArray[index++] = item;
            }
        }
        // 将原来栈区的元素改变(不能直接array=newArray，那样只是改变了形参的array指向，对主函数中的array不生效)
        for (int i = 0; i < array.length; ++i) {
            array[i] = newArray[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        reOrderArray(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
