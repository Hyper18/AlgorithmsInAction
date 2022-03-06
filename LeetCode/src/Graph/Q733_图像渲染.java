package Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Hyperspace
 * @date 2022/03/06
 */
public class Q733_图像渲染 {
    private static int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int curColor = image[sr][sc];
        if (curColor == newColor) {
            return image;
        } else {
            dfs(image, sr, sc, curColor, newColor);
        }

        return image;
    }

    private static void dfs(int[][] img, int row, int col, int color, int newColor) {
        if (img[row][col] != color) {
            return;
        }
        img[row][col] = newColor;
        for (int[] dir : dirs) {
            int curRow = row + dir[0];
            int curCol = col + dir[1];
            if (curRow >= 0 && curRow < img.length && curCol >= 0 && curCol < img[0].length) {
                dfs(img, curRow, curCol, color, newColor);
            }
        }
    }

    private static void dfs2(int[][] img, int row, int col, int color, int newColor) {
        if (img[row][col] != color) {
            return;
        }
        img[row][col] = newColor;
        for (int[] dir : dirs) {
            int curRow = row + dir[0];
            int curCol = col + dir[1];
            if (curRow >= 0 && curRow < img.length && curCol >= 0 && curCol < img[0].length) {
                dfs2(img, curRow, curCol, color, newColor);
            }
        }
    }

    public int[][] floodFill3(int[][] image, int sr, int sc, int newColor) {
        int curColor = image[sr][sc];
        if (curColor == newColor) {
            return image;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int[] dir : dirs) {
                int curRow = pos[0] + dir[0];
                int curCol = pos[1] + dir[1];
                if (curRow >= 0 && curRow < image.length && curCol >= 0 && curCol < image[0].length && image[curRow][curCol] == curColor) {
                    queue.offer(new int[]{curRow, curCol});
                    image[curRow][curCol] = newColor;
                }
            }
        }

        return image;
    }
}
