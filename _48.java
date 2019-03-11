import java.util.Arrays;

/**
 * 48 最长不含重复字符的子字符串
 * 寻找最长不含重复字符的子字符串，字符串范围'a'~'z'.
 *
 * 解题思路：
 * 定义函数f(i)为以第i个字符为结尾的不包含重复字符的子字符串的最长长度（第i个字符一定在这个最长不重复的子串中），则有一下三种情况：
 * 1、第i个字符之前没出现过，则有递推关系f(i) = f(i-1) + 1;
 * 2、第i个字符之前出现过，且与上次出现位置的距离为d，若 d<=f(i-1)，说明这个字符一定出现在f(i-1)对应的最长不重复的子串中，因此有f(i) = d;
 * 3、若 d>f(i-1)，说明这个字符不在f(i-1)对应的最长不重复的子串中，因此有f(i) = f(i-1) + 1;
 * 最终结果为max_i {f(i)}
 */

public class _48 {
    public int longestSubStringWithoutDuplication(String str) {
        int curLength = 0;  // f(i)
        int maxLength = 0;  // final result

        int[] position = new int[26];  // record position
        Arrays.fill(position, -1); // init

        for (int curIndex = 0; curIndex < str.length(); curIndex++) {
            // 获取当前字符之前出现过的位置preIndex，如果没出现过则为-1
            int preIndex = position[str.charAt(curIndex) - 'a'];
            // 第i个字符之前没出现过，或者 d>f(i-1)，有f(i) = f(i-1) + 1
            if (preIndex == -1 || curIndex - preIndex > curLength) {
                curLength++;
            } else {
                // d<=f(i-1),f(i)=d， 此时f(i)相对于f(i-1)(即curLength)会减小，需要记录为maxLength
                maxLength = Math.max(maxLength, curLength);
                // f(i)=d
                curLength = curIndex - preIndex;
            }

            // 存储当前字符的位置
            position[str.charAt(curIndex) - 'a'] = curIndex;
        }
        // 更新结果
        maxLength = Math.max(maxLength, curLength);
        return maxLength;
    }
}
