package BackTracking;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2024/08/19
 * @file M552_学生出勤记录II.java
 * <p>
 * 思路
 * 1. 朴素全排列，这数据量必TLE
 * 2. 全排列剪枝 TLE
 * 3. +memo 744ms。。
 */
public class M552_学生出勤记录II {
    final int N = (int) (1e5 + 10), MOD = (int) (1e9 + 7);
    int[] path = new int[N];
    int n, ans;

    public int checkRecord(int n) {
        this.n = n;
        backtrack(0);
        return ans;
    }

    private void backtrack(int cur) {
        if (cur == n) {
            ans = (ans + 1) % MOD;
            return;
        }
        for (int i = 1; i <= 3; i++) {
            boolean flag = true;
            if (i == 1) {
                for (int j = 0; j < cur; j++) {
                    if (path[j] == 1) {
                        flag = false;
                        break;
                    }
                }
            }
            if (i == 2 && cur >= 2 && path[cur - 1] == 2 && path[cur - 2] == 2) {
                flag = false;
            }
            if (flag) {
                path[cur] = i;
                backtrack(cur + 1);
            }
        }
    }

    public int checkRecord2(int n) {
        this.n = n;
        return backtrack(0, 0, 0);
    }

    private int backtrack(int cur, int cntA, int cntL) {
        int ans = 0;
        if (cur == n) {
            return 1;
        }
        for (int i = 1; i <= 3; i++) {
            int r;
            if (i == 1) {
                if (cntA > 0) {
                    continue;
                }
                r = backtrack(cur + 1, 1, 0);
            } else if (i == 2) {
                if (cntL == 2) {
                    continue;
                }
                r = backtrack(cur + 1, cntA, cntL + 1);
            } else {
                r = backtrack(cur + 1, cntA, 0);
            }
            ans = (ans + r) % MOD;

        }

        return ans;
    }

    int[][][] memo = new int[N][2][3];

    public int checkRecord3(int n) {
        this.n = n;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        return backtrack2(0, 0, 0);
    }

    private int backtrack2(int cur, int cntA, int cntL) {
        int ans = memo[cur][cntA][cntL];
        if (ans > -1) {
            return ans;
        }
        ans = 0;
        if (cur == n) {
            return memo[cur][cntA][cntL] = 1;
        }
        for (int i = 1; i <= 3; i++) {
            int r;
            if (i == 1) {
                if (cntA > 0) {
                    continue;
                }
                r = backtrack(cur + 1, 1, 0);
            } else if (i == 2) {
                if (cntL == 2) {
                    continue;
                }
                r = backtrack(cur + 1, cntA, cntL + 1);
            } else {
                r = backtrack(cur + 1, cntA, 0);
            }
            ans = (ans + r) % MOD;
        }

        return memo[cur][cntA][cntL] = ans;
    }
}
