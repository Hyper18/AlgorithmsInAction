package Y2014A;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/03/16
 * @time 93ms
 */
public class PREV_319 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static int[][] nums;
    static String s;
    static boolean flag = true;
    static int m, n;

    public static void main(String[] args) throws IOException {
        m = nextInt();
        n = nextInt();
        nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = nextInt();
            }
        }
        int x = nextInt();
        int y = nextInt();
        s = nextString();
        int k = nextInt();

        move(x, y, k);

        close();
    }

    private static void move(int x, int y, int k) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            if (flag) {
                out.printf("%d %d\n", 0, 0);
                flag = false;
            }
            return;
        }
        if (k == 0) {
            if (flag) {
                out.printf("%d %d\n", x, y);
                flag = false;
            }
            return;
        }

        if (nums[x][y] == 1) {
            turnRight();
            nums[x][y] = 0;
            moveForward(x, y, k);
        }

        if (nums[x][y] == 0) {
            turnLeft();
            nums[x][y] = 1;
            moveForward(x, y, k);
        }
    }

    private static void moveForward(int x, int y, int k) {
        switch (s) {
            case "L": {
                move(x, y - 1, k - 1);
                break;
            }
            case "U": {
                move(x - 1, y, k - 1);
                break;
            }
            case "R": {
                move(x, y + 1, k - 1);
                break;
            }
            case "D": {
                move(x + 1, y, k - 1);
                break;
            }
        }
    }

    private static void turnRight() {
        switch (s) {
            case "L": {
                s = "U";
                break;
            }
            case "U": {
                s = "R";
                break;
            }
            case "R": {
                s = "D";
                break;
            }
            case "D": {
                s = "L";
                break;
            }
        }
    }

    private static void turnLeft() {
        switch (s) {
            case "L": {
                s = "D";
                break;
            }
            case "D": {
                s = "R";
                break;
            }
            case "R": {
                s = "U";
                break;
            }
            case "U": {
                s = "L";
                break;
            }
        }
    }

    public static int nextInt() throws IOException {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }

        return Integer.parseInt(token.nextToken());
    }

    public static String nextString() throws IOException {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }

        return token.nextToken();
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
