/**
 * 08 二叉树的下一个结点
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针
 * 分三种情况：
 * （1）当前节点有右子树，则下一个中序遍历节点是右子树中的最左节点
 * （2）当前节点没有右子树，且该节点是其父节点的左节点，则下一个节点是其父节点
 * （3）当前节点没有右子树，且该节点是其父节点的右节点，则沿着其父节点向上遍历，直到找到一个是其父节点的左节点的节点，这个节点的父节点即为所求
 */

/**
 * public class TreeLinkNode {
 * int val;
 * TreeLinkNode left = null;
 * TreeLinkNode right = null;
 * TreeLinkNode next = null;
 * <p>
 * TreeLinkNode(int val) {
 * this.val = val;
 * }
 * }
 */
public class _08 {

    public static TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        // 当前节点有右子树
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        // 当前节点没有右子树，且该节点没有父节点，是根节点
        if (pNode.next == null) {
            return null;
        }
        // 当前节点没有右子树，且该节点是其父节点的左节点
        if (pNode.next.left == pNode) {
            return pNode.next;
        }
        // 当前节点没有右子树，且该节点是其父节点的右节点
        if (pNode.next.right == pNode) {
            pNode = pNode.next;
            while (pNode.next != null) {
                if (pNode.next.left != pNode) {
                    pNode = pNode.next;
                } else {
                    return pNode.next;
                }
            }
        }
        return null;
    }


    /**
     * 二叉树结构，包含了指向其父节点的指针
     */
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
