import java.util.Arrays;

/**
 * 66 构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法
 *
 * 解题思路：
 * 将B[i]的计算法分为两步，分别是A[0]*A[1]*...*A[i-1]，和A[i+1]*...*A[n-1]，分别从前往后和从后往前计算，再相乘即可
 */

public class _66 {
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        int[] B = new int[A.length];

        // B[i] = A[0]*A[1]*...*A[i-1]
        for (int i = 0, mul = 1; i < A.length; i++) {
            B[i] = mul;
            mul *= A[i];
        }

        // B[i] = B[i] * A[i+1]*...*A[n-1]
        for (int i = A.length - 1, mul = 1; i >= 0; --i) {
            B[i] *= mul;
            mul *= A[i];
        }
        return B;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _66().multiply(new int[] {1, 2, 3, 4, 5})));
    }
}
