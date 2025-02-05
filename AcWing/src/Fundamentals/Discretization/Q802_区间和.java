package Fundamentals.Discretization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * @author Hyper
 * @date 2024/09/03
 * @file Q802_区间和.java
 */
public class Q802_区间和 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = (int) (3e5 + 10);
    private static List<Integer> alls = new ArrayList<>();
    private static List<int[]> add = new ArrayList<>(), query = new ArrayList<>();
    private static int[] a = new int[N], s = new int[N];
    private static int n, m;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        m = nextInt();
        for (int i = 0; i < n; i++) {
            int x = nextInt(), c = nextInt();
            add.add(new int[]{x, c});
            alls.add(x);
        }
        for (int i = 0; i < m; i++) {
            int l = nextInt(), r = nextInt();
            query.add(new int[]{l, r});
            alls.add(l);
            alls.add(r);
        }
        alls = alls.stream().distinct().sorted().collect(Collectors.toList());
        for (int[] item : add) {
            int x = find(item[0]);
            a[x] += item[1];
        }
        for (int i = 1; i <= alls.size(); i++) {
            s[i] = s[i - 1] + a[i];
        }
        for (int[] item : query) {
            int l = find(item[0]), r = find(item[1]);
            out.println(s[r] - s[l - 1]);
        }
        close();
    }

    private static int find(int target) {
        int low = 0, high = alls.size() - 1;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (alls.get(mid) >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return high + 1;
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
