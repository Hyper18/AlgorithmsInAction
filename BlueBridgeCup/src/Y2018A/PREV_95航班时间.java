package Y2018A;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/04/04
 * @time 62ms
 * AC了，但是感觉写的很复杂
 * 主要还是模拟跨时区的过程
 * 若跨，则将两者的小时相加/2（观察样例可以分析得到）
 */
public class PREV_95航班时间 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        int t = nextInt();
        for (int i = 0; i < t; i++) {
            String[] to = next().split(" ");
            String[] back = next().split(" ");

            int to_h1 = Integer.parseInt(to[0].split(":")[0]);
            int to_m1 = Integer.parseInt(to[0].split(":")[1]);
            int to_s1 = Integer.parseInt(to[0].split(":")[2]);

            int to_h2 = Integer.parseInt(to[1].split(":")[0]);
            int to_m2 = Integer.parseInt(to[1].split(":")[1]);
            int to_s2 = Integer.parseInt(to[1].split(":")[2]);

            if (to.length == 3) {
                int nextDay = Integer.parseInt(String.valueOf(to[2].charAt(2)));
                to_h2 += 24 * nextDay;
            }

            int res_h = to_h2 - to_h1;
            int res_m = to_m2 - to_m1;
            int res_s = to_s2 - to_s1;
            if (res_s < 0) {
                res_s += 60;
                res_m--;
            }
            if (res_m < 0) {
                res_m += 60;
                res_h--;
            }

            int back_h1 = Integer.parseInt(back[0].split(":")[0]);
            int back_m1 = Integer.parseInt(back[0].split(":")[1]);
            int back_s1 = Integer.parseInt(back[0].split(":")[2]);

            int back_h2 = Integer.parseInt(back[1].split(":")[0]);
            int back_m2 = Integer.parseInt(back[1].split(":")[1]);
            int back_s2 = Integer.parseInt(back[1].split(":")[2]);

            if (back.length == 3) {
                int nextDay = Integer.parseInt(String.valueOf(back[2].charAt(2)));
                back_h2 += 24 * nextDay;
            }

            int res2_h = back_h2 - back_h1;
            int res2_m = back_m2 - back_m1;
            int res2_s = back_s2 - back_s1;
            if (res2_s < 0) {
                res2_s += 60;
                res2_m--;
            }
            if (res2_m < 0) {
                res2_m += 60;
                res2_h--;
            }

            StringBuilder sb = new StringBuilder();
            if (res_h != res2_h) {
                res_h = (res_h + res2_h) / 2;

            }
            if (res_h < 10) {
                sb.append("0");
            }
            sb.append(res_h).append(":");
            if (res_m < 10) {
                sb.append("0");
            }
            sb.append(res_m).append(":");
            if (res_s < 10) {
                sb.append("0");
            }
            sb.append(res_s);
            out.println(sb);
        }

        close();
    }

    public static int nextInt() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return Integer.parseInt(tk.nextToken());
    }

    private static String next() throws IOException {
        return in.readLine();
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
