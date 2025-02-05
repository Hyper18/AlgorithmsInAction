package String;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2023/08/15
 * @file M833_字符串中的查找与替换.java
 * <p>
 * 思路
 * 模拟
 */
public class M833_字符串中的查找与替换 {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length();
        String[] ss = new String[n];
        int[] len = new int[n];
        Arrays.fill(len, 1);
        for (int i = 0; i < indices.length; i++) {
            int idx = indices[i];
            if (s.startsWith(sources[i], idx)) {
                ss[idx] = targets[i];
                len[idx] = sources[i].length();
            }
        }
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < n; i += len[i]) {
            sb.append(ss[i] == null ? s.charAt(i) : ss[i]);
        }

        return sb.toString();
    }
}
