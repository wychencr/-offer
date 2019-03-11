/**
 * 04 二维数组中的查找
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和
 * 一个整数，判断数组中是否含有该整数。
 */
public class _04 {
    public static boolean find(int target, int[][] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        if (array[0].length == 0) {
            return false;
        }
        int col = array[0].length;
        int row = array.length;
        int i = row - 1;
        int j = 0;
        while (j < col && i >= 0) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19}};
        System.out.println("Find(5, array) = " + find(5, array));
    }
}
