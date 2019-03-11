/**
 * 10 斐波那契数列
 * 大家都知道斐波那契数列，后一项等于前两项和，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，n<=39）。
 * 使用两个数将结果前两项缓存即可
 */

public class _10 {
    public static int Fibonacci(int n) {
        int result = 0;
        int temp1 = 0;
        int temp2 = 1;
        if (n == 1) {
            return temp2;
        }
        for (int i = 1; i < n; i++) {
            result = temp1 + temp2;
            temp1 = temp2;
            temp2 = result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci(3) = " + Fibonacci(3));
    }
}
