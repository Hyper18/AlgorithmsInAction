import java.io.*;
import java.util.*;
import java.util.function.Function;

/**
 * @author Hyper
 * @date 2022/03/07
 */
public class MainV2 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        if (hasNext()) {
            int n = next(Integer::parseInt);
            String s = next(Function.identity());
            long a = next(Long::parseLong);
            double b = next(Double::parseDouble);
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

    public static <T> T next(Function<String, T> parser) throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return parser.apply(tk.nextToken());
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

    public static String nextLine() throws IOException {
        tk = new StringTokenizer("");
        return in.readLine();
    }
}