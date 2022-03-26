package Y2016A;

/**
 * @author Hyperspace
 * @date 2022/03/25
 */
public class Q1煤球数目 {
    public static void main(String[] args) {
        int base = 1;
        int ans = base;
        for (int i = 2; i <= 100; i++) {
            base += i;
            ans += base;
        }
        System.out.println(ans);
    }
}
