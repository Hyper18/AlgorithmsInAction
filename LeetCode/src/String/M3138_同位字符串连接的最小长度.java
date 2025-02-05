package String;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2024/12/20
 * @file M3138_同位字符串连接的最小长度.java
 * <p>
 * 思路
 * 模拟
 * 核心在于同位字符串中每个字符出现的频数均相同
 * 先从[1, n/2]从小到大枚举因子i
 * 再以i作为t的长度遍历，判断是否均为同位字符串
 */
public class M3138_同位字符串连接的最小长度 {
    private final int N = 26;
    private int[] cnt = new int[N], cur;
    private char[] s;

    public int minAnagramLength(String s) {
        int n = s.length();
        this.s = s.toCharArray();
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0 && check(i)) {
                return i;
            }
        }

        return n;
    }

    private boolean check(int i) {
        for (int j = 0; j < s.length; j += i) {
            cur = new int[N];
            for (int k = j; k < j + i; k++) {
                cur[s[k] - 'a']++;
            }
            if (j > 0 && !Arrays.equals(cnt, cur)) {
                return false;
            }
            cnt = cur;
        }

        return true;
    }
}
