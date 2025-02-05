package Fundamentals.QuickSort;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/04/30
 */
public class Q785_快速排序 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 1000000 + 10;
    static int n;
    static int[] q = new int[N];

    public static void main(String[] args) throws IOException {
        n = nextInt();
        for (int i = 0; i < n; i++) {
            q[i] = nextInt();
        }

        quickSort(0, n - 1);

        for (int i = 0; i < n; i++) {
            out.print(q[i] + " ");
        }

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
