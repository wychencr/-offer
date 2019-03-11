import java.util.ArrayList;

/**
 * 34 二叉树中和为某一值的路径
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的
 * 结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 *
 * 解题思路：
 * 使用前序遍历二叉树，每次访问到一个子树根节点时，就将其加入到路径列表中，接着判断当前路径是否符合要求（没有子节点且路径和等于目标值），
 * 如果符合则将该路径加到列表中，否则继续遍历其子节点。当前节点访问结束后，递归函数将回溯到其父节点，因此要将当前节点从列表中删除
 */

public class _34 {
    private ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return arrayLists;
        }
        // 假设当前节点在路径中，则将当前子树的根节点加到列表中
        list.add(root.val);
        target -= root.val;

        // 如果已经找到了满足条件的路径，则添加路径到列表中
        if (target == 0 && root.left == null && root.right == null) {
            arrayLists.add(new ArrayList<>(list));
        }
        // 否则继续在子树中寻找(如果找到了会将路径加到arrayLists列表中)
        FindPath(root.left, target);
        FindPath(root.right, target);

        // 回溯到父节点(将当前节点从列表中移除)
        list.remove(list.size() - 1);

        // 返回路径列表
        return arrayLists;
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
