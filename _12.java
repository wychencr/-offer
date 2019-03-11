/**
 * 12 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向
 * 左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。 例如 a b c e s f c s a d e e
 * 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之
 * 后，路径不能再次进入该格子
 */

public class _12 {
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        // 标记矩阵中元素是否被访问过
        boolean[][] visited = new boolean[rows][cols];
        // 遍历矩阵找到与str[0]相同的元素，然后开始递归
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (hasPathCore(matrix, rows, cols, i, j, 0, visited, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPathCore(char[] matrix, int rows, int cols, int i, int j, int k, boolean[][] visited, char[] str) {
        // 将二维坐标转化为一维，注意这里是列*行坐标 + 列坐标
        int index = cols * i + j;
        // 矩阵越界、对应位置已访问过、与目标元素不相等，则返回错误
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || visited[i][j]) {
            return false;
        }
        // 目标路径的最后一个元素已经访问到，则返回正确
        if (k == (str.length - 1)) {
            return true;
        }
        // 标记此位置已访问过
        visited[i][j] = true;

        // 递归上下左右四种走法
        if (hasPathCore(matrix, rows, cols, i + 1, j, k + 1, visited, str) ||
                hasPathCore(matrix, rows, cols, i - 1, j, k + 1, visited, str) ||
                hasPathCore(matrix, rows, cols, i, j + 1, k + 1, visited, str) ||
                hasPathCore(matrix, rows, cols, i, j - 1, k + 1, visited, str)) {
            return true;
        }

        // 该位置不通，回溯
        visited[i][j] = false;

        return false;
    }

    public static void main(String[] args) {
        char[] matrix = {'a', 'b', 't', 'g',
                'c', 'f', 'c', 's',
                'j', 'd', 'e', 'h'};
        int rows = 3;
        int cols = 4;
        char[] str = {'b', 'f', 'c', 'e'};
        System.out.println(hasPath(matrix, rows, cols, str));
    }
}
