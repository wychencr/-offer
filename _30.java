import java.util.Stack;

/**
 * 30 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 * 解题思路：
 * 使用一个辅助堆栈，当主栈push一个值时，与辅助栈栈顶元素比较，取较小的压入辅助栈；当主栈pop一个值时，辅助栈也弹出一个值
 */

public class _30 {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
        // 取较小的压入辅助栈
        if (stack2.isEmpty()) {
            stack2.push(node);
        } else {
            stack2.push(node > stack2.peek() ? stack2.peek() : node);
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }

    public static void main(String[] args) {
        _30 stack = new _30();
        stack.push(3);
        System.out.println(stack.min());
        stack.push(4);
        System.out.println(stack.min());
        stack.push(2);
        System.out.println(stack.min());
        stack.push(3);
        System.out.println(stack.min());
    }
}
