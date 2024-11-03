package BitOp;

/**
 * @author Hyperspace
 * @date 2024/11/02
 * @file M3226_使两个整数相等的位更改次数.java
 * <p>
 * 思路
 * 1. 模拟
 * 2. 位运算
 * 检查n & k = k，若不符合则说明 存在(n & 1) == 0 && (k & 1) == 1的情况
 * 此时再检查n ^ k为1的数目，即为需要修改的总次数
 */
public class M3226_使两个整数相等的位更改次数 {
    public int minChanges(int n, int k) {
        int ans = 0;
        while (n > 0 || k > 0) {
            if ((n & 1) == 0 && (k & 1) == 1) {
                return -1;
            }
            if ((n & 1) == 1 && (k & 1) == 0) {
                ans++;
            }
            n >>= 1;
            k >>= 1;
        }

        return ans;
    }

    public int minChanges2(int n, int k) {
        return (n & k) != k ? -1 : Integer.bitCount(n ^ k);
    }
}
