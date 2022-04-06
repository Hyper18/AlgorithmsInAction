//package Y2019B;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author Hyperspace
// * @date 2022/04/06
// */
//public class E迷宫 {
//    private static final int n = 30, m = 50;
//    private static char[][] maze = new char[n][m];
//    private static boolean[][] vis = new boolean[n][m];
//    static boolean isEnd;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new FileReader(
//                "C:\\Users\\Vincent\\IdeaProjects\\AlgorithmsInAction\\BlueBridgeCup\\src\\Y2019B\\maze.txt"));
//        for (int i = 0; i < n; i++) {
//            maze[i] = in.readLine().toCharArray();
//        }
//
//        dfs(0, 0);
//    }
//
//    private static void dfs(int x, int y) {
//        if (x < 0 || x >= n || y < 0 || y >= m || vis[x][y] || maze[x][y] == '1') {
//            return;
//        }
//        if (x == n - 1 && y == m - 1 && !isEnd) {
//            isEnd = true;
//            return;
//        }
//        vis[x][y] = true;
//        if (!isEnd) {
//            dfs(x + 1, y);
//            dfs(x - 1, y);
//            dfs(x, y + 1);
//            dfs(x, y - 1);
//        }
//    }
//}
