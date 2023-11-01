package Design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Hyperspace
 * @date 2023/10/08
 * @file M2034_股票价格波动.java
 * <p>
 * 思路
 * hash + 有序集合
 */
public class M2034_股票价格波动 {
    class StockPrice {
        Map<Integer, Integer> mp;
        TreeMap<Integer, Integer> tm;
        int ts;

        public StockPrice() {
            mp = new HashMap<>();
            tm = new TreeMap<>();
        }

        public void update(int timestamp, int price) {
            if (mp.containsKey(timestamp)) {
                int last = mp.get(timestamp);
                if (tm.merge(last, -1, Integer::sum) == 0) {
                    tm.remove(last);
                }
            }
            mp.put(timestamp, price);
            tm.merge(price, 1, Integer::sum);
            if (timestamp > ts) {
                ts = timestamp;
            }
        }

        public int current() {
            return mp.get(ts);
        }

        public int maximum() {
            return tm.lastKey();
        }

        public int minimum() {
            return tm.firstKey();
        }
    }

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
}
