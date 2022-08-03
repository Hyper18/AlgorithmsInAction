package DS;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/08/02
 */
public class Q826_单链表 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 100010;
    private static int[] e = new int[N], ne = new int[N];
    static int head, idx;

    private static void init() {
        head = -1;
        idx = 0;
    }

    private static void add(int val) {
        e[idx] = val;
        ne[idx] = head;
        head = idx++;
    }

    private static void insert(int k, int val) {
        e[idx] = val;
        ne[idx] = ne[k];
        ne[k] = idx++;
    }

    private static void remove(int k) {
        ne[k] = ne[ne[k]];
    }

    public static void main(String[] args) throws IOException {
        int m = nextInt();
        init();
        while (m-- > 0) {
            String s = next();
            switch (s) {
                case "H":
                    add(nextInt());
                    break;
                case "I":
                    insert(nextInt() - 1, nextInt());
                    break;
                case "D":
                    int k = nextInt();
                    if (k == 0) {
                        head = ne[head];
                    } else {
                        remove(k - 1);
                    }
                    break;
                default:
            }
        }

        for (int i = head; i != -1; i = ne[i]) {
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
