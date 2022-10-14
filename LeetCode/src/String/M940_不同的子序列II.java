package String;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2022/10/14
 * <p>
 * 思路
 * DP
 * 1. 状态表示
 * 集合：f[i]表示以字符串中第i位字符为最后一个字符的子序列数目
 * 属性：数目
 * 2. 状态计算
 * f[i] = f[0]+f[1]+⋯f[i−1]
 * <p>
 * last数组用于记录字符串中a-z值的对应下标，用作f数组的idx
 * <p>
 * 待回看
 */
public class M940_不同的子序列II {
    public static final int MOD = (int) 1e9 + 7;

    public int distinctSubseqII(String s) {
        int n = s.length();
        int[] f = new int[n], last = new int[26];
        Arrays.fill(f, 1);
        Arrays.fill(last, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                if (last[j] != -1) {
                    f[i] = (f[i] + f[last[j]]) % MOD;
                }
            }
            last[s.charAt(i) - 'a'] = i;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (last[i] != -1) {
                ans = (ans + f[last[i]]) % MOD;
            }
        }

        return ans;
    }

    public int distinctSebsegII2(String s) {
        int n = s.length();
        int[] f = new int[26];
        for (int i = 0; i < n; i++) {
            int t = 1;
            for (int j = 0; j < 26; j++) {
                t = (t + f[j]) % MOD;
            }
            f[s.charAt(i) - 'a'] = t;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans = (ans + f[i]) % MOD;
        }

        return ans;
    }
}
