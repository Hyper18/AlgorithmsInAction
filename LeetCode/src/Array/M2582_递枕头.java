package Array;

/**
 * @author Hyper
 * @date 2023/09/26
 * @file M2582_递枕头.java
 * <p>
 * 思路
 * 模拟
 * 最开始枕头位于第1个人手中，故每轮长实际为n - 1
 * 分类讨论：
 * 1. 正向
 * pos(n) = k + 1
 * 2. 反向
 * pos(n) = n - 1 - (k - 1) = n - k
 */
public class M2582_递枕头 {
    public int passThePillow(int n, int time) {
        int b = time / (n - 1), k = time % (n - 1);
        return b % 2 == 0 ? k + 1 : n - k;
    }
}
