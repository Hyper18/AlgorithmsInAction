package Array;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2025/06/22
 * @file M2138_将字符串拆分为若干长度为k的组.java
 * <p>
 * 思路
 * 模拟
 */
public class M2138_将字符串拆分为若干长度为k的组 {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        String[] res = new String[(n + k - 1) / k];
        for (int i = 0; i < n; i++) {
            if ((i + 1) * k >= n) {
                char[] t = new char[k];
                for (int j = 0; j < k; j++) {
                    if (i * k + j < n) {
                        t[j] = s.charAt(i * k + j);
                    } else {
                        t[j] = fill;
                    }
                }
                res[i] = new String(t);
                break;
            }
            res[i] = s.substring(i * k, (i + 1) * k);
        }

        return res;
    }

    public String[] divideString2(String s, int k, char fill) {
        int n = s.length();
        String[] res = new String[(n + k - 1) / k];
        for (int i = 0; i < n; i++) {
            if ((i + 1) * k >= n) {
                int len = k - n + i * k;
                char[] t = new char[len];
                Arrays.fill(t, fill);
                res[i] = s.substring(i * k) + new String(t);
                break;
            }
            res[i] = s.substring(i * k, (i + 1) * k);
        }

        return res;
    }
}
