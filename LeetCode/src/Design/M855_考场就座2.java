package Design;

import java.util.TreeSet;

/**
 * @author Hyperspace
 * @date 2024/12/23
 * @file M855_考场就座.java
 * <p>
 * 思路
 * 贪心+SWM+小根堆
 */
public class M855_考场就座2 {
    class ExamRoom {
        private TreeSet<Integer> isSeated;
        private int n;

        public ExamRoom(int n) {
            isSeated = new TreeSet<>();
            this.n = n;
        }

        public int seat() {
            int p = 0;
            if (!isSeated.isEmpty()) {
                int l = -1, mx = isSeated.first();
                for (int r : isSeated) {
                    if (l != -1) {
                        int d = (r - l) / 2;
                        if (d > mx) {
                            mx = d;
                            p = l + d;
                        }
                    }
                    l = r;
                }
                if (n - 1 - isSeated.last() > mx) {
                    p = n - 1;
                }
            }
            isSeated.add(p);

            return p;
        }

        public void leave(int p) {
            isSeated.remove(p);
        }
    }
}
