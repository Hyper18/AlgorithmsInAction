package Array;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2022/11/19
 * @file M1732_找到最高海拔.java
 * <p>
 * 思路
 * 1. gain数组存储前缀和，找规律
 * gain[i] = h[i + 1] - h[i]
 * gain[i+1] = h[i + 2] - h[i + 1]
 * gain[i] + gain[i + 1] = h[i + 2] - h[i]
 * sum(gain) = h[n + 1] - h[0] = h[n + 1]
 * <p>
 * h[0] = 0
 * h[1] = gain[0]
 * h[2] = h[1] + gain[1]
 * <p>
 * 2. 优化
 * 空间上只需要记录当前状态，复杂度O(1)
 */
public class M1732_找到最高海拔 {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] res = new int[n + 1];
        res[0] = 0;
        for (int i = 1; i <= n; i++) {
            res[i] = res[i - 1] + gain[i - 1];
        }

        return Arrays.stream(res).max().getAsInt();
    }

    public int largestAltitude2(int[] gain) {
        int n = gain.length;
        int ans = 0, h = 0;
        for (int i = 0; i < n; i++) {
            h += gain[i];
            if (h > ans) {
                ans = h;
            }
        }

        return ans;
    }
}
