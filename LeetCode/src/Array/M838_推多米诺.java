package Array;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2025/05/02
 * @file M838_推多米诺.java
 * <p>
 * 思路
 * 模拟
 * 分类讨论如下：
 * 1. 左端和右端均向右倒
 * 2. 左端和右端均向左倒
 * 3. 左端和右端均向中间倒
 */
public class M838_推多米诺 {
    public String pushDominoes(String dominoes) {
        char[] cs = ("L" + dominoes + "R").toCharArray();
        int n = cs.length;
        for (int l = 0, r = 1; r < n; r++) {
            if (cs[r] == '.') {
                continue;
            }
            if (cs[l] == 'R' && cs[r] == 'R') {
                for (int k = l + 1; k < r; k++) {
                    cs[k] = 'R';
                }
            } else if (cs[l] == 'L' && cs[r] == 'L') {
                for (int k = l + 1; k < r; k++) {
                    cs[k] = 'L';
                }
            } else if (cs[l] == 'R' && cs[r] == 'L') {
                int i = l + 1, j = r - 1;
                while (i < j) {
                    cs[i++] = 'R';
                    cs[j--] = 'L';
                }
            }
            l = r;
        }

        return new String(cs).substring(1, n - 1);
    }

    public String pushDominoes2(String dominoes) {
        char[] cs = ("L" + dominoes + "R").toCharArray();
        int n = cs.length;
        for (int l = 0, r = 1; r < n; r++) {
            if (cs[r] == '.') {
                continue;
            }
            if (cs[l] == cs[r]) {
                Arrays.fill(cs, l + 1, r, cs[r]);
            } else if (cs[r] == 'L') {
                Arrays.fill(cs, l + 1, (l + r + 1) / 2, 'R');
                Arrays.fill(cs, (l + r) / 2 + 1, r, 'L');
            }
            l = r;
        }

        return new String(cs).substring(1, n - 1);
    }
}
