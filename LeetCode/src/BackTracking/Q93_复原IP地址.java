package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2025/05/05
 * @file Q93_复原IP地址.java
 * <p>
 * 思路
 * 回溯
 * <p>
 * 题干隐含条件：
 * 1) 递归出口需要集齐IP的4部分
 * 2) 端口区间在 [0, 255]
 * 3) 需要处理前导零
 */
public class Q93_复原IP地址 {
    private List<String> res = new ArrayList<>(), path = new ArrayList<>();
    private char[] s;

    public List<String> restoreIpAddresses(String s) {
        this.s = s.toCharArray();
        backtrack(0);

        return res;
    }

    private void backtrack(int i) {
        if (path.size() == 4) {
            if (i == s.length) {
                res.add(String.join(".", path));
            }
            return;
        }
        for (int j = i; j < Math.min(s.length, i + 3); j++) {
            if (j != i && s[i] == '0') {
                break;
            }
            String ss = new String(s, i, j - i + 1);
            int x = Integer.parseInt(ss);
            if (x < 0 || x > 255) {
                continue;
            }
            path.add(ss);
            backtrack(j + 1);
            path.remove(path.size() - 1);
        }
    }
}
