/**
 * 28 对称的二叉树
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * 解题思路：同时进行前序遍历和对称前序遍历，判断遍历值是不是相同的，如果都相同说明对称
 */

public class _28 {
    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return false;
        }
        return isSymmetricalCore(pRoot, pRoot);
    }

    private boolean isSymmetricalCore(TreeNode root1, TreeNode root2) {
        // 两个节点可能都是null，此时也满足对称情况
        if (root1 == null && root2 == null) {
            return true;
        }
        // 两个节点的值有一个为null或者不相等，则不满足对称条件
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSymmetricalCore(root1.left, root2.right) && isSymmetricalCore(root1.right, root2.left);
    }

    /**
     * 二叉树结构
     */
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
