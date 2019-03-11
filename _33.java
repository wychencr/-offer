/**
 * 33 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字
 * 都互不相同。
 *
 * 解题思路：
 * 二叉搜索树，后序遍历，根节点在最后一个，左子树所有节点小于根节点，右子树所有节点大于根节点，针对仅有左子树、仅有右子树和左右
 * 子树都存在这三种情况，进行递归
 */

public class _33 {
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    /**
     * 递归判断
     * @param sequence 待判序列
     * @param start 当前树的后续遍历序列开始位置
     * @param end 当前树的后续遍历序列结束位置
     * @return 是否是二叉搜索树的后续遍历序列
     */
    private static boolean verifySquenceOfBST(int [] sequence, int start, int end) {
        if (start == end) {
            return true;
        }
        // 找到右子树开始的位置，sequence[end]是根节点
        int index = -1;
        for (int i = 0; i < end; ++i) {
            if (sequence[i] > sequence[end]) {
                index = i;
                break;
            }
        }
        // 如果只有左子树，没有右子树(所有节点都比根节点小，index没有被赋值)
        if (index == -1) {
            return verifySquenceOfBST(sequence, start, end - 1);
        }
        // 如果有右子树，判断右子树所有节点是否都大于根节点
        for (int i = index + 1; i < end; ++i) {
            if (sequence[i] < sequence[end]) {
                return false;
            }
        }
        // 如果仅有右子树，没有左子树(从第0个值就开始比根节点大)
        if (index == 0) {
            return verifySquenceOfBST(sequence, index, end - 1);
        }
        // 左、右子树均存在
        return verifySquenceOfBST(sequence, start, index - 1) &&
                verifySquenceOfBST(sequence, index, end - 1);
    }

    public static void main(String[] args) {
        int[] sequence1 = {5, 7, 6, 9, 11, 10, 8};
        int[] sequence2 = {1, 2, 5, 3};
        int[] sequence3 = {1, 2, 3, 4, 5};
        int[] sequence4 = {7, 4, 6, 5};
        System.out.println(VerifySquenceOfBST(sequence1));
        System.out.println(VerifySquenceOfBST(sequence2));
        System.out.println(VerifySquenceOfBST(sequence3));
        System.out.println(VerifySquenceOfBST(sequence4));
    }
}
