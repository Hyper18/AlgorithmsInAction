package Stack_Queue;

import java.util.*;

/**
 * @author Hyper
 * @date 2022/02/20
 * <p>
 * 思路
 * 一是考虑左右括号的映射关系
 * 二是还需对最后是否全部配对作检查（是否栈空）
 * 优化，不满足为偶数直接ret false
 * <p>
 * 注意使用Deque作为栈，其栈底在右侧
 */
public class Q20_有效的括号 {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Stack<Character> stk = new Stack<>();
        for (char c : s.toCharArray()) {
            if (pairs.containsKey(c)) {
                if (stk.isEmpty() || !stk.peek().equals(pairs.get(c))) {
                    return false;
                }
                stk.pop();
            } else {
                stk.push(c);
            }
        }
        return stk.isEmpty();
    }

    public boolean isValid2(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stk = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (pairs.containsKey(c)) {
                if (stk.isEmpty() || !stk.peek().equals(pairs.get(c))) {
                    return false;
                }
                stk.pop();
            } else {
                stk.push(c);
            }
        }
        return stk.isEmpty();
    }

    public boolean isValid3(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stk = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (pairs.containsKey(c)) {
                if (stk.isEmpty() || !stk.getLast().equals(pairs.get(c))) {
                    return false;
                }
                stk.pollLast();
            } else {
                stk.addLast(c);
            }
        }

        return stk.isEmpty();
    }
}
