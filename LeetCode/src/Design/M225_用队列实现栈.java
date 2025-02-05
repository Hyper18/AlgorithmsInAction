package Design;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Hyper
 * @date 2024/03/03
 * @file M225_用队列实现栈.java
 * <p>
 * 思路
 * 模拟
 */
public class M225_用队列实现栈 {
    class MyStack {
        Queue<Integer> q1, q2;

        public MyStack() {
            q1 = new ArrayDeque<>();
            q2 = new ArrayDeque<>();
        }

        public void push(int x) {
            q2.offer(x);
            while (!q1.isEmpty()) {
                q2.offer(q1.poll());
            }
            Queue<Integer> t = q1;
            q1 = q2;
            q2 = t;
        }

        public int pop() {
            return q1.poll();
        }

        public int top() {
            return q1.peek();
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
