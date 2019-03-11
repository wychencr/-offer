/**
 * 35 复杂链表的复制
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂
 * 链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * 解题思路一：
 * 1、复制链表，将复制的节点放置于原节点的后面，呈A-A'-B-B'-C-C'排布
 * 2、根据原链表的指向关系，操作复制链表的指向
 * 3、拆分两个链表
 *
 * 解题思路二：
 * 1、复制链表，并使用一个HashMap，key为原节点，value为复制的节点
 * 2、设置random的指向，复制节点的random指向为：Map{ key = 相同位置原节点的random指向}
 */

public class _35 {
    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        // 复制链表，将复制的节点放置于原节点的后面，呈A-A'-B-B'-C-C'排布
        RandomListNode curNode = pHead;
        while (curNode != null) {
            RandomListNode copyNode = new RandomListNode(curNode.label);
            RandomListNode nextNode = curNode.next;
            curNode.next = copyNode;
            copyNode.next = nextNode;
            curNode = nextNode;
        }

        // 根据原链表的指向关系，操作复制链表的指向
        curNode = pHead;
        while (curNode != null) {
            if (curNode.random != null) {
                curNode.next.random = curNode.random.next;
            }
            curNode = curNode.next.next;
        }

        // 拆分两个链表
        curNode = pHead;
        RandomListNode node = pHead.next;
        while (curNode.next != null) {
            RandomListNode nextNode = curNode.next;
            curNode.next = nextNode.next;
            curNode = nextNode;
        }

        return node;
    }

    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        RandomListNode node5 = new RandomListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        node1.random = node3;
        node2.random = node5;
        node4.random = node2;

        RandomListNode node =  Clone(node1);
        while (node != null) {
            System.out.println("-----------------------");
            System.out.println("node.label:" + node.label);
            if (node.next != null) {
                System.out.println("node.next:" + node.next.label);
            }
            if (node.random == null) {
                System.out.println("node.random:" + "null");
            } else {
                System.out.println("node.random:" + node.random.label);
            }
            node = node.next;
        }
    }

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
