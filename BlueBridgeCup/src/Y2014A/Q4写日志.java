package Y2014A;

/**
 * @author Hyper
 * @date 2022/03/16
 */
public class Q4写日志 {
    private static int n = 1;

    public static void write(String msg) {
        String filename = "t" + n + ".log";
        // n = n == 3 ? 1 : n + 1;
        n = n % 3 + 1;
        System.out.println("write to file: " + filename + " " + msg);
    }
}
