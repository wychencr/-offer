/**
 * 24 反转链表
 * 输入一个链表，反转链表后，输出新链表的表头。
 */

public class _24 {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curNode = head.next;
        head.next = null;
        while (curNode.next != null) {
            ListNode tempNode = curNode.next;
            curNode.next = head;
            head = curNode;
            curNode = tempNode;
        }
        // 将最后一个节点指向倒数第二个节点
        curNode.next = head;
        return curNode;
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
