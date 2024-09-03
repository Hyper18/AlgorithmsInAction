package Fundamentals.MergeSort;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/03
 * <p>
 * 思路
 * 需要作分类讨论
 * 1. 逆序对全部位于左半边
 * 2. 逆序对全部位于右半边
 * 3. 逆序对分别位于左右半边
 * <p>
 * 另，本题的数据量最大可取 N=100000，
 * 这也就意味着总逆序对个数为 n-1 + n-2 + n-3 + ... + 2 + 1 = 5 * 10^9
 * 超过了int的数据范围
 * 因此，实际操作结果时应当使用long防止爆int
 */
public class Q788_逆序对的数量 {
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
        out.println(mergeSort(0, n - 1));
        close();
    }

    private static long mergeSort(int l, int r) {
        if (l >= r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        // 逆序对全部位于左半边 + 逆序对全部位于右半边
        long ans = mergeSort(l, mid) + mergeSort(mid + 1, r);
        int k = 0, i = l, j = mid + 1;
        // 1. 先归并
        while (i <= mid && j <= r) {
            if (q[i] <= q[j]) {
                tmp[k++] = q[i++];
            } else {
                tmp[k++] = q[j++];
                // 逆序对分别位于左右半边
                ans += mid - i + 1;
            }
        }
        // 2. 再扫尾
        while (i <= mid) {
            tmp[k++] = q[i++];
        }
        while (j <= r) {
            tmp[k++] = q[j++];
        }
        // 3. 最后物归原主
        for (i = l, j = 0; i <= r; i++, j++) {
            q[i] = tmp[j];
        }

        return ans;
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
