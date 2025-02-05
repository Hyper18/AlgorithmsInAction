package Fundamentals.QuickSort;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/02
 * 注：j - l + 1表示 前半部分的元素个数
 */
public class Q786_第k个数_2 {
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

        out.println(quickSort(0, n - 1, k));

        close();
    }

    private static int quickSort(int l, int r, int k) {
        if (l >= r) {
            return q[l];
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
        if (j - l + 1 >= k) {
            return quickSort(l, j, k);
        } else {
            return quickSort(j + 1, r, k - (j - l + 1));
        }
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
