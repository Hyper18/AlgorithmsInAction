package practice.practice6;

import java.io.*;
import java.util.*;

/**
 * @author Hyperspace
 * @date 2022/03/22
 * 模拟
 * 62/100
 */
class Log implements Comparable<Log> {
    int ts;
    int id;

    public Log(int ts, int id) {
        super();
        this.ts = ts;
        this.id = id;
    }

    @Override
    public int compareTo(Log o) {
        if (id == o.id) {
            return ts - o.ts;
        }
        return id - o.id;
    }
}

public class P_日志统计 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int MAX = 100000 + 10;
    private static Log[] logs = new Log[MAX];
    static int d;

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        d = nextInt();
        int k = nextInt();
        for (int i = 0; i < n; i++) {
            int ts = nextInt();
            int id = nextInt();
            logs[i] = new Log(ts, id);
        }

        Set<Integer> res = new HashSet<>();
        int likes = 0;
        for (int i = 0; i < n; i++) {
            if (k == 1) {
                res.add(logs[i].id);
            } else {
                for (int j = i + 1; j < n; j++) {
                    if (checkId(i, j) && checkDate(i, j)) {
                        if (likes == 0) {
                            likes += 2;
                        } else {
                            likes++;
                        }
                    }
                    if (likes >= k) {
                        res.add(logs[i].id);
                        likes = 0;
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int id : res) {
            ans.add(id);
        }
        Collections.sort(ans);
        for (int id : ans) {
            out.println(id);
        }

        close();
    }

    private static boolean checkId(int i, int j) {
        return logs[i].id == logs[j].id;
    }

    private static boolean checkDate(int start, int end) {
        return Math.abs(logs[end].ts - logs[start].ts) < d;
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
