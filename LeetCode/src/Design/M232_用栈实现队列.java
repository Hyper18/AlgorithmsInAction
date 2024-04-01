package Design;

import java.util.Stack;

/**
 * @author Hyperspace
 * @date 2024/03/04
 * @file M232_用栈实现队列.java
 * <p>
 * 思路
 * 模拟
 */
public class M232_用栈实现队列 {
    class MyQueue {
        Stack<Integer> stk1, stk2;

        public MyQueue() {
            stk1 = new Stack<>();
            stk2 = new Stack<>();
        }

        public void push(int x) {
            stk1.push(x);
        }

        public int pop() {
            swap(stk1, stk2);
            return stk2.pop();
        }

        public int peek() {
            swap(stk1, stk2);
            return stk2.peek();
        }

        public boolean empty() {
            return stk1.isEmpty() && stk2.isEmpty();
        }

        private void swap(Stack<Integer> in, Stack<Integer> out) {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
