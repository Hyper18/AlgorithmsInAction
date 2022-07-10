package caip2022;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/07/10
 */
public class Q2 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 1010;
    private static int[] a = new int[N];
    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = nextInt();
        }
        while (m-- > 0) {
            int t = nextInt(), k = nextInt();
            for (int i = 0; i < k; i++) {
                int med = nextInt();
                if (a[med] == -1) {
                    continue;
                }
                if (map.get(med) == null) {
                    map.put(med, t);
                } else {
                    int last = map.get(med);
                    int period = a[med];
                    if (t - last < period) {
                        out.println("Don't take " + med + " at " + t + "!");
                    } else {
                        map.put(med, t);
                    }
                }
            }
        }

        close();
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
