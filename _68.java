/**
 * 68-1 树中两个节点的最低公共祖先(二叉搜索树)
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * leetcode: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 *
 * 68-2 树中两个节点的最低公共祖先(普通二叉树)
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * leetcode: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 */

public class _68 {
    // 树中两个节点的最低公共祖先(二叉搜索树)
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor1(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor1(root.right, p, q);
        } else {
            return root;
        }
    }


    // 树中两个节点的最低公共祖先(普通二叉树)
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        return left == null ? right : (right == null ? left : root);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}