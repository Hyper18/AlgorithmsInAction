package Y2017B;

import java.io.*;
import java.util.*;

/**
 * @author Hyperspace
 * @date 2022/04/02
 * @time 78ms
 * <p>
 * 思路
 * 一开始想到用全排列
 * 但根据题干情况，可只枚举三种即可
 * 回溯时间复杂度过高，也没有必要（还需要判重）
 */
public class Q7日期问题_2 {
    static class MyDate implements Comparable<MyDate> {
        String y;
        String m;
        String d;

        public MyDate(String y, String m, String d) {
            this.y = y;
            this.m = m;
            this.d = d;
        }

        @Override
        public int compareTo(MyDate o) {
            if (!y.equals(o.y)) {
                return Integer.parseInt(y) - Integer.parseInt(o.y);
            } else if (!m.equals(o.m)) {
                return Integer.parseInt(m) - Integer.parseInt(o.m);
            } else {
                return Integer.parseInt(d) - Integer.parseInt(o.d);
            }
        }
    }

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static List<MyDate> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String[] str = next().split("/");
        addDate(str[0], str[1], str[2]);
        addDate(str[2], str[0], str[1]);
        addDate(str[2], str[1], str[0]);

        Collections.sort(list);
        Set<String> res = new TreeSet<>();
        for (MyDate date : list) {
            if (date == null) {
                continue;
            }
            res.add(new StringBuilder().append(date.y).append("-").append(date.m).append("-").append(date.d).toString());
        }
        for (String d : res) {
            out.println(d);
        }

        close();
    }

    private static void addDate(String y, String m, String d) {
        if (check(y, m, d)) {
            list.add(new MyDate(Integer.parseInt(y) < 60 ? "20" + y : "19" + y, m, d));
        }
    }

    private static boolean check(String y, String m, String d) {
        int month = Integer.parseInt(m);
        int date = Integer.parseInt(d);
        if (month < 1 || month > 12 || date < 1 || date > 31) {
            return false;
        }
        boolean isSmallMonth = month == 2 || month == 4 || month == 6 || month == 9 || month == 11;
        if (isSmallMonth && date == 31) {
            return false;
        }
        int year = Integer.parseInt(y);
        return isLeapYear(year < 60 ? year + 2000 : year + 1900) || month != 2 || date != 29;
    }

    private static boolean isLeapYear(int y) {
        return y % 400 == 0 || (y % 4 == 0 && y % 100 != 0);
    }

    private static String next() throws IOException {
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
