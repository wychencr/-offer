/**
 * 56 数组中只出现一次的数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n),空间复杂度是O(1)。
 * num1,num2分别为长度为1的数组。传出参数，将num1[0],num2[0]设置为返回结果
 *
 * 解题思路：
 * 本题对时间和空间复杂度作了限制，因此不能采用排序、hash表等传统的方法，可以利用位运算的性质来解题。
 * 异或性质：一个数与自身异或等于0.
 * 1、我们将数组中所有数进行异或，在数组中，出现偶数次的数经过异或是0，因此最终结果相当于两个出现一次的数字相互异或的结果，这个结果不为0.
 * 2、找到结果中最低的为1的位，根据这个位置，将数组中的数分成两组，一组中的数该位置都是0，另一组该位置是1，从而这两个数被分到了不同的组。
 * 这是因为，对于出现偶数次的数，他们在相同位置的位肯定相同，因此肯定在同组，对于两个只出现一次的数字不可能在同组，因为他们在该位置的位肯定
 * 不相同。
 * 3、分别对这两个组的数进行异或，即可在O(n)的时间内找出这两个只出现一次的数字
 */

public class _56 {
    public void FindNumsAppearOnce(int[] array, int num1[] , int num2[]) {
        if (array == null || array.length == 0) {
            return;
        }
        int res = array[0], flag = 1;
        // 数组所有数异或
        for (int i = 1; i < array.length; i++) {
            res ^= array[i];
        }
        // 找到最低的为1的位
//        while ((res & flag) == 0) {
//            flag = flag << 1;
//        }
        flag = res & (-res);
        // 0和一个数异或还是它本身
        num1[0] = 0;
        num2[0] = 0;
        for (int anArray : array) {
            // 该位置为0
            if ((anArray & flag) == 0) {
                num1[0] ^= anArray;
            // 该位置为1
            } else {
                num2[0] ^= anArray;
            }
        }
    }

    public static void main(String[] args) {
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        int[] array = {2, 4, 3, 8, 9, 2, 3, 4};
        new _56().FindNumsAppearOnce(array, num1, num2);
        System.out.println(num1[0] + " " + num2[0]);
    }
}
