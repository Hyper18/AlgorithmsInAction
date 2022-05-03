package Algorithm_BasicLevel;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/02
 */
public class Q787_归并排序_2 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 100000 + 10;
    private static int[] q = new int[N];
    private static int[] tmp = new int[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        for (int i = 0; i < n; i++) {
            q[i] = nextInt();
        }

        mergeSort(0, n - 1);

        for (int i = 0; i < n; i++) {
            out.print(q[i] + " ");
        }

        close();
    }

    private static void mergeSort(int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        mergeSort(l, mid);
        mergeSort(mid + 1, r);

        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (q[i] <= q[j]) {
                tmp[k++] = q[i++];
            } else {
                tmp[k++] = q[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = q[i++];
        }
        while (j <= r) {
            tmp[k++] = q[j++];
        }
        for (i = l, j = 0; i <= r; i++, j++) {
            q[i] = tmp[j];
        }
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
