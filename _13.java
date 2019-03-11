/**
 * 13 机器人的运动范围
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标
 * 的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3
 * +8 = 19。请问该机器人能够达到多少个格子？
 */

public class _13 {
    public static int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows < 0 || cols < 0) {
            return 0;
        }
        boolean[][] visited = new boolean[rows][cols];
        return movingCountCore(threshold, rows, cols, 0, 0, visited);
    }

    /**
     * 核心递归函数
     *
     * @param threshold 门限
     * @param rows      行数
     * @param cols      列数
     * @param i         当前所在行位置
     * @param j         当前所在列位置
     * @param visited   尝试访问标志
     * @return count 返回可访问的方块数
     */
    private static int movingCountCore(int threshold, int rows, int cols, int i, int j, boolean[][] visited) {
        // 矩阵越界、对应位置已尝试访问过，则返回false
        if (i < 0 || i >= rows || j < 0 || j >= cols || visited[i][j]) {
            return 0;
        }
        // 标记当前位置已尝试访问
        visited[i][j] = true;
        // 判断能否访问，如果可以则结果加1，继续访问下一个位置
        if ((getSum(i) + getSum(j)) <= threshold) {
            return 1 + movingCountCore(threshold, rows, cols, i + 1, j, visited)
                    + movingCountCore(threshold, rows, cols, i - 1, j, visited)
                    + movingCountCore(threshold, rows, cols, i, j + 1, visited)
                    + movingCountCore(threshold, rows, cols, i, j - 1, visited);
        }
        // 拒绝访问当前位置，直接返回0
        return 0;
    }

    /**
     * 返回一个整数的各个数位的和
     *
     * @param number 参数为一个十进制整数
     * @return 返回各数位之和
     */
    private static int getSum(int number) {
        if (number < 0) {
            throw new RuntimeException("参数错误");
        }
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int threshold = 1;
        int rows = 2;
        int cols = 2;
        System.out.println(movingCount(threshold, rows, cols));
    }
}
