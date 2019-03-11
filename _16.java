/**
 * 16 数值的整数次方
 * 给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent，求 base 的 exponent 次方
 * <p>
 * 考虑底数为0，或者指数为0和负数的情况，乘方的计算可以通过递归以空间换取时间，注意指数是奇数还是偶数
 */

public class _16 {
    public static double Power(double base, int exponent) {
        boolean flag = false;
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        // 指数为负数，取绝对值，最后返回倒数即可
        if (exponent < 0) {
            flag = true;
            exponent = -exponent;
        }
        double result = Power(base * base, exponent >> 1);
        // 如果指数是奇数，还需要多乘一次
        if (exponent % 2 == 1) {
            result *= base;
        }
        return flag ? 1 / result : result;
    }

    public static void main(String[] args) {
        System.out.println("Power(2, -3) = " + Power(2, -3));
        System.out.println("Power(2, 3) = " + Power(2, 3));
    }
}
