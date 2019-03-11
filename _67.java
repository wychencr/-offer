/**
 * 67 把字符串转换成整数
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 *
 * 解题思路：
 * 注意首位的正负号和一些非法输入即可。
 */

public class _67 {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] ch = str.toCharArray();
        int result = 0;
        for (int i = 0; i < ch.length; ++i) {
            if (i == 0 && (ch[0] == '+' || ch[0] == '-')) {
                continue;
            }
            if (ch[i] < '0' || ch[i] > '9') {
                return 0;
            }
            result = result * 10 + (ch[i] - '0');
        }
        if (ch[0] == '-') {
            result = -result;
        }
        return result;
    }
}
