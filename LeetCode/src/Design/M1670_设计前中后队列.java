package Design;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Hyper
 * @date 2023/11/28
 * @file M1670_设计前中后队列.java
 * <p>
 * 思路
 * 双端队列
 */
public class M1670_设计前中后队列 {
    class FrontMiddleBackQueue {
        Deque<Integer> front, back;

        public FrontMiddleBackQueue() {
            front = new ArrayDeque<>();
            back = new ArrayDeque<>();
        }

        private void adjust() {
            if (front.size() > back.size()) {
                back.addFirst(front.pollLast());
            } else if (front.size() + 1 < back.size()) {
                front.addLast(back.pollFirst());
            }
        }

        public void pushFront(int val) {
            front.addFirst(val);
            adjust();
        }

        public void pushMiddle(int val) {
            if (front.size() >= back.size()) {
                back.addFirst(val);
            } else {
                front.addLast(val);
            }
        }

        public void pushBack(int val) {
            back.addLast(val);
            adjust();
        }

        public int popFront() {
            if (back.isEmpty()) {
                return -1;
            }
            int val = front.isEmpty() ? back.pollFirst() : front.pollFirst();
            adjust();

            return val;
        }

        public int popMiddle() {
            if (back.isEmpty()) {
                return -1;
            }

            return front.size() == back.size() ? front.pollLast() : back.pollFirst();
        }

        public int popBack() {
            if (back.isEmpty()) {
                return -1;
            }
            int val = back.pollLast();
            adjust();

            return val;
        }
    }

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
}
