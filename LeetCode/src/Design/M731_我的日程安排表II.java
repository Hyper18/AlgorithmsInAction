package Design;

import java.util.TreeMap;

/**
 * @author Hyperspace
 * @date 2025/01/03
 * @file M731_我的日程安排表II.java
 * <p>
 * 思路
 * 差分数组
 */
public class M731_我的日程安排表II {
    class MyCalendarTwo {
        private TreeMap<Integer, Integer> mp;

        public MyCalendarTwo() {
            mp = new TreeMap<>();
        }

        public boolean book(int startTime, int endTime) {
            mp.merge(startTime, 1, Integer::sum);
            mp.merge(endTime, -1, Integer::sum);
            int cnt = 0;
            for (int v : mp.values()) {
                cnt += v;
                if (cnt > 2) {
                    mp.merge(startTime, -1, Integer::sum);
                    if (mp.get(startTime) == 0) {
                        mp.remove(startTime);
                    }
                    mp.merge(endTime, 1, Integer::sum);
                    if (mp.get(endTime) == 0) {
                        mp.remove(endTime);
                    }

                    return false;
                }
            }

            return true;
        }
    }

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */
}
