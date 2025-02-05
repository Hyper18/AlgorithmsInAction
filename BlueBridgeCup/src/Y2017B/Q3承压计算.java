package Y2017B;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hyper
 * @date 2022/04/01
 * <p>
 * answer: 72665192664
 * <p>
 * 思路 模拟 1. 边界条件：0-29 2. 如何精确保留每次/2的重量（避免浮点数小数截断）
 * 对每层的值作位运算累乘，保证即使是最后一层等分，其结果依然为整数
 */
public class Q3承压计算 {
    private static final int N = 30;

    public static void main(String[] args) {
        long[][] nums = new long[N][N];
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int p = 1;
        for (int i = 0; i < N; i++) {
            p <<= 1;
        }
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                nums[i][j] = in.nextLong() * p;
            }
        }
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                long half = nums[i][j] / 2;
                nums[i + 1][j] += half;
                nums[i + 1][j + 1] += half;
            }
        }

        long min = Arrays.stream(nums[N - 1]).min().getAsLong();
        long max = Arrays.stream(nums[N - 1]).max().getAsLong();

        System.out.printf("%d %d\n", min / 2, max / 2);

        in.close();
    }
}
