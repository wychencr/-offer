/**
 * 22 链表中倒数第K个结点
 * 输入一个链表，输出该链表中倒数第k个结点
 *
 * 解题思路：使用两个指针，保持k-1的距离，同时向后遍历，后一个指针到达尾部时，前一个指针所指的节点即为所求
 */

public class _22 {

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k < 1) {
            return null;
        }
        ListNode node = head;
        int i = 0;
        while (head != null) {
            head = head.next;
            if (i >= k) {
                node = node.next;
            }
            ++i;
        }
        if (i < k) {
            return null;
        }
        return node;
    }


    /**
     * 链表结构
     */
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
