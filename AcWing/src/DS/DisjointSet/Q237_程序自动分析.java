package DS.DisjointSet;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/06/15
 * <p>
 * 思路
 * 哈希计数 + 并查集
 */
public class Q237_程序自动分析 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    /**
     * 一个表达式有左值和右值两个值
     */
    private static final int N = (int) 1e5 * 2 + 10;
    private static int[] p = new int[N];
    private static Query[] queries = new Query[N];
    private static Map<Integer, Integer> idxMap = new HashMap<>();
    static int n, m;

    static class Query {
        int x, y, e;

        public Query(int x, int y, int e) {
            this.x = x;
            this.y = y;
            this.e = e;
        }
    }

    private static void init() {
        n = 0;
        idxMap.clear();
    }

    public static void main(String[] args) throws IOException {
        int t = nextInt();
        while (t-- > 0) {
            init();
            m = nextInt();
            for (int i = 0; i < m; i++) {
                int x = nextInt(), y = nextInt(), e = nextInt();
                queries[i] = new Query(get(x), get(y), e);
            }
            for (int i = 1; i <= n; i++) {
                p[i] = i;
            }

            // 1. 合并相等的条件
            for (int i = 0; i < m; i++) {
                if (queries[i].e == 1) {
                    int pa = find(queries[i].x), pb = find(queries[i].y);
                    p[pa] = pb;
                }
            }
            // 2. 检查不相等条件
            boolean checked = true;
            for (int i = 0; i < m; i++) {
                if (queries[i].e == 0) {
                    int pa = find(queries[i].x), pb = find(queries[i].y);
                    if (pa == pb) {
                        checked = false;
                        break;
                    }
                }
            }

            out.println(checked ? "YES" : "NO");
        }
        close();
    }

    private static int get(int x) {
        if (!idxMap.containsKey(x)) {
            idxMap.put(x, ++n);
        }
        return idxMap.get(x);
    }

    private static int find(int x) {
        if (x != p[x]) {
            p[x] = find(p[x]);
        }
        return p[x];
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
