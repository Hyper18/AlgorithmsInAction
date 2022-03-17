package Y2014A;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2022/03/16
 * 主要坑在去重上
 * 首先满足乘法交换律的视为同一情况
 * 其次应当考虑两乘数首位不能为0的情况
 * 最后还要注意得到的结果一定是四位数
 * <p>
 * 后面做类似题最好把每种情况打印出来看一下
 */
public class Q3神奇算式 {
    static int ans = 0;

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j != i) {
                    for (int k = 0; k < 10; k++) {
                        if (k != i && k != j) {
                            for (int l = 0; l < 10; l++) {
                                if (l != i && l != j && l != k) {
                                    if (j != 0) {
                                        int res = i * (j * 100 + k * 10 + l);
                                        if (check(res, new int[]{i, j, k, l})) {
                                            // System.out.printf("%d * %d = %d\n", i, j * 100 + k * 10 + l, res);
                                            ans++;
                                        }
                                    }
                                    if (k != 0) {
                                        int left = i * 10 + j;
                                        int right = k * 10 + l;
                                        int res = left * right;
                                        if (left < right && check(res, new int[]{i, j, k, l})) {
                                            // System.out.printf("%d * %d = %d\n", left, right, res);
                                            ans++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }

    private static boolean check(int res, int[] nums) {
        if (res < 1000) {
            return false;
        }
        int[] tmp = new int[4];
        int idx = 0;
        while (idx < 4) {
            tmp[idx++] = res % 10;
            res /= 10;
        }
        Arrays.sort(tmp);
        Arrays.sort(nums);
        for (int i = 0; i < 4; i++) {
            if (tmp[i] != nums[i]) {
                return false;
            }
        }
        return true;
    }
}
