import java.util.ArrayList;

/**
 * 29 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4
 * 矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * 解题思路：
 * 一圈一圈打印，从左往右，从上往下，从右往左，从下往上，每次打印一行或者一列后，对边界进行收缩，
 * 当边界不满足起始位置小于结束位置的条件时，结束循环即可
 */

public class _29 {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (rowStart <= rowEnd && colStart <= colEnd) {
            // 从左到右
            for (int i = colStart; i <= colEnd; ++i) {
                arrayList.add(matrix[rowStart][i]);
            }
            rowStart++;

            // 从上到下
            if (rowStart > rowEnd) {
                break;
            }
            for (int i = rowStart; i <= rowEnd; ++i) {
                arrayList.add(matrix[i][colEnd]);
            }
            colEnd--;

            // 从右到左
            if (colEnd < colStart) {
                break;
            }
            for (int i = colEnd; i >= colStart; --i) {
                arrayList.add(matrix[rowEnd][i]);
            }
            rowEnd--;

            // 从下往上
            if (rowEnd < rowStart) {
                break;
            }
            for (int i = rowEnd; i >= rowStart; --i) {
                arrayList.add(matrix[i][colStart]);
            }
            colStart++;
        }
        return arrayList;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3, 4}, {5, 6, 7, 8},
                          {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] matrix2 = {{1, 2, 3, 4, 5}};
        int[][] matrix3 = {{1}, {2}, {3}, {4}, {5}};
        System.out.println(printMatrix(matrix1));
        System.out.println(printMatrix(matrix2));
        System.out.println(printMatrix(matrix3));
    }
}
