package Y2017B;

import java.io.*;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * @author Hyper
 * @date 2022/04/02
 * 50 / 100
 */
public class Q7日期问题 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static String[] nums;
    private static Set<String> res = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        String date = nextString();
        nums = date.split("/");
        Arrays.sort(nums);
        f(0);
        for (String s : res) {
            out.println(s);
        }
        close();
    }

    private static void f(int k) {
        if (k == 3) {
            if (check()) {
                StringBuilder sb = new StringBuilder();
                int y = Integer.parseInt(nums[0]);
                int m = Integer.parseInt(nums[1]);
                int d = Integer.parseInt(nums[2]);
                if (y < 60) {
                    sb.append("20");
                    y += 2000;
                } else {
                    sb.append("19");
                    y += 1900;
                }
                if (!check(y) && m == 2 && d == 29) {
                    return;
                }
                res.add(sb.append(nums[0]).append("-").append(nums[1]).append("-").append(nums[2]).toString());
            }
            return;
        }
        for (int i = k; i < nums.length; i++) {
            {
                String t = nums[i];
                nums[i] = nums[k];
                nums[k] = t;
            }
            f(k + 1);
            {
                String t = nums[i];
                nums[i] = nums[k];
                nums[k] = t;
            }
        }
    }

    private static boolean check(int y) {
        if (y % 400 == 0) {
            return true;
        }
        if (y % 4 == 0 && y % 100 != 0) {
            return true;
        }
        return false;
    }

    private static boolean check() {
        int m = Integer.parseInt(nums[1]);
        int d = Integer.parseInt(nums[2]);
        if (m < 1 || m > 12 || d < 1 || d > 31) {
            return false;
        }
        boolean isSmallMonth = (m == 2 || m == 4 || m == 6 || m == 9 || m == 11);
        if (isSmallMonth && d == 31) {
            return false;
        }
        if (m == 2 && d == 30) {
            return false;
        }
        return true;
    }

    private static String nextString() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return tk.nextToken();
    }

    private static void close() throws IOException {
        in.close();
        out.close();
    }
}
