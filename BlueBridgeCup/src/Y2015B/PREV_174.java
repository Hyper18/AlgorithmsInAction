package Y2015B;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/23
 * @time 78ms
 * 一遍AC，爽。。
 * 模拟
 * 瓶盖兑换的核心在于3换1，从而可以达到"再来一瓶"的效果
 * 因此，通过除3得到每次的饮料数，并处理余数
 * 当余数超过3时，证明可以再多换一瓶
 * <p>
 * 注意：代码中循环的终止条件是当前n<3时
 * 因此如果此时余数和n的加和超过3，是可以再多兑换一瓶的
 */
public class PREV_174 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        int n = nextInt();

        int ans = n;
        int res = 0;
        while (n / 3 != 0) {
            if (n % 3 != 0) {
                int tmp = n % 3;
                n -= tmp;
                res += tmp;
                if (res >= 3) {
                    res -= 3;
                    n += 3;
                }
            }
            ans += n / 3;
            n /= 3;
        }
        if (n + res >= 3) {
            ans++;
        }
        out.println(ans);

        close();
    }

    private static int nextInt() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return Integer.parseInt(tk.nextToken());
    }

    private static void close() throws IOException {
        in.close();
        out.close();
    }
}
