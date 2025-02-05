package Array;

/**
 * @author Hyper
 * @date 2023/10/20
 * @file M2525_根据规则将箱子分类.java
 * <p>
 * 思路
 * 模拟
 */
public class M2525_根据规则将箱子分类 {
    final int N = (int) 1e4, M = 100, V = (int) 1e9;

    public String categorizeBox(int a, int b, int c, int mass) {
        boolean isHeavy = mass >= M,
                isBulky = (a >= N || b >= N || c >= N) || (long) a * b * c >= V;
        if (isHeavy && isBulky) {
            return "Both";
        } else if (isHeavy) {
            return "Heavy";
        } else if (isBulky) {
            return "Bulky";
        } else {
            return "Neither";
        }
    }
}
