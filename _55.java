/**
 * 55-1 二叉树的深度
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度
 *
 * 解题思路一：
 * 使用BFS层序遍历，得到树的深度。
 *
 * 解题思路二：
 * 使用递归，更为简洁。
 *
 * 55-2 平衡二叉树
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树
 */

public class _55 {
    /**
     * 55-1 二叉树的深度
     * @param root root
     * @return 深度
     */
    public int TreeDepth(TreeNode root) {
        if (root != null) {
            return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
        }
        return 0;
    }


    /**
     * 55-2 平衡二叉树
     * @param root root
     * @return 是否是平衡二叉树
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root) != -1;
    }
    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 后序遍历
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        // 如果左子树或者右子树不平衡，则当前树不平衡(直接返回-1，相当于剪枝)
        if (leftDepth == -1 || rightDepth == -1) {
            return -1;
        }
        // 如果左右子树是平衡的，但是深度相差大于1则当前树不平衡，否则返回最大的子树深度加1
        return Math.abs(leftDepth - rightDepth) > 1 ? -1 : 1 + Math.max(leftDepth, rightDepth);
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
