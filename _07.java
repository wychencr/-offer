/**
 * 07 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * 解题思路：前序遍历的第一个值为根节点的值，使用这个值将中序遍历结果分成两部分，左部分为树的左子树中序遍历结果，
 * 右部分为树的右子树中序遍历的结果,然后就可以接着分别对左右子树递归下去。
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class _07 {

    /**
     * 重建二叉树
     *
     * @param pre 前序遍历
     * @param in  中序遍历
     * @return 返回重建的二叉树
     */
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0) {
            return null;
        }
        return reConstructBinaryTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    /**
     * 扩充前序与中序的索引参数，便于递归重建二叉树
     *
     * @param pre      前序遍历
     * @param in       中序遍历
     * @param preStart 前序遍历数组的开始索引
     * @param preEnd   前序遍历数组的结束索引
     * @param inStart  中序遍历数组的开始索引
     * @param inEnd    中序遍历数组的结束索引
     * @return 返回重建的二叉树
     */
    private static TreeNode reConstructBinaryTree(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        // 根节点的值是前序遍历的第一个值
        int rootValue = pre[preStart];
        TreeNode treeNode = new TreeNode(rootValue);
        // 找到中序遍历序列中的根节点的位置，递归得到左右节点
        for (int i = inStart; i <= inEnd; ++i) {
            if (in[i] == pre[preStart]) {
                treeNode.left = reConstructBinaryTree(pre, in, preStart + 1, preStart + i - inStart, inStart, i - 1);
                treeNode.right = reConstructBinaryTree(pre, in, preStart + i - inStart + 1, preEnd, i + 1, inEnd);
                break;
            }
        }
        return treeNode;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        reConstructBinaryTree(pre, in);
    }


    /**
     * 内部类：二叉树结构
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
