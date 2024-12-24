package Design;

/**
 * @author Hyperspace
 * @date 2024/12/23
 * @file M855_考场就座.java
 * <p>
 * 思路
 * 贪心+SWM
 * <p>
 * 卡116/126 MLE
 * ["ExamRoom","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave"]
 * [[1000000000],[],[0],[],[0],[],[0],[],[0],[],[0]]
 */
public class M855_考场就座 {
    class ExamRoom {
        private boolean[] isSeated;
        private int n;

        public ExamRoom(int n) {
            isSeated = new boolean[n];
            this.n = n;
        }

        public int seat() {
            int[] pos = new int[]{-1, n + 1, 0};
            for (int l = 0; l < n; l++) {
                while (l < n && isSeated[l]) {
                    l++;
                }
                l--;
                int r = l + 1;
                while (r < n && !isSeated[r]) {
                    r++;
                }
                if (pos[2] == 0 && l < 0) {
                    pos = new int[]{0, r, r};
                } else if (r == n && !isSeated[r - 1]) {
                    if (r - 1 - l > pos[2]) {
                        pos = new int[]{n - 1, n + 1, r - 1 - l};
                    }
                } else {
                    int d = (r - l) / 2;
                    if (d > pos[2]) {
                        pos = new int[]{l, r, d};
                    }
                }
                l = r;
            }
            int p;
            if (pos[0] == 0 && pos[1] == pos[0] + pos[2]) {
                p = 0;
            } else if (pos[0] == n - 1 && pos[1] == n + 1) {
                p = n - 1;
            } else {
                p = pos[0] + pos[2];
            }
            isSeated[p] = true;

            return p;
        }

        public void leave(int p) {
            isSeated[p] = false;
        }
    }
}
