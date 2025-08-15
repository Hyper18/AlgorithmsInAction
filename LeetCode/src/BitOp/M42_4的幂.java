package BitOp;

/**
 * @author Hyper
 * @date 2025/08/15
 * @file M42_4的幂.java
 */
public class M42_4的幂 {
    public boolean isPowerOfFour(int n) {
        while (n > 1) {
            if (n % 4 != 0) {
                return false;
            }
            n >>= 2;
        }

        return n == 1;
    }
}
