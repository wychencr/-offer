import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 06 从头到尾打印链表
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */

/**
 * public class ListNode {
 * int val;
 * ListNode next = null;
 * <p>
 * ListNode(int val) {
 * this.val = val;
 * }
 * }
 */
public class _06 {
    /**
     * 使用堆栈
     *
     * @param listNode 链表头结点
     * @return 反向打印所有值
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.empty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    /**
     * 使用递归
     *
     * @param listNode 链表头结点
     * @return 反向打印所有值
     */
    public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> arrayList = printListFromTailToHead1(listNode.next);
        arrayList.add(listNode.val);

        return arrayList;
    }

    /**
     * 使用头插法
     * 构建一个头指针head，初始head->next = null，然后不断将listNode中的节点加到head后面，相当于反向链表
     *
     * @param listNode 链表头结点
     * @return 反向打印所有值
     */
    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }
        // 头指针
        ListNode head = new ListNode(0);
        head.next = null;

        // 将listNode中的结点逐步加到head后面
        while (listNode != null) {
            // 先存储下一个结点
            ListNode nextNode = listNode.next;
            // 头插
            listNode.next = head.next;
            head.next = listNode;
            // 继续下一次循环
            listNode = nextNode;
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        // 头结点
        listNode = head.next;
        while (listNode != null) {
            arrayList.add(listNode.val);
            listNode = listNode.next;
        }
        return arrayList;
    }


    public static void main(String[] args) {
        // 构造一个链表
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode2.next = null;
        listNode1.next = listNode2;

        List<Integer> list = printListFromTailToHead2(listNode1);
        for (Integer integer : list) {
            System.out.println(integer + " ");
        }
    }


    /**
     * 内部类：相当于一个链表节点
     */
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


}
