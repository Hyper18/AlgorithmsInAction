package Array;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2024/12/15
 * @file M1338_数组大小减半.java
 * <p>
 * 思路
 * 模拟
 */
public class M1338_数组大小减半 {
    public int minSetSize(int[] arr) {
        int n = arr.length, len = Arrays.stream(arr).max().getAsInt();
        int[] cnt = new int[len + 1];
        for (int j : arr) {
            cnt[j]++;
        }
        Arrays.sort(cnt);
        int ans = 0, sum = 0;
        for (int i = len; i >= 0; i--) {
            if (sum >= n / 2) {
                break;
            }
            sum += cnt[i];
            ans++;
        }

        return ans;
    }
}
