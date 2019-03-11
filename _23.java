/**
 * 23 链表中环的入口结点
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * 解题思路一：
 * 定义两个指针，若环的长度为x，让一个指针先在起点，一个指针多走x步，然后两个指针一起前进，当相遇的时候，相遇点就是环的入口点；
 * 环的长度获取可以通过快慢指针实现，快指针每次走两步，慢指针每次走一步，相遇时一定位于环上，然后从该点开始计数，直到回到该点时停止计数，
 * 得到的值就是环的长度；
 *
 * 解题思路二：
 * 定义快慢指针，快指针每次走两步，慢指针每次走一步，在某个节点相遇，设链表起点到环的入口点距离为x，相遇点距环的入口点为y，环的长度为c，
 * 则有等式 2（x + y） = x + y + c 成立，得到x = c - y，说明：链表起点到环的入口点距离等于相遇点到环的入口点距离；因此，让两个指针
 * 分别从相遇点和链表起点出发（每次走一步），相遇点就是环的入口点
 *
 * 解题思路三：
 * 断链法：每次访问一个节点后，将其前面的节点的next重置为null，这样当遇到一个节点的next为null时，说明该节点访问过，是环入口点
 */

public class _23 {
    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode slowNode = pHead.next;
        if (slowNode.next == null) {
            return null;
        }
        ListNode fastNode = slowNode.next;
        while (fastNode != slowNode) {
            // 如果无环
            if (fastNode == null || fastNode.next == null) {
                return null;
            }
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        while (pHead != slowNode) {
            pHead = pHead.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        listNode5.next = listNode3;

        System.out.println(EntryNodeOfLoop(listNode1).val);
    }
    /**
     * 链表结构
     */
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
