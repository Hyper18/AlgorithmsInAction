package Y2019B;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Hyper
 * @date 2022/04/06
 */
public class E迷宫_2 {
    private static class Node {
        int x;
        int y;
        String s;

        public Node(int x, int y, String s) {
            super();
            this.x = x;
            this.y = y;
            this.s = s;
        }
    }

    private static final int n = 30, m = 50;
    private static char[][] maze = new char[n][m];
    private static Deque<Node> q = new LinkedList<>();
    private static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static char[] notes = new char[]{'D', 'U', 'R', 'L'};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(
                "C:\\Users\\Vincent\\IdeaProjects\\AlgorithmsInAction\\BlueBridgeCup\\src\\Y2019B\\maze.txt"));
        for (int i = 0; i < n; i++) {
            maze[i] = in.readLine().toCharArray();
        }

        q.offer(new Node(0, 0, ""));
        maze[0][0] = '1';
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < dirs.length; i++) {
                int nx = node.x + dirs[i][0];
                int ny = node.y + dirs[i][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || maze[nx][ny] == '1') {
                    continue;
                }
                if (nx == n - 1 && ny == m - 1) {
                    System.out.println(node.s + notes[i]);
                    System.exit(0);
                }
                q.offer(new Node(nx, ny, node.s + notes[i]));
                maze[nx][ny] = '1';
            }
        }
    }
}
