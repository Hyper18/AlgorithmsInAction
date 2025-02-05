package String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Hyper
 * @date 2024/09/25
 * @file M2306_公司命名.java
 * <p>
 * 思路
 * 模拟
 * 按首字母去交集，有次序关系故再乘2
 */
public class M2306_公司命名 {
    public long distinctNames(String[] ideas) {
        Set<String>[] st = new HashSet[26];
        Arrays.setAll(st, e -> new HashSet<>());
        for (String s : ideas) {
            st[s.charAt(0) - 'a'].add(s.substring(1));
        }
        long ans = 0;
        for (int i = 1; i < 26; i++) {
            for (int j = 0; j < i; j++) {
                int cnt = 0;
                for (String s : st[i]) {
                    if (st[j].contains(s)) {
                        cnt++;
                    }
                }
                ans += (long) (st[i].size() - cnt) * (st[j].size() - cnt);
            }
        }

        return ans << 1;
    }
}
