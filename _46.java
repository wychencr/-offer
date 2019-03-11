/**
 * 46 把数字翻译成字符串
 * 给定一个数字，按照如下规则翻译成字符串：1 翻译成“a”，2 翻译成“b”... 26 翻译成“z”。一个数字有多种翻译可能，例如 12258 一共
 * 有 5 种，分别是 abbeh，lbeh，aveh，abyh，lyh。实现一个函数，用来计算一个数字有多少种不同的翻译方法
 * Leetcode： https://leetcode.com/problems/decode-ways/description/
 *
 * 解题思路：
 * 定义函数f(i)表示从第i位数字开始的不同翻译的数目，则有f(i)=f(i+1) + g(i, i+1) * f(i+2)，其中当第i位和第i+1位数字拼接起来的数字在
 * 10 ~ 25范围内时，g(i, i+1) = 1，否则g(i, i+1) = 0，分别表示这两个数字单独翻译和一起翻译的情况，从尾部向前开始遍历，存储子问题。
 *
 */

public class _46 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '-') {
            return 0;
        }
        // dp[i]表示从第i位开始的不同翻译的数目
        int[] dp = new int[s.length() + 1];
        // 初始化
        dp[s.length()] = 1;
        dp[s.length() - 1] = 1;
        // 自尾部向前
        for (int i = s.length() - 2; i >= 0; --i) {
            if (s.substring(i, i + 2).compareTo("10") >= 0 && s.substring(i, i + 2).compareTo("25") <= 0) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(new _46().numDecodings("12258"));
        System.out.println(new _46().numDecodings("1"));
        System.out.println(new _46().numDecodings("-123"));
    }
}
