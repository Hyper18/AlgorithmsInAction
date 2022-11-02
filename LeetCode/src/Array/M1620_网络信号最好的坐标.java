package Array;

/**
 * @author Hyperspace
 * @date 2022/11/02
 * <p>
 * 思路
 * 模拟
 * 维护一个变量val记录信号的最大值，x、y记录坐标
 * <p>
 * 有点坑。。题目指明坐标在塔距离 radius 以内
 * 但实际在边界上也符合
 */
public class M1620_网络信号最好的坐标 {
    final int N = 110;
    int[][] g = new int[N][N];

    public int[] bestCoordinate(int[][] towers, int r) {
        int x = 0, y = 0, val = 0;
        for (int[] tower : towers) {
            int a = tower[0], b = tower[1], q = tower[2];
            for (int i = Math.max(0, a - r); i <= a + r; i++) {
                for (int j = Math.max(0, b - r); j <= b + r; j++) {
                    double d = Math.sqrt((a - i) * (a - i) + (b - j) * (b - j));
                    // 小于等于均符合条件
                    if (d > r) {
                        continue;
                    }
                    g[i][j] += Math.floor(q / (1 + d));
                    if (g[i][j] > val) {
                        x = i;
                        y = j;
                        val = g[i][j];
                    } else if (g[i][j] == val && (i < x || (i == x && j < y))) {
                        // 筛选字典序最小的结果
                        x = i;
                        y = j;
                    }
                }
            }
        }

        return new int[]{x, y};
    }
}
