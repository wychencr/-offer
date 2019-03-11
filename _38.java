import java.util.ArrayList;
import java.util.Collections;

/**
 * 字符串的排列
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,
 * bca,cab和cba。
 */

public class _38 {

    private ArrayList<String> arrayList = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if (str != null && str.length() > 0) {
            // 递归，将全排列加到列表中
            this.permutation(str.toCharArray(), 0);
            // 按字典序排序
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    private void permutation(char[] charArray, int index) {
        // 当索引和数组长度一致时，将此时顺序的数组转成字符串加到列表中
        if (index == charArray.length - 1) {
            // 避免重复
            if (!arrayList.contains(String.valueOf(charArray))) {
                arrayList.add(String.valueOf(charArray));
            }
        } else {
            // 将字符数组的第一位(从索引开始)与后面字符不断交换
            for (int i = index; i < charArray.length; ++i) {
                this.swap(charArray, i, index);
//                // 如果要打印出所有的组合
//                if (!arrayList.contains(String.valueOf(charArray))) {
//                    arrayList.add(String.valueOf(charArray).substring(0, index + 1));
//                }
                this.permutation(charArray, index + 1);
                this.swap(charArray, i, index);
            }
        }

    }

    private void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

    public static void main(String[] args) {
        ArrayList<String> arrayList = new _38().Permutation("abc");
        for (String str : arrayList) {
            System.out.println(str);
        }
    }
}
