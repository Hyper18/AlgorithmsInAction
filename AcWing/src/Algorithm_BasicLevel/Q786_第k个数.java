package Algorithm_BasicLevel;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/02
 * <p>
 * AC，舒服
 * 模板yyds
 */
public class Q786_第k个数 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 100000 + 10;
    private static int[] q = new int[N];
    static int n;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        int k = nextInt();
        for (int i = 0; i < n; i++) {
            q[i] = nextInt();
        }

        quickSort(0, n - 1);

        out.println(q[k - 1]);

        close();
    }

    private static void quickSort(int l, int r) {
        if (l >= r) {
            return;
        }
        int x = q[l + ((r - l) >> 1)];
        int i = l - 1, j = r + 1;
        while (i < j) {
            do {
                i++;
            } while (q[i] < x);
            do {
                j--;
            } while (q[j] > x);
            if (i < j) {
                swap(i, j);
            }
        }
        quickSort(l, j);
        quickSort(j + 1, r);
    }

    private static void swap(int i, int j) {
        int t = q[i];
        q[i] = q[j];
        q[j] = t;
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
