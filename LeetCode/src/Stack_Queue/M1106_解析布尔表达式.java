package Stack_Queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Hyper
 * @date 2022/11/05
 * 思路
 * 模拟
 */
public class M1106_解析布尔表达式 {
    public boolean parseBoolExpr(String exp) {
        Deque<Character> nums = new ArrayDeque<>();
        Deque<Character> ops = new ArrayDeque<>();

        for (char c : exp.toCharArray()) {
            if (c == ',') {
                continue;
            }
            if (c == 't' || c == 'f') {
                // 入数栈
                nums.addLast(c);
            }
            if (c == '|' || c == '&' || c == '!') {
                // 入操作栈
                ops.addLast(c);
            }
            if (c == '(') {
                // 置标记位/
                nums.addLast('/');
            }
            if (c == ')') {
                char op = ops.pollLast(), cur = ' ';
                while (!nums.isEmpty() && nums.peekLast() != '/') {
                    char top = nums.pollLast();
                    cur = cur == ' ' ? top : cal(top, cur, op);
                }
                // 取反
                if (op == '!') {
                    cur = cur == 't' ? 'f' : 't';
                }

                // 去标记位/
                nums.pollLast();
                nums.addLast(cur);
            }
        }

        return nums.peekLast() == 't';
    }

    private char cal(char a, char b, char op) {
        boolean x = a == 't', y = b == 't';
        boolean ans = op == '|' ? x | y : x & y;

        return ans ? 't' : 'f';
    }
}
