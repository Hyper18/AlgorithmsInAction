package Stack_Queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Hyperspace
 * @date 2022/10/21，2023/10/07
 * <p>
 * 思路
 * 单调栈，复杂度O(n)
 * 使用pair<int, int>存储索引、股价
 * 问题转化为每次next时，找下标差
 */
public class M901_股票价格跨度 {
    class StockSpanner {
        Deque<int[]> stk;
        int idx;

        public StockSpanner() {
            stk = new ArrayDeque<>();
            stk.push(new int[]{-1, Integer.MAX_VALUE});
            idx = -1;
        }

        public int next(int price) {
            idx++;
            while (price >= stk.peek()[1]) {
                stk.pop();
            }
            int ans = idx - stk.peek()[0];
            stk.push(new int[]{idx, price});

            return ans;
        }
    }

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
}
