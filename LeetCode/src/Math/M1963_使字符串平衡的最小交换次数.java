package Math;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Hyper
 * @date 2025/03/17
 * @file M1963_使字符串平衡的最小交换次数.java
 * <p>
 * 思路
 * 1. 模拟
 * 栈的使用最好用Deque代替Stack
 * 依次遍历，并将元素存入栈中
 * 如果此时的括号匹配，出栈
 * 最后寻找规律：
 * 当括号为 ][       时，结果为 1
 * 当括号为 ]][[     时，结果为 1
 * 当括号为 ]]][[[   时，结果为 2
 * 当括号为 ]]]][[[[ 时，结果为 2
 * 设当前栈元素个数为 k，则有 ans = (k + 2) / 4
 * 2. 数学
 * 简化上述规律，去掉栈
 */
public class M1963_使字符串平衡的最小交换次数 {
    public int minSwaps(String s) {
        char[] cs = s.toCharArray();
        Deque<Character> stk = new ArrayDeque<>();
        for (char c : cs) {
            if (!stk.isEmpty() && stk.peek() == '[' && c == ']') {
                stk.pop();
            } else {
                stk.push(c);
            }
        }

        return (stk.size() + 2) / 4;
    }

    public int minSwaps2(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                cnt++;
            } else if (cnt > 0) {
                cnt--;
            }
        }

        return (cnt + 1) / 2;
    }
}
