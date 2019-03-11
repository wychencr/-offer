/**
 * 52 两个链表的第一个公共结点
 * 输入两个链表，找出它们的第一个公共结点
 *
 * 解题思路一：
 * 使用两个堆栈，分别遍历两个链表，将节点加入堆栈中，再依次比较。需要辅助空间O(m+n)
 *
 * 解题思路二：
 * 先遍历链表获取长度，然后长链表先走几步，步数是多出来的长度，再依次比较。不需要辅助空间，时间复杂度是O(m+n)
 *
 * 解题思路三：
 * 两个链表依次向前遍历，当a链表到达尾部后转向b的头节点，同理b链表到达尾部后转向a的头节点，最终两个链表遍历的节点相同时，即是公共节点。
 */

public class _52 {
    /* 解题思路二 */
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int len1 = 0, len2 = 0;
        ListNode head1 = pHead1;
        ListNode head2 = pHead2;
        // 先遍历链表获取长度
        while (head1 != null) {
            len1++;
            head1 = head1.next;
        }
        while (head2 != null) {
            len2++;
            head2 = head2.next;
        }
        head1 = pHead1;
        head2 = pHead2;
        // 长链表先走几步，步数是多出来的长度
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                head1 = head1.next;
            }
        } else {
            for (int i = 0; i < len2 - len1; i++) {
                head2 = head2.next;
            }
        }
        // 查找公共节点
        while (head1 != null && head2 != null) {
            if (head1 == head2) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        // 没有公共节点
        return null;
    }

    /* 解题思路三 */
    public ListNode FindFirstCommonNode3(ListNode pHead1, ListNode pHead2) {
        ListNode head1 = pHead1;
        ListNode head2 = pHead2;
        while (head1 != head2) {
            head1 = head1 == null ? pHead2 : head1.next;
            head2 = head2 == null ? pHead1 : head2.next;
        }
        return head1;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
