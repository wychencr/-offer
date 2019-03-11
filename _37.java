/**
 * 37 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */

public class _37 {
    private String str = "";
    private int index = 0;

    public String Serialize(TreeNode root) {
        if (root == null) {
            str += "$,";
            return null;
        }
        str += (String.valueOf(root.val) + ",");
        Serialize(root.left);
        Serialize(root.right);

        return str.substring(0, str.length() - 1);
    }
    public TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String[] strArray = str.split(",");
        return deserializeCore(strArray);
    }

    private TreeNode deserializeCore(String[] strArray) {
        // 当前节点不为空时，会继续重建左右子树，否则返回null
        if (!strArray[index].equals("$")) {
            TreeNode treeNode = new TreeNode(Integer.valueOf(strArray[index++]));
            treeNode.left = deserializeCore(strArray);
            treeNode.right = deserializeCore(strArray);
            return treeNode;
        } else {
            index++;
            return null;
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        // 序列化
        System.out.println(new _37().Serialize(t1));
        // 反序列化
        TreeNode root = new _37().Deserialize(new _37().Serialize(t1));
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
    }

    /**
     * 二叉树结构
     */
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
