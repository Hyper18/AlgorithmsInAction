package DS;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/08/03
 */
public class Q827_双链表 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 100010;
    private static int[] e = new int[N], l = new int[N], r = new int[N];
    static int idx;

    private static void init() {
        l[0] = 0;
        r[0] = 1;
        // 操作数为第k个插入的数
        idx = 2;
    }

    private static void addFirst(int val) {
        e[idx] = val;
        l[idx] = 0;
        r[idx] = r[0];
        l[r[0]] = idx;
        r[0] = idx++;
    }

    private static void addLast(int val) {
        e[idx] = val;
        l[idx] = l[1];
        r[idx] = 1;
        r[l[1]] = idx;
        l[1] = idx++;
    }

    private static void remove(int k) {
        r[l[k]] = r[k];
        l[r[k]] = l[k];
    }

    private static void insert(int k, int val) {
        e[idx] = val;
        l[idx] = k;
        r[idx] = r[k];
        l[r[k]] = idx;
        r[k] = idx++;
    }

    public static void main(String[] args) throws IOException {
        int m = nextInt();
        init();
        while (m-- > 0) {
            switch (next()) {
                case "L":
                    addFirst(nextInt());
                    break;
                case "R":
                    addLast(nextInt());
                    break;
                case "D":
                    remove(nextInt() + 1);
                    break;
                case "IL":
                    insert(l[nextInt() + 1], nextInt());
                    break;
                case "IR":
                    insert(nextInt() + 1, nextInt());
                    break;
            }
        }

        for (int i = r[0]; i != 1; i = r[i]) {
            out.print(e[i] + " ");
        }

        close();
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
