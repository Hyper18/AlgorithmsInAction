import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 提交代码不要加入import 包名！！
 * JDK8下引用包仍需正常导入
 *
 * @Author Hyperspace
 * @Date 2022/02/09
 * <p>
 * 主类必须用Main！！
 */
public class Main {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int n = nextInt();
        long m = nextLong();
        double d = nextDouble();
        String s = nextString();

        out.printf("%d %f %f %s", n, m, d, s);

        close();
    }

    public static int nextInt() throws Exception {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }

        return Integer.parseInt(token.nextToken());
    }

    public static long nextLong() throws Exception {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }

        return Long.parseLong(token.nextToken());
    }

    public static double nextDouble() throws Exception {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }

        return Double.parseDouble(token.nextToken());
    }

    public static String nextString() throws Exception {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }

        return token.nextToken();
    }

    public static void close() throws Exception {
        in.close();
        out.close();
    }
}
