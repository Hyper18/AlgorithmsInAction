import java.io.*;
import java.util.*;

/**
 * @author Hyper
 * @date 2022/03/07
 */
public class Main {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        if (hasNext()) {
            int n = nextInt();
            String s = next();
            long a = nextLong();
            double b = nextDouble();
            String[] ss = nextLine().split(" ");

            out.println("n: " + n);
            out.println("s: " + s);
            out.println("a: " + a);
            out.println("b: " + b);
            out.println("ss[0]: " + ss[0]);
        }

        close();
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }

    public static boolean hasNext() throws IOException {
        while (!tk.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null) {
                return false;
            }
            tk = new StringTokenizer(line);
        }
        return true;
    }

    public static int nextInt() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return Integer.parseInt(tk.nextToken());
    }

    public static String next() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return tk.nextToken();
    }

    public static String nextLine() throws IOException {
        tk = new StringTokenizer("");
        return in.readLine();
    }

    public static long nextLong() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return Long.parseLong(tk.nextToken());
    }

    public static double nextDouble() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return Double.parseDouble(tk.nextToken());
    }
}