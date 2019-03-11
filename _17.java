/**
 * 17 打印从 1 到最大的 n 位数
 * <p>
 * 输入参数可能会很大，因此将题目转变成字符数组来打印，使用递归进行全排列
 */

public class _17 {
    public static void print1ToMaxOfNDigits(int n) {
        if (n < 0) {
            throw new RuntimeException("参数错误");
        }
        char[] number = new char[n];
        print1ToMaxOfNDigitsCore(number, 0);
    }

    /**
     * 核心全排列递归函数
     *
     * @param number 字符数组
     * @param index  索引
     */
    private static void print1ToMaxOfNDigitsCore(char[] number, int index) {
        // 当索引和数组长度相同时，说明数组已经完全被填充
        if (index == number.length) {
            printNumber(number);
            return;
        }
        // 在每个索引的位置都有'0'到'9'，10种可能
        for (int i = 0; i < 10; ++i) {
            number[index] = (char) ('0' + i);
            // 继续下一个索引位置的打印
            print1ToMaxOfNDigitsCore(number, index + 1);
        }
    }

    /**
     * 打印时忽略字符数组中最前面的'0'
     *
     * @param number 字符数组
     */
    private static void printNumber(char[] number) {
        int startPrintIndex = 0;
        for (char cNumber : number) {
            if (cNumber == '0') {
                startPrintIndex++;
            } else {
                break;
            }
        }
        for (int i = startPrintIndex; i < number.length; i++) {
            System.out.print(number[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        print1ToMaxOfNDigits(2);
    }
}
