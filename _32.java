import java.util.*;

/**
 * 32 从上往下打印二叉树
 * 题目一：从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 解题思路：BFS
 *
 * 题目二：把二叉树打印成多行
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * 解题思路：
 * 设置全局变量lastNode将每行的最后一个节点存储起来，当遍历到该节点时，在添加其所有子节点后，将队列的最后一个节点保存到lastNode中，
 * 这是作为下一层的最后一个节点
 *
 * 题目三：按之字形顺序打印二叉树
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，
 * 其他行以此类推。
 * 解题思路：
 * 在题目二的基础上，对偶数层的list进行反转即可；也可以使用两个堆栈，在奇数层和偶数层分别push左、右节点和右、左节点
 */

public class _32 {
    /**
     * 从上往下打印二叉树
     * @param root 根节点
     * @return 打印顺序值
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null) {
            return arrayList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            arrayList.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return arrayList;
    }

    /**
     * 把二叉树打印成多行
     * @param pRoot 根节点
     * @return 打印的二维数组
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (pRoot == null) {
            return arrayList;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        TreeNode lastNode = pRoot;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            // 判断是否是一层的最后一个节点，如果是则储存下一层的最后一个节点
            if (node == lastNode) {
                lastNode = queue.peekLast();
                // 此处注意不能直接将list添加到arrayList中，否则后面的clear操作会清空对应的栈区
                arrayList.add(new ArrayList<>(list));
                list.clear();
            }
        }
        return arrayList;
    }

    /**
     * 把二叉树打印成多行
     * @param pRoot 根节点
     * @return 打印的二维数组
     */
    ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        // 奇偶标志
        boolean flag = false;
        if (pRoot == null) {
            return arrayList;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        TreeNode lastNode = pRoot;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            // 判断是否是一层的最后一个节点，如果是则储存下一层的最后一个节点
            if (node == lastNode) {
                lastNode = queue.peekLast();
                // 此处注意不能直接将list添加到arrayList中，否则后面的clear操作会清空对应的栈区
                if (flag) {
                    Collections.reverse(list);
                }
                arrayList.add(new ArrayList<>(list));
                flag = !flag;
                list.clear();
            }
        }
        return arrayList;
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
