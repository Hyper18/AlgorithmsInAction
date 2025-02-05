package Y2018A;

/**
 * @author Hyper
 * @date 2022/04/03
 * 计算第一象限包含的右上顶点的个数 * 4
 * <p>
 * 注意爆int
 * 2147483647 < 50000 * 50000
 * <p>
 * answer:
 * 7853781044
 */
public class Q4方格计数 {
    private static final long N = 50000;

    public static void main(String[] args) {
        long ans = 0;
        for (long i = 1; i <= N; i++) {
            for (long j = 1; j <= N; j++) {
                if (i * i + j * j <= N * N) {
                    ans++;
                }
            }
        }
        System.out.println(ans * 4);
    }
}
