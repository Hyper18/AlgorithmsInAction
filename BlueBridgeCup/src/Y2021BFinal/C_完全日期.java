package Y2021BFinal;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class C_完全日期 {
    public static void main(String[] args) {
        int y = 2021, m = 12, d = 31, ans = 0;
        for (int i = 2001; i <= y; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= d; k++) {
                    if (check(i, j, k)) {
                        int sum = getSum(i, j, k);
                        int r = (int) Math.sqrt(sum);
                        if (r * r == sum) {
                            ans++;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }

    /**
     * 使用SimpleDateFormat的setLenient严格匹配日期格式以判断合法性
     *
     * @param y 年份
     * @param m 月份
     * @param d 日期
     * @return 是否为合法的日期
     */
    private static boolean check(int y, int m, int d) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = y + "-" + m + "-" + d;
        sdf.setLenient(false);
        try {
            sdf.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    private static int getSum(int y, int m, int d) {
        return get(y) + get(m) + get(d);
    }

    private static int get(int n) {
        int sum = 0;
        while (n > 0) {
            int r = n % 10;
            sum += r;
            n /= 10;
        }
        return sum;
    }
}
