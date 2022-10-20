/**
 * @author Hyperspace
 * @date 2022/10/20
 * <p>
 * 思路
 * 逐层向上递归
 * e为当前行位数
 * 1. k在左半边 k不变
 * 2. k在右半边 k取反
 * <p>
 * 解二
 * 找规律，来自官解
 * 2i位 == i
 * 2i+1位 == 1 ^ i
 * 只需要看 k 这个数字是否是奇数，是就累计一次反转，重复直至 k 为 0
 * 则问题转化为，求出 k 的二进制表示中为1的位数数目，奇数则1，偶数则0
 * <p>
 * 注意：k 是从索引 1 开始
 */
public class M779_第K个语法符号 {
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int e = 1 << (n - 2);
        if (k - 1 < e) {
            return kthGrammar(n - 1, k);
        }

        return 1 ^ kthGrammar(n - 1, k - e);
    }

    public int kthGrammar2(int n, int k) {
        return Integer.bitCount(k - 1) & 1;
    }
}
