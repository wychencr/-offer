/**
 * 15 二进制中 1 的个数
 * 输入一个整数，输出该数二进制表示中 1 的个数
 * <p>
 * 可以通过将输入的整数每次算术右移，然后和1进行“与”运算；也可以令flag=1，每次与输入的数进行“与”运算，然后对flag左移；
 * 复杂度最低的做法是让输入的整数减一再与自身相与，会让整数最右边的1变为0
 */

public class _15 {
    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("NumberOf1 = " + NumberOf1(0b101010));
    }
}
