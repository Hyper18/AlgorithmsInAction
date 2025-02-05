package Y2015A;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/03/23
 * 待回看
 */
class Edge {
    int x;
    int y;
    int p;

    public Edge() {
        super();
    }
}

public class PREV_169 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int MAXM = 200000 + 10;
    private static Edge[] edges = new Edge[MAXM * 2];
    private static int[] head = new int[MAXM];
    private static int node;

    public static void main(String[] args) throws IOException {
        init();
        int n = nextInt();
        int m = nextInt();
        int q = nextInt();

        int[] x = new int[m];
        int[] y = new int[m];
        int[] p = new int[m];
        for (int i = 0; i < m; i++) {
            x[i] = nextInt();
            y[i] = nextInt();
            p[i] = nextInt();
            addEdge(x[i], y[i], p[i]);
            addEdge(y[i], x[i], p[i]);
        }
        for (int i = 0; i < q; i++) {
            int l = nextInt();
            int r = nextInt();
            int k = nextInt();
            int c = nextInt();

        }

        close();
    }

    private static void addEdge(int pre, int to, int p) {
        edges[node] = new Edge();
        edges[node].x = pre;
        edges[node].y = to;
        edges[node].p = p;
        head[pre] = node++;
    }

    private static void init() {
        Arrays.fill(head, -1);
        node = 0;
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

    public static String nextString() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }

        return tk.nextToken();
    }

    public static long nextLong() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }

        return Long.parseLong(tk.nextToken());
    }

    public static double nextDouble() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }

        return Double.parseDouble(tk.nextToken());
    }
}
