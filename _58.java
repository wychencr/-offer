/**
 * 58-1 翻转单词顺序列
 * “student. a am I”,翻转单词顺序“I am a student.”
 *
 * 解题思路：
 * 先对整个序列进行逆序，然后再对每个单词进行逆序。
 *
 * 58-2 左旋转字符串
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */

public class _58 {
    // 58-1 翻转单词顺序列
    public String ReverseSentence(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        char[] chars = str.toCharArray();
        // 对整个序列进行逆序
        reverseInterval(chars, 0, chars.length - 1);
        // 对每个单词进行逆序(i, j 记录每个单词的左右区间)
        for (int i = 0, j = 0; j < chars.length - 1; ) {
            if (chars[j + 1] == ' ') {
                reverseInterval(chars, i, j);
                j += 2;
                i = j;
            } else {
                ++j;
            }
            if (j == chars.length - 1) {
                reverseInterval(chars, i, j);
            }
        }
        return new String(chars);
    }

    // 58-2 左旋转字符串
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() < n) {
            return str;
        }
        return str.substring(n) + str.substring(0, n);
    }

    /**
     * 对区间内的字符进行逆序
     * @param chars 字符数组
     * @param index1 左区间
     * @param index2 右区间
     */
    private void reverseInterval(char[] chars, int index1, int index2) {
        for (int i = 0; i <= (index2 - index1) / 2; ++i) {
            swap(chars, index1 + i, index2 - i);
        }
    }

    /**
     * 交换两个字符
     * @param chars 字符数组
     * @param index1 索引1
     * @param index2 索引2
     */
    private void swap(char[] chars, int index1, int index2) {
        char c = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = c;
    }

    public static void main(String[] args) {
        System.out.println(new _58().ReverseSentence("I am a student!"));
    }
}
