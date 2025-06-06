package String;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Hyperspace
 * @date 2025/06/06
 * @file M2434_使用机器人打印字典序最小的字符串.java
 * <p>
 * 思路
 * 模拟，贪心
 * 核心在于如何动态维护当前的最小元素
 * 开一个suf数组维护最小后缀和
 */
public class M2434_使用机器人打印字典序最小的字符串 {
    public String robotWithString(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        char[] suf = new char[n + 1];
        suf[n] = Character.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            suf[i] = (char) Math.min(suf[i + 1], cs[i]);
        }
        StringBuilder res = new StringBuilder();
        Deque<Character> stk = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            stk.push(cs[i]);
            while (!stk.isEmpty() && stk.peek() <= suf[i + 1]) {
                res.append(stk.pop());
            }
        }

        return res.toString();
    }
}
