package BitOp;

/**
 * @author Hyper
 * @date 2025/02/20
 * @file M2595_奇偶位数.java
 * <p>
 * 思路
 * 1. 二进制模拟
 * 2. 优化切换奇偶@灵茶山艾府
 */
public class M2595_奇偶位数 {
    public int[] evenOddBit(int n) {
        int[] res = new int[2];
        int cnt = 0;
        while (n > 0) {
            res[cnt % 2] += n & 1;
            n >>= 1;
            cnt++;
        }

        return res;
    }

    public int[] evenOddBit2(int n) {
        int[] res = new int[2];
        for (int i = 0; n > 0; n >>= 1) {
            res[i] += n & 1;
            i ^= 1;
        }

        return res;
    }
}
