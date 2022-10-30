package BackTracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Hyperspace
 * @date 2022/10/30
 * <p>
 * 思路
 * 1. 回溯
 * 2. bfs
 * 复杂度均为O(n * 2^n)
 * <p>
 * 注：位运算的简化，以A、a为例
 * 01000010 65
 * 00100000 XOR 32
 * 01100010
 * 2+32+64 = 97
 * 同理
 * 01100010
 * 00100000
 * 01000010
 */
public class M784_字母大小写全排列 {
    List<String> res = new ArrayList<>();
    int n;

    public List<String> letterCasePermutation(String s) {
        n = s.length();
        backtrack(s.toCharArray(), 0);

        return res;
    }

    private void backtrack(char[] s, int idx) {
        while (idx < n && Character.isDigit(s[idx])) {
            idx++;
        }
        if (idx == n) {
            res.add(new String(s));
            return;
        }
//        s[idx] = Character.isLowerCase(s[idx]) ? Character.toUpperCase(s[idx]) : Character.toLowerCase(s[idx]);
        s[idx] ^= 32;
        backtrack(s, idx + 1);
//        s[idx] = Character.isLowerCase(s[idx]) ? Character.toUpperCase(s[idx]) : Character.toLowerCase(s[idx]);
        s[idx] ^= 32;
        backtrack(s, idx + 1);
    }

    public List<String> letterCasePermutation2(String s) {
        int n = s.length();
        List<String> res = new ArrayList<>();
        Queue<StringBuilder> q = new ArrayDeque<>();
        q.offer(new StringBuilder());

        while (!q.isEmpty()) {
            StringBuilder sb = q.peek();
            if (n == sb.length()) {
                res.add(sb.toString());
                q.poll();
            } else {
                int pos = sb.length();
                if (Character.isLetter(s.charAt(pos))) {
                    StringBuilder ne = new StringBuilder(sb);
                    // 注意转换类型
                    ne.append((char) (s.charAt(pos) ^ 32));
                    q.offer(ne);
                }
                sb.append(s.charAt(pos));
            }
        }

        return res;
    }
}
