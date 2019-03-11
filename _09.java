import java.util.Stack;

/**
 * 09 用两个栈实现队列
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
 * 栈1的push对应队列的deleteHead操作，栈2的pop操作对应队列的insertTail操作，当栈2为空时，将栈1的元素依次出栈，进到栈2中，如果栈1也为空，则提示队列为空
 */

public class _09 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * 队列的insertTail操作
     *
     * @param node 插入队尾的元素
     */
    public void push(int node) {
        stack1.push(node);
    }

    /**
     * 队列的deleteHead操作
     *
     * @return 删除队列头部
     */
    public int pop() {
        if (stack2.empty()) {
            if (stack1.empty()) {
                throw new RuntimeException("队列为空");
            } else {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
        }
        return stack2.pop();
    }
}
