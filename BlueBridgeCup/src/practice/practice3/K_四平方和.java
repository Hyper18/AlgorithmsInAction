package practice.practice3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/07
 * @time 626ms
 * <p>
 * 暴力大法好
 * 注：使用Math.pow(i, 2)慢于i*i
 */
public class K_四平方和 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        for (int i = 0; i <= (int) Math.ceil(Math.sqrt(n)); i++) {
            for (int j = i; j <= (int) Math.ceil(Math.sqrt(n - i * i)); j++) {
                for (int k = j; k <= (int) Math.ceil(Math.sqrt(n - i * i - j * j)); k++) {
                    for (int l = k; l <= (int) Math.ceil(Math.sqrt(n - i * i - j * j - k * k)); l++) {
                        if (i * i + j * j + k * k + l * l == n) {
                            out.printf("%d %d %d %d", i, j, k, l);
                            close();
                            return;
                        }
                    }
                }
            }
        }
    }

    public static int nextInt() throws IOException {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }

        return Integer.parseInt(token.nextToken());
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
