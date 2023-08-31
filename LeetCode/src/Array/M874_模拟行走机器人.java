package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hyperspace
 * @date 2023/07/19
 * @file M874_模拟行走机器人.java
 * <p>
 * 思路
 * 模拟
 * 注意题干给定初始朝北，顺时针转动
 * and测试用例卡障碍放(0,0)，一开始还特判了，乐
 */
public class M874_模拟行走机器人 {
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    final int N = (int) 6e4 + 5;

    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0, d = 0, ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int[] o : obstacles) {
            set.add(o[0] * N + o[1]);
        }
        for (int c : commands) {
            if (c < 0) {
                d = c == -1 ? (d + 1) % 4 : (d + 3) % 4;
                continue;
            }
            for (int j = 0; j < c; j++) {
                int nx = x + dirs[d][0], ny = y + dirs[d][1];
                if (!set.contains(nx * N + ny)) {
                    x = nx;
                    y = ny;
                    ans = Math.max(ans, x * x + y * y);
                }
            }
        }

        return ans;
    }
}
