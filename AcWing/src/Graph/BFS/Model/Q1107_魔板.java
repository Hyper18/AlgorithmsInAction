package Graph.BFS.Model;

import java.io.*;
import java.util.*;

/**
 * @author Hyperspace
 * @date 2022/06/05
 * <p>
 * 思路
 * 1. 全排列：回溯、剪枝
 * 2. bfs
 * <p>
 * 待回看
 */
public class Q1107_魔板 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static Map<String, PII> op = new HashMap<>();
    private static Map<String, Integer> d = new HashMap<>();
    private static char[][] g = new char[2][4];

    static class PII {
        char op;
        String s;

        public PII(char op, String s) {
            this.op = op;
            this.s = s;
        }
    }

    private static void set(String state) {
        for (int i = 0; i < 4; i++) {
            g[0][i] = state.charAt(i);
        }
        for (int i = 7, j = 0; j < 4; i--, j++) {
            g[1][j] = state.charAt(i);
        }
    }

    private static String get() {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            ans.append(g[0][i]);
        }
        for (int i = 3; i >= 0; i--) {
            ans.append(g[1][i]);
        }
        return ans.toString();
    }

    private static String move0(String state) {
        set(state);
        for (int i = 0; i < 4; i++) {
            char t = g[0][i];
            g[0][i] = g[1][i];
            g[1][i] = t;
        }
        return get();
    }

    private static String move1(String state) {
        set(state);
        char v0 = g[0][3], v1 = g[1][3];
        for (int i = 3; i > 0; i--) {
            g[0][i] = g[0][i - 1];
            g[1][i] = g[1][i - 1];
        }
        g[0][0] = v0;
        g[1][0] = v1;
        return get();
    }

    private static String move2(String state) {
        set(state);
        char v = g[0][1];
        g[0][1] = g[1][1];
        g[1][1] = g[1][2];
        g[1][2] = g[0][2];
        g[0][2] = v;
        return get();
    }

    public static void main(String[] args) throws IOException {
        String st = "12345678";
        StringBuilder input = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            input.append(next());
        }
        String ed = input.toString();
        int step = bfs(st, ed);
        out.println(step);
        StringBuilder ans = new StringBuilder();
        while (!ed.equals(st)) {
            ans.append(op.get(ed).op);
            ed = op.get(ed).s;
        }
        ans.reverse();
        if (step > 0) {
            out.println(ans);
        }
        close();
    }

    private static int bfs(String st, String ed) {
        if (st.equals(ed)) {
            return 0;
        }
        Queue<String> q = new LinkedList<>();
        q.offer(st);
        d.put(st, 0);
        while (!q.isEmpty()) {
            String p = q.poll();

            String[] m = new String[3];
            m[0] = move0(p);
            m[1] = move1(p);
            m[2] = move2(p);

            for (int i = 0; i < 3; i++) {
                if (d.containsKey(m[i])) {
                    continue;
                }
                d.put(m[i], d.get(p) + 1);
                op.put(m[i], new PII((char) ('A' + i), p));
                q.offer(m[i]);
                if (m[i].equals(ed)) {
                    return d.get(ed);
                }
            }
        }

        return -1;
    }

    public static int nextInt() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return Integer.parseInt(tk.nextToken());
    }

    public static String next() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return tk.nextToken();
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
