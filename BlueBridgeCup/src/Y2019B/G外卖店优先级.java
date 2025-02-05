package Y2019B;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/04/06
 * @time 1.062s
 * 模拟
 */
public class G外卖店优先级 {
    private static class Order implements Comparable<Order> {
        int t;
        int id;

        public Order(int t, int id) {
            this.t = t;
            this.id = id;
        }

        @Override
        public int compareTo(Order o) {
            return t - o.t;
        }
    }

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int m = nextInt();
        int t = nextInt();

        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int ts = nextInt();
            int id = nextInt();
            orders.add(new Order(ts, id));
        }

        int[] stores = new int[n + 1];
        int[] prior = new int[n + 1];
        for (int i = 1; i <= t; i++) {
            boolean[] isIn = new boolean[n + 1];
            for (Order o : orders) {
                if (o.t == i) {
                    stores[o.id] += 2;
                    isIn[o.id] = true;
                }
            }
            for (int j = 1; j <= n; j++) {
                if (!isIn[j] && stores[j] > 0) {
                    stores[j]--;
                }
                if (stores[j] > 5) {
                    prior[j] = 1;
                } else if (stores[j] <= 3) {
                    prior[j] = 0;
                }
            }
        }

        out.println(Arrays.stream(prior).sum());

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
