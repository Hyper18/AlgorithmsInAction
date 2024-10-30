package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2024/10/29
 * @file M3211_生成不含相邻零的二进制字符串.java
 * <p>
 * 思路
 * 回溯
 */
public class M3211_生成不含相邻零的二进制字符串 {
    private List<String> res;
    char[] s;
    int n;

    public List<String> validStrings(int n) {
        this.n = n;
        res = new ArrayList<>();
        this.s = new char[n];
        backtrack(0);
        return res;
    }

    private void backtrack(int idx) {
        if (idx == n) {
            res.add(new String(s));
            return;
        }
        s[idx] = '1';
        backtrack(idx + 1);
        if (idx == 0 || s[idx - 1] == '1') {
            s[idx] = '0';
            backtrack(idx + 1);
        }
    }
}
