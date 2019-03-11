import java.sql.SQLOutput;

/**
 * 64 求 1+2+3+...+n
 * 要求不能使用乘除法、for、while、if、else、switch、case 等关键字及条件判断语句 A ? B : C
 *
 * 解题思路：
 * 利用递归和短路运算
 */

public class _64 {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean ans = (sum > 0) && ((sum += Sum_Solution(n-1)) > 0);
        return sum;
    }
}