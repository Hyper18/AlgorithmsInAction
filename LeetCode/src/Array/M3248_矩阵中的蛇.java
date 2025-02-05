package Array;

import java.util.List;

/**
 * @author Hyper
 * @date 2024/11/21
 * @file M3248_矩阵中的蛇.java
 */
public class M3248_矩阵中的蛇 {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = i * n + j;
            }
        }
        int x = 0, y = 0;
        for (String command : commands) {
            switch (command) {
                case "UP":
                    x -= 1;
                    break;
                case "DOWN":
                    x += 1;
                    break;
                case "LEFT":
                    y -= 1;
                    break;
                case "RIGHT":
                    y += 1;
                    break;
            }
        }

        return grid[x][y];
    }

    public int finalPositionOfSnake2(int n, List<String> commands) {
        int x = 0, y = 0;
        for (String command : commands) {
            switch (command) {
                case "UP":
                    x -= 1;
                    break;
                case "DOWN":
                    x += 1;
                    break;
                case "LEFT":
                    y -= 1;
                    break;
                case "RIGHT":
                    y += 1;
                    break;
            }
        }

        return x * n + y;
    }
}
