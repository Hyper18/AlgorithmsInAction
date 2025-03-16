package String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2025/03/16
 * @file M2272_最大波动的子字符串.java
 * <p>
 * 思路
 * 1. 模拟 TLE 100/138
 * 2. DP 状态机 @灵茶山艾府
 * 转而枚举字母
 * (1) 状态表示
 * 集合：
 * f[i+1][0] 表示以 s[i] 结尾的最大子数组和，包不包含 b 都可以
 * f[i+1][1] 表示以 s[i] 结尾、一定包含 b 的最大子数组和
 * 属性：max
 * (2) 状态计算
 * f[i+1][0] = max(f[i][0],0) + {-1, 0, 1}
 * if s[i] = a then f[i+1][1] = f[i][1] + 1
 * if s[i] = b then f[i+1][1] = f[i+1][0]
 * 3. DP 优化
 * <p>
 * 待回看
 */
public class M2272_最大波动的子字符串 {
    public int largestVariance(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ans = Math.max(ans, count(s.substring(i, j + 1)));
            }
        }

        return ans;
    }

    private int count(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            mp.merge(s.charAt(i), 1, Integer::sum);
        }
        int mx = Integer.MIN_VALUE, mn = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> e : mp.entrySet()) {
            mx = Math.max(e.getValue(), mx);
            mn = Math.min(e.getValue(), mn);
        }

        return mx - mn;
    }

    public int largestVariance2(String s) {
        int ans = 0;
        for (char i = 'a'; i <= 'z'; i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                if (i == j) {
                    continue;
                }
                int st0 = 0, st1 = Integer.MIN_VALUE;
                for (char c : s.toCharArray()) {
                    if (c == i) {
                        st0 = Math.max(st0, 0) + 1;
                        st1++;
                    } else if (c == j) {
                        st0 = st1 = Math.max(st0, 0) - 1;
                    }
                    ans = Math.max(ans, st1);
                }
            }
        }

        return ans;
    }

    private int largestVariance3(String s) {
        int[][] st0 = new int[26][26], st1 = new int[26][26];
        for (int[] row : st1) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        int ans = 0;
        for (char c : s.toCharArray()) {
            c -= 'a';
            for (int i = 0; i < 26; i++) {
                if (i == c) {
                    continue;
                }
                st0[c][i] = Math.max(st0[c][i], 0) + 1;
                st1[c][i]++;
                st1[i][c] = st0[i][c] = Math.max(st0[i][c], 0) - 1;
                ans = Math.max(ans, Math.max(st1[c][i], st1[i][c]));
            }
        }

        return ans;
    }
}
