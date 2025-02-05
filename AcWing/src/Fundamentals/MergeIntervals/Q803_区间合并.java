package Fundamentals.MergeIntervals;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2024/09/03
 * @file Q803_区间合并.java
 */
public class Q803_区间合并 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = (int) -2e9;

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        List<int[]> segs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int l = nextInt(), r = nextInt();
            segs.add(new int[]{l, r});
        }
        out.println(merge(segs));
        close();
    }

    private static int merge(List<int[]> segs) {
        List<int[]> res = new ArrayList<>();
        segs.sort(Comparator.comparingInt(a -> a[0]));
        int st = N, ed = st;
        for (int[] seg : segs) {
            int l = seg[0], r = seg[1];
            if (ed < l) {
                if (st != N) {
                    res.add(new int[]{st, ed});
                }
                st = l;
                ed = r;
            } else {
                ed = Math.max(ed, r);
            }
        }
        if (st != N) {
            res.add(new int[]{st, ed});
        }

        return res.size();
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
