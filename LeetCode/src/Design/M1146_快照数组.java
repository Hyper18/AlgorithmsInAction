package Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2024/04/26
 * @file M1146_快照数组.java
 * <p>
 * 思路
 * 二分
 * <p>
 * 待回看
 */
public class M1146_快照数组 {
    class SnapshotArray {
        private int snapId;
        private Map<Integer, List<int[]>> his;

        public SnapshotArray(int length) {
            this.snapId = 0;
            this.his = new HashMap<>();
        }

        public void set(int index, int val) {
            his.computeIfAbsent(index, k -> new ArrayList<>()).add(new int[]{snapId, val});
        }

        public int snap() {
            return snapId++;
        }

        public int get(int index, int snap_id) {
            if (!his.containsKey(index)) {
                return 0;
            }
            List<int[]> snap = his.get(index);
            int j = binarySearch(snap, snap_id);
            return j < 0 ? 0 : snap.get(j)[1];
        }

        private int binarySearch(List<int[]> s, int x) {
            int low = -1, high = s.size();
            while (low + 1 < high) {
                int mid = low + ((high - low) >> 1);
                if (s.get(mid)[0] <= x) {
                    low = mid;
                } else {
                    high = mid;
                }
            }

            return low;
        }
    }

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
}
