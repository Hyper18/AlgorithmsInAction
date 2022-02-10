import java.io.*;

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
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int n = nextInt();
        long m = nextLong();
        double d = nextDouble();
        String s = nextString();

        pw.println(n);
        pw.flush();
        pw.println(m);
        pw.flush();
        pw.println(d);
        pw.flush();
        pw.write(s);
        pw.flush();

        closeAll();
    }

    public static int nextInt() throws Exception {
        st.nextToken();
        return (int) st.nval;
    }

    public static long nextLong() throws Exception {
        st.nextToken();
        return (long) st.nval;
    }

    public static double nextDouble() throws Exception {
        st.nextToken();
        return st.nval;
    }

    public static String nextString() throws Exception {
        return br.readLine();
    }

    public static void closeAll() throws Exception {
        br.close();
        pw.close();
    }
}
