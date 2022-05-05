package Algorithm_BasicLevel;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/05
 * <p>
 * 思路
 * SVM，O(n)可AC
 */
public class Q799_最长连续不重复子序列_2 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 100000 + 10;
    private static int[] a = new int[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }

        Map<Integer, Integer> idxMap = new HashMap<>();
        int i = 0, j = 0, ans = 0;
        while (true) {
            if (j == n) {
                ans = Math.max(ans, j - i);
                break;
            }
            if (idxMap.get(a[j]) != null) {
                ans = Math.max(ans, j - i);
                i = idxMap.get(a[j]) + 1;
                idxMap = new HashMap<>();
                j = i;
            }
            idxMap.put(a[j], j);
            j++;
        }

        out.println(ans);

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
