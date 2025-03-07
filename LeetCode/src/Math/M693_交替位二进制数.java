package Math;

/**
 * @author Hyper
 * @date 2022/03/28
 */
public class M693_交替位二进制数 {
    public boolean hasAlternatingBits(int n) {
        if (n == 1) {
            return true;
        }
        int pre = -1, cur = n % 2;
        n >>= 1;
        while (n > 0) {
            if (pre == cur) {
                return false;
            }
            pre = cur;
            cur = n % 2;
            n >>= 1;
        }

        return pre != cur;
    }

    public boolean hasAlternatingBits2(int n) {
        int pre = -1, cur;
        while (n != 0) {
            cur = n % 2;
            if (cur == pre) {
                return false;
            }
            pre = cur;
            n /= 2;
        }

        return true;
    }
}
