/**
 * 54 二叉搜索树的第 K 个结点
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 *
 * 解题思路：
 * 中序遍历，得到递增序列，通过计数器可以找到第K个结点。
 */

public class _54 {
    private int cnt = 0;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k < 1) {
            return null;
        }
        return inOrder(pRoot, k);
    }

    /**
     * 二叉搜索树，中序遍历，返回第k大的节点
     * @param root 根节点
     * @param k k
     * @return 返回第k大的节点
     */
    private TreeNode inOrder(TreeNode root, int k) {
        if (root != null) {
            // 访问左子树,如果返回值不是null说明找到了第k个节点，直接返回node
            TreeNode node = inOrder(root.left, k);
            if (node != null) {
                return node;
            }

            // 访问当前节点,如果是第k个节点，则返回当前节点
            ++cnt;
            if (cnt == k) {
                return root;
            }

            // 访问右子树,如果返回值不是null说明找到了第k个节点，直接返回node
            node = inOrder(root.right, k);
            if (node != null) {
                return node;
            }
        }
        return null;
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
