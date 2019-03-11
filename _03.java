/**
 * 03 数组中重复的数字
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几
 * 次。请找出数组中任意一个重复的数字。
 */

public class _03 {
    public static boolean duplicate(int[] numbers, int length, int[] duplication) {
        int[] array = new int[length];
        for (int i = 0; i < length; ++i) {
            if (array[numbers[i]] == 0) {
                array[numbers[i]] = 1;
            } else {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 1, 0, 2, 5, 3};
        int[] duplication = new int[1];
        System.out.println(duplicate(numbers, numbers.length, duplication) + " " + duplication[0]);
    }
}
