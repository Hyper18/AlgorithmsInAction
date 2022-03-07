package practice1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/07
 * @time 968ms
 * 这题的样例输出有问题，应为178
 * <p>
 * 题目为求n个农场的最小生成树，重点在于处理边权
 * 对该无向图，边权 = len * 2（往返） + c[start] + c[end]
 */
public class N_算法训练_安慰奶牛 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int p = nextInt();
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = nextInt();
        }
        Edge[] edges = new Edge[p];
        int[] s = new int[p];
        int[] e = new int[p];
        int[] l = new int[p];
        for (int i = 0; i < p; i++) {
            s[i] = nextInt();
            e[i] = nextInt();
            l[i] = nextInt();
            edges[i] = new Edge(s[i], e[i], l[i] * 2 + c[s[i] - 1] + c[e[i] - 1]);
        }

        Arrays.sort(edges);

        int[] flag = new int[n + 2];
        Arrays.fill(flag, 1);
        flag[edges[0].start] = 0;
        int num = 0;
        int sum = 0;
        for (int i = 0; i < p; i++) {
            num = flag[edges[i].start] + flag[edges[i].end];
            if (num == 1) {
                sum += edges[i].len;
                flag[edges[i].start] = 0;
                flag[edges[i].end] = 0;
                i = 0;
            }
        }

        int ans = sum + Arrays.stream(c).min().getAsInt();
        out.println(ans);

        close();
    }

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int len;

        public Edge(int start, int end, int len) {
            super();
            this.start = start;
            this.end = end;
            this.len = len;
        }

        @Override
        public int compareTo(Edge o) {
            return len - o.len;
        }
    }

    public static int nextInt() throws IOException {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }

        return Integer.parseInt(token.nextToken());
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
