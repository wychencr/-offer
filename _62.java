import java.util.LinkedList;

/**
 * 62 圆圈中最后剩下的数
 * 随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版
 * (名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 *
 * 解题思路一：
 * 模拟环形链表
 *
 * 解题思路二：
 * 数学归纳法，找出规律，有f(n, m) = [f(n-1, m) + m] % n, n > 1
 */

public class _62 {
    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.peekFirst();
    }

    public static void main(String[] args) {
        System.out.println(new _62().LastRemaining_Solution(5, 3));;
    }
}
