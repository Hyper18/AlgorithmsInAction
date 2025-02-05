package SWM;

/**
 * @author Hyper
 * @date 2024/11/12
 * @file M3258_统计满足K约束的子字符串数量I.java
 * <p>
 * 思路
 * 1. 模拟 O(n^2)
 * 2. SWM
 * 3. 位运算优化
 * 假设当前值为x
 * 由于字符 0 的 ASCII 值是偶数，字符 1 的 ASCII 值是奇数
 * (1) ascii(x) AND 1 = 0 x为偶数
 * (2) ascii(x) AND 1 = 1 x为奇数
 */
public class M3258_统计满足K约束的子字符串数量I {
    public int countKConstraintSubstrings(String s, int k) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int[] cnt = new int[2];
            cnt[s.charAt(i) - '0']++;
            ans++;
            for (int j = i + 1; j < n; j++) {
                cnt[s.charAt(j) - '0']++;
                if (cnt[0] > k && cnt[1] > k) {
                    break;
                }
                ans++;
            }
        }

        return ans;
    }

    public int countKConstraintSubstrings2(String s, int k) {
        int n = s.length();
        int[] cnt = new int[2];
        int ans = 0;
        for (int l = 0, r = 0; r < n; r++) {
            cnt[s.charAt(r) - '0']++;
            while (cnt[0] > k && cnt[1] > k) {
                cnt[s.charAt(l++) - '0']--;
            }
            ans += r - l + 1;
        }

        return ans;
    }

    public int countKConstraintSubstrings3(String s, int k) {
        int n = s.length();
        int[] cnt = new int[2];
        int ans = 0;
        for (int l = 0, r = 0; r < n; r++) {
            cnt[s.charAt(r) & 1]++;
            while (cnt[0] > k && cnt[1] > k) {
                cnt[s.charAt(l++) & 1]--;
            }
            ans += r - l + 1;
        }

        return ans;
    }
}
