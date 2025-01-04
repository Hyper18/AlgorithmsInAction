package Design;

import java.util.TreeMap;

/**
 * @author Hyperspace
 * @date 2025/01/04
 * @file M732_我的日程安排表III.java
 */
public class M732_我的日程安排表III {
    class MyCalendarThree {
        private TreeMap<Integer, Integer> mp;

        public MyCalendarThree() {
            mp = new TreeMap<>();
        }

        public int book(int startTime, int endTime) {
            mp.merge(startTime, 1, Integer::sum);
            mp.merge(endTime, -1, Integer::sum);
            int ans = 0, cnt = 0;
            for (int v : mp.values()) {
                cnt += v;
                ans = Math.max(ans, cnt);
            }

            return ans;
        }
    }
}
