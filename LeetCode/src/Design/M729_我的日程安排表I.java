package Design;

import java.util.TreeMap;

/**
 * @author Hyperspace
 * @date 2025/01/02
 * @file M729_我的日程安排表I.java
 * <p>
 * 思路
 * 排序
 */
public class M729_我的日程安排表I {
    class MyCalendar {
        private TreeMap<Integer, Integer> mp;

        public MyCalendar() {
            mp = new TreeMap<>();
        }

        public boolean book(int startTime, int endTime) {
            if ((mp.floorEntry(startTime) != null && mp.floorEntry(startTime).getValue() > startTime) || (mp.ceilingEntry(startTime) != null && mp.ceilingEntry(startTime).getKey() < endTime)) {
                return false;
            }

            mp.put(startTime, endTime);
            return true;
        }
    }

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */
}
