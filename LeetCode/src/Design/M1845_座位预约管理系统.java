package Design;

import java.util.PriorityQueue;

/**
 * @author Hyper
 * @date 2024/09/30
 * @file M1845_座位预约管理系统.java
 * <p>
 * 思路
 * 优先队列
 */
public class M1845_座位预约管理系统 {
    class SeatManager {
        private PriorityQueue<Integer> seats;

        public SeatManager(int n) {
            seats = new PriorityQueue<>(n);
            for (int i = 1; i <= n; i++) {
                seats.offer(i);
            }
        }

        public int reserve() {
            return seats.poll();
        }

        public void unreserve(int seatNumber) {
            seats.offer(seatNumber);
        }
    }

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
}
