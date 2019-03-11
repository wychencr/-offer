/**
 * 50 第一个只出现一次的字符位置
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）
 *
 * 解题思路：
 * 先扫描一次，将每个字符出现的次数统计到数组中，第二次扫描找出第一个只出现一次的字符。
 */

public class _50 {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        int[] hashTable = new int[256];
        for (char c : str.toCharArray()) {
            hashTable[(int) c]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (hashTable[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}
