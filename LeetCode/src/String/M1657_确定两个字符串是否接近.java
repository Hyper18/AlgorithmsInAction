package String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Hyper
 * @date 2023/11/30
 * @file M1657_确定两个字符串是否接近.java
 * <p>
 * 思路
 * 模拟
 * 整理一下限制条件：
 * 1. 两串必定长度相等
 * 2. 字母出现的先后次序不重要
 * 3. 两串的字母出现频率应是对应的
 * 如：abbcc和aaccb
 */
public class M1657_确定两个字符串是否接近 {
    final int M = 26, N = (int) 1e5 + 7;
    int[] cnt1 = new int[M], cnt2 = new int[M];
    int[] cnt = new int[N];

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int n = word1.length();
        for (int i = 0; i < n; i++) {
            cnt1[word1.charAt(i) - 'a']++;
            cnt2[word2.charAt(i) - 'a']++;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < M; i++) {
            int j = cnt1[i];
            if (j != 0) {
                set.add(i);
                cnt[j]++;
            }
        }
        for (int i = 0; i < M; i++) {
            int j = cnt2[i];
            if (j != 0 && (!set.contains(i) || --cnt[j] < 0)) {
                return false;
            }
        }

        return true;
    }

    public boolean closeStrings2(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int n = word1.length();
        for (int i = 0; i < n; i++) {
            cnt1[word1.charAt(i) - 'a']++;
            cnt2[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < M; i++) {
            if ((cnt1[i] != 0 && cnt2[i] == 0) || (cnt1[i] == 0 && cnt2[i] != 0)) {
                return false;
            }
        }
        Arrays.sort(cnt1);
        Arrays.sort(cnt2);
        for (int i = 0; i < M; i++) {
            if (cnt1[i] != cnt2[i]) {
                return false;
            }
        }

        return true;
    }
}
