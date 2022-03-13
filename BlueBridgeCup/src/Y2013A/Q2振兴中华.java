package Y2013A;

/**
 * @author Hyperspace
 * @date 2022/03/13
 * dp
 */
public class Q2振兴中华 {
    public static void main(String[] args) {
        int ans = f(0, 0);
        System.out.println(ans);
    }

    static int f(int i, int j) {
        if (i == 3 || j == 4) {
            return 1;
        }
        return f(i + 1, j) + f(i, j + 1);
    }
}
