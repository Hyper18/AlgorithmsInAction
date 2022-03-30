package Y2017A;

/**
 * @author Hyperspace
 * @date 2022/03/29
 * <p>
 * 标题：Y2017A.迷宫
 * <p>
 * X星球的一处迷宫游乐场建在某个小山坡上。
 * 它是由10x10相互连通的小房间组成的。
 * <p>
 * 房间的地板上写着一个很大的字母。
 * 我们假设玩家是面朝上坡的方向站立，则：
 * L表示走到左边的房间，
 * R表示走到右边的房间，
 * U表示走到上坡方向的房间，
 * D表示走到下坡方向的房间。
 * <p>
 * X星球的居民有点懒，不愿意费力思考。
 * 他们更喜欢玩运气类的游戏。这个游戏也是如此！
 * <p>
 * 开始的时候，直升机把100名玩家放入一个个小房间内。
 * 玩家一定要按照地上的字母移动。
 * <p>
 * 迷宫地图如下：
 * ------------
 * UDDLUULRUL
 * UURLLLRRRU
 * RRUURLDLRD
 * RUDDDDUUUU
 * URUDLLRRUU
 * DURLRLDLRL
 * ULLURLLRDU
 * RDLULLRDDD
 * UUDDUDUDLL
 * ULRDLUURRR
 * ------------
 * <p>
 * 请你计算一下，最后，有多少玩家会走出迷宫?
 * 而不是在里边兜圈子。
 * <p>
 * 答案是31，算出是32
 * 待回看
 */
public class Q1迷宫 {
    private static final int SIZE = 10;
    private static char[][] grid = new char[SIZE][SIZE];
    private static boolean[][] vis = new boolean[SIZE][SIZE];
    static int ans;

    public static void main(String[] args) {
        String[] str = new String[]{"UDDLUULRUL", "UURLLLRRRU", "RRUURLDLRD", "RUDDDDUUUU", "URUDLLRRUU", "DURLRLDLRL", "ULLURLLRDU", "RDLULLRDDD", "UUDDUDUDLL", "ULRDLUURRR"};

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = str[i].charAt(j);
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                vis = new boolean[SIZE][SIZE];
                if (dfs(i, j)) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

    private static boolean dfs(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return true;
        }
        if (vis[x][y]) {
            return false;
        }
        vis[x][y] = true;
        switch (grid[x][y]) {
            case 'L':
                return dfs(x - 1, y);
            case 'U':
                return dfs(x, y + 1);
            case 'R':
                return dfs(x + 1, y);
            case 'D':
                return dfs(x, y - 1);
            default:
                return false;
        }
    }
}
