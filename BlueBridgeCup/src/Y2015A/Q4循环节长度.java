package Y2015A;

import java.util.Vector;

/**
 * @author Hyperspace
 * @date 2022/03/21
 */
public class Q4循环节长度 {
    public static int f(int n, int m) {
        n = n % m;
        Vector v = new Vector();
        for (; ; ) {
            v.add(n);
            n *= 10;
            n = n % m;
            if (n == 0) return 0;

            if (v.indexOf(n) >= 0) {
                return v.size() - v.indexOf(n); //填空
            }

        }
    }
}
