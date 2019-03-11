/**
 * 36 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向
 *
 * 解题思路：
 * 对于二叉搜索树，中序遍历正好是升序，每次将遍历到的节点加入到双向链表中即可，需要记录双向链表的位置
 */

public class _36 {
    private TreeNode left = null;
    private TreeNode right = null;

    /**
     * 中序遍历,每次将遍历到的节点加入到双向链表中
     * @param pRootOfTree 当前子树的根节点
     * @return 返回双向链表的头节点
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        // 对左子树中序遍历,每次将遍历到的节点加入到双向链表中
        Convert(pRootOfTree.left);

        if (right == null) {
            // 第一次遍历到树的最左边的叶子节点时(即可确定双向链表最左边的头节点)
            left = pRootOfTree;
        } else {
            // 将当前遍历的根节点加入到双向链表的末端
            right.right = pRootOfTree;
            pRootOfTree.left = right;
        }
        // 同时更新双向链表的最右端节点的位置
        right = pRootOfTree;

        // 对右子树中序遍历,每次将遍历到的节点加入到双向链表中
        Convert(pRootOfTree.right);

        return left;
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
