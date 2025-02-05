package Stack_Queue;

import java.util.Stack;

/**
 * @author Hyper
 * @date 2022/02/20
 */
public class Q232_用栈实现队列 {
    class MyQueue {
        private Stack<Integer> in;
        private Stack<Integer> out;

        public MyQueue() {
            in = new Stack();
            out = new Stack();
        }

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.pop();
        }

        public int peek() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.peek();
        }

        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }
    }
}
