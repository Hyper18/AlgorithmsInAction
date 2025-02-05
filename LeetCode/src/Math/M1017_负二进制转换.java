package Math;

/**
 * @author Hyper
 * @date 2024/04/28
 * @file M1017_负二进制转换.java
 * <p>
 * 思路
 * 进制转换
 * 10^9数据量这么大，肯定不是开数组算完返回结果了
 * 考虑累除-2至0，拿每次余数
 * 发现会少一位，商调着调着可以了，乐
 * 为什么要调整商呢？
 * 用q表示商，r表示余数，将n表示为以下等式：
 * n = q1 * (-2) + r1
 * 为保持余数r2的范围为0到1，而不是-1到0，可以将其调整为非负数，通过加2来实现，有：
 * n = q2 * (-2) + (r2 + 2)
 * 将商q2增加1，我们可以保持等式的平衡，得：
 * n = (q2 + 1) * (-2) + (r2 + 2)
 * <p>
 * 实际写时候，可以按照程序执行的考虑优化一下
 * 此外需要注意循环条件，惯性会想写 n > 0
 */
public class M1017_负二进制转换 {
    public String baseNeg2(int n) {
        StringBuilder sb = new StringBuilder();
        int t;
        while (n != 0) {
            t = n % -2;
            n /= -2;
            if (t < 0) {
                t = -t;
                n++;
            }
            sb.append(t);
        }

        String ans = sb.reverse().toString();
        return "".equals(ans) ? "0" : ans;
    }
}
