package DP;

/**
 * @author Hyper
 * @date 2024/08/28
 * @file M3144_分割字符频率相等的最少子字符串.java
 * <p>
 * 思路
 * DP
 * 对于到第i位的字符串，每一个字符都构成一个平衡子字符串，合i+1个
 * 统计每种字符出现的次数
 * 满足check条件则
 * 1) j == 0
 * f[i] = 1
 * 2) j != 0
 * f[i] = min(f[i], f[j - 1] + 1)
 */
public class M3144_分割字符频率相等的最少子字符串2 {
    int[] freq;

    public int minimumSubstringsInPartition(String s) {
        int n = s.length();
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = i + 1;
        }
        for (int i = 0; i < n; i++) {
            freq = new int[26];
            int size = 0;
            for (int j = i; j >= 0; j--) {
                if (++freq[s.charAt(j) - 'a'] == 1) {
                    size++;
                }
                if (check(i - j + 1, size)) {
                    f[i] = j == 0 ? 1 : Math.min(f[i], f[j - 1] + 1);
                }
            }
        }

        return f[n - 1];
    }

    private boolean check(int len, int size) {
        if (len % size != 0) {
            return false;
        }
        int cnt = len / size;
        for (int v : freq) {
            if (v > 0 && v != cnt) {
                return false;
            }
        }

        return true;
    }
}
