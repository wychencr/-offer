/**
 * 05 替换空格
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * <p>
 * 在字符串尾部填充任意字符，使得字符串的长度等于替换之后的长度。因为一个空格要替换成三个字符（%20），因此当遍历到一个空格时，需要在尾部填充两个任意字符。
 * 令 P1 指向字符串原来的末尾位置，P2 指向字符串现在的末尾位置。P1 和 P2 从后向前遍历，当 P1 遍历到一个空格时，就需要令 P2 指向的位置依次填充 02%（注意是逆序的），否则就填充上 P1 指向字符的值。
 * 从后向前遍是为了在改变 P2 所指向的内容时，不会影响到 P1 遍历原来字符串的内容
 */

public class _05 {
    public static String replaceSpace(StringBuffer str) {
        int originalLength = str.length();
        for (int i = 0; i < originalLength; ++i) {
            if (str.charAt(i) == ' ') {
                // 每遇到一个空格扩充2个长度
                str.append("  ");
            }
        }
        int newLength = str.length();
        int j = newLength - 1;
        for (int i = originalLength - 1; i >= 0; --i) {
            if (str.charAt(i) == ' ') {
                str.setCharAt(j--, '0');
                str.setCharAt(j--, '2');
                str.setCharAt(j--, '%');
            } else {
                str.setCharAt(j--, str.charAt(i));
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        replaceSpace(new StringBuffer("We Are Happy"));
    }
}
