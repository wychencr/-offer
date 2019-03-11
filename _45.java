import java.util.Arrays;

/**
 * 45 把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这
 * 三个数字能排成的最小数字为321323
 *
 * 解题思路：
 * 将数字转化为字符串数组，然后排序，根据s1 + s2 和 s2 + s1 拼接后比较大小
 */

public class _45 {
    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        String[] numsOfStr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numsOfStr[i] = String.valueOf(numbers[i]);
        }
        // 根据s1 + s2 和 s2 + s1 拼接后比较大小
        Arrays.sort(numsOfStr, (String s1, String s2) -> (s1 + s2).compareTo(s2 + s1));
        String str = "";
        for (String s : numsOfStr) {
            str += s;
        }
        return str;
    }
}
