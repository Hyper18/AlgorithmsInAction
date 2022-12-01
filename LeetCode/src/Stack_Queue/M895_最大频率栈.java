package Stack_Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2022/11/30
 * @file M895_最大频率栈.java
 * <p>
 * 思路
 * 模拟
 */
public class M895_最大频率栈 {
    class FreqStack {
        Map<Integer, Integer> counts;
        Map<Integer, Deque<Integer>> subStk;
        int top;

        public FreqStack() {
            counts = new HashMap<>();
            subStk = new HashMap<>();
            top = 0;
        }

        public void push(int val) {
            counts.put(val, counts.getOrDefault(val, 0) + 1);
            int freq = counts.get(val);
            subStk.putIfAbsent(freq, new ArrayDeque<>());
            subStk.get(freq).push(val);
            top = Math.max(top, freq);
        }

        public int pop() {
            int val = subStk.get(top).peek();
            counts.put(val, counts.get(val) - 1);
            subStk.get(top).pop();
            if (subStk.get(top).isEmpty()) {
                top--;
            }

            return val;
        }
    }

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
}
