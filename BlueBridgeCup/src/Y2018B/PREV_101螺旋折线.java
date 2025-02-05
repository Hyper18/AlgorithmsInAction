package Y2018B;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/04/06
 * @time 78ms
 * 数学、等差数列
 * 思路
 * 把每次看作是从1~n的边长累加1的正方形的一圈圈周长
 * 记录每个正方形的左下方顶点的距离，
 * 答案即为上述距离减去两点之间的距离
 */
public class PREV_101螺旋折线 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static long n;

    public static void main(String[] args) throws IOException {
        int x = nextInt();
        int y = nextInt();

        n = Math.max(Math.abs(x), Math.abs(y));
        long ans = 8 * n + 4 * n * (n - 1) - getDistance(x, y, -(int) n, -(int) n);

        out.println(ans);

        close();
    }

    private static long getDistance(int x1, int y1, int x2, int y2) {
        if (y1 == y2 || x1 == -x2) {
            return Math.abs(x1 - x2) + Math.abs(y1 - y2);
        } else {
            return 8 * n - (Math.abs(x1 - x2) + Math.abs(y1 - y2));
        }
    }

    public static int nextInt() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }

        return Integer.parseInt(tk.nextToken());
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
