package Y2015A;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/03/22
 * @time 62ms
 * <p>
 * 初看以为是dfs+回溯
 * 后来发现数据量>100回溯太慢。。
 * 实际是找规律的题
 */
public class PREV_171 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        int w = nextInt();
        int m = nextInt();
        int n = nextInt();

        int mx = (int) Math.ceil(m / (double) w);
        int nx = (int) Math.ceil(n / (double) w);
        int my = 0;
        if (mx % 2 == 0) {
            my = mx * w - m + 1;
        } else {
            my = w - (mx * w - m);
        }
        int ny = 0;
        if (nx % 2 == 0) {
            ny = nx * w - n + 1;
        } else {
            ny = w - (nx * w - n);
        }

        out.println(getDistance(mx, my, nx, ny));

        close();
    }

    private static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
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
