import java.util.Stack;

/**
 * 31 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 *
 * 解题思路：使用一个辅助堆栈，输入参数为数组1（入栈序列）和数组2（出栈序列），在每次循环中，先入栈一个数字，数组1索引后移一位，
 * 避免堆栈为空，然后判断栈顶元素和数组2当前要出栈的数字是否相同，如果是则pop一次，数组2索引后移一次，继续循环判断，循环过程中
 * 要注意数组2不能溢出，堆栈不能为空，如果不相等则跳出第二个循环，继续外围循环，入栈再判断
 */

public class _31 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0 || popA.length == 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, j = 0; i < popA.length; ++i) {
            stack.push(pushA[i]);
            // 注意堆栈判空
            while (j < popA.length && !stack.isEmpty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
