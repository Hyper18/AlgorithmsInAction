package String;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2022/11/03
 * <p>
 * 思路
 * 1. 暴力
 * 2. DP
 * （1）状态表示
 * 集合：f[i]为seq到第i个位置时，所能与word连续重复匹配的最大值
 * 属性：Max
 * （2）状态计算
 * f[i] = f[i - n2] + 1
 */
public class M1668_最大重复子字符串 {
    public int maxRepeating(String seq, String word) {
        int n1 = seq.length(), n2 = word.length();
        int times = n1 / n2;
        if (times <= 0) {
            return 0;
        }

        int ans = 0;
        String cur = word;
        for (int i = 1; i <= times; i++) {
            if (seq.contains(cur)) {
                ans++;
            }
            cur += word;
        }

        return ans;
    }

    public int maxRepeating2(String seq, String word) {
        int n1 = seq.length(), n2 = word.length();
        int times = n1 / n2;
        if (times <= 0) {
            return 0;
        }

        int[] f = new int[n1];
        for (int i = n2 - 1; i < n1; i++) {
            boolean flag = true;
            for (int j = 0; j < n2; j++) {
                if (seq.charAt(i - n2 + j + 1) != word.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                f[i] = (i == n2 - 1 ? 0 : f[i - n2]) + 1;
            }
        }

        return Arrays.stream(f).max().getAsInt();
    }
}
