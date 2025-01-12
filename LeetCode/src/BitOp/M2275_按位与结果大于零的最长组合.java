package BitOp;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2025/01/12
 * @file M2275_按位与结果大于零的最长组合.java
 */
public class M2275_按位与结果大于零的最长组合 {
    public int largestCombination(int[] candidates) {
        int mx = Arrays.stream(candidates).max().getAsInt(), n = 32 - Integer.numberOfLeadingZeros(mx);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int c : candidates) {
                cnt += c >> i & 1;
            }
            ans = Math.max(ans, cnt);
        }

        return ans;
    }
}
