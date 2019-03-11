/**
 * 18 删除链表中的节点
 * 题目一：在O(1)时间内删除链表节点
 * 给定单链表的头指针和节点指针，在O(1)时间内删除该链表节点
 * 分析：如果从头指针开始遍历，找到需要的删除的节点，复杂度为O(n)，不符合题意；可以将待删除节点的后一个节点的内容赋给当前节点，然后删除
 * 当前节点的后一个节点，可以达到同样的效果，复杂度为O(1)
 * <p>
 * 题目二：删除链表中重复的结点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5
 * 处理后为 1->2->5
 */

public class _18 {
    /**
     * 删除链表中的节点
     *
     * @param head        头指针
     * @param toBeDeleted 待删除节点指针
     * @return 返回删除节点后的链表的头指针
     */
    public ListNode deleteNode(ListNode head, ListNode toBeDeleted) {
        if (head == null || toBeDeleted == null || head.next == null) {
            return head;
        }
        if (toBeDeleted.next == null) {
            // 如果待删除节点是尾节点
            ListNode node = head;
            while (node.next != toBeDeleted) {
                node = node.next;
            }
            node.next = null;
            toBeDeleted = null;
        } else {
            // 待删除节点不是尾节点
            toBeDeleted.val = toBeDeleted.next.val;
            toBeDeleted.next = toBeDeleted.next.next;
        }
        return head;
    }

    /**
     * 删除链表中重复的结点(非递归方式)
     *
     * @param pHead 头节点
     * @return 返回删除节点后的链表的头指针
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        // 新建一个头指针
        ListNode node = new ListNode(0);
        node.next = pHead;
        // 新建两个指针
        ListNode preNode = node;
        ListNode curNode = pHead;
        while (curNode != null && curNode.next != null) {
            if (curNode.val != curNode.next.val) {
                preNode = curNode;
                curNode = curNode.next;
            } else {
                while (curNode.next != null && curNode.val == curNode.next.val) {
                    curNode = curNode.next;
                }
                curNode = curNode.next;
                preNode.next = curNode;
            }
        }
        return node.next;
    }

    /**
     * 删除链表中重复的结点(递归方式)
     *
     * @param pHead 头节点
     * @return 返回删除节点后的链表的头指针
     */
    public ListNode deleteDuplicationRecursion(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode nextNode = pHead.next;
        // 如果头节点是重复节点
        if (pHead.val == nextNode.val) {
            while ((nextNode != null) && (nextNode.val == pHead.val)) {
                nextNode = nextNode.next;
            }
            return deleteDuplicationRecursion(nextNode);
        } else {
            pHead.next = deleteDuplicationRecursion(pHead.next);
            return pHead;
        }
    }

    /**
     * 链表结构
     */
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int value) {
            this.val = value;
        }
    }
}
