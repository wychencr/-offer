/**
 * 25 合并两个排序的链表
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * 解题思路一：
 * 设置两个指针分别指向两个链表，每次比较当前两个指针所指向的值，哪个小就指向哪个，对应的指针后移，当其中一个链表遍历完后，直接指向另一个链表的当前指针
 *
 * 解题思路二：
 * 递归法：比较最前面的节点值的大小，返回较小的作为头节点
 */

public class _25 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        // 定义一个头指针
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 == null) {
            cur.next = list2;
        } else {
            cur.next = list1;
        }
        // 返回头指针指向的头节点
        return head.next;
    }

    /**
     * 递归法
     * @param list1 链表1
     * @param list2 链表2
     * @return 合并后的头节点
     */
    public ListNode MergeRecursion(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = MergeRecursion(list1.next, list2);
            return list1;
        } else {
            list2.next = MergeRecursion(list1, list2.next);
            return list2;
        }
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
