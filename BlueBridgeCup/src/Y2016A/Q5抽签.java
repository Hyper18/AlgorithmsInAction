package Y2016A;

/**
 * @author Hyperspace
 * @date 2022/03/25
 * <p>
 * X星球要派出一个5人组成的观察团前往W星。
 * 其中：
 * A国最多可以派出4人。
 * B国最多可以派出2人。
 * C国最多可以派出2人。
 * …
 * <p>
 * 那么最终派往W星的观察团会有多少种国别的不同组合呢？
 * <p>
 * 下面的程序解决了这个问题。
 * 数组a[] 中既是每个国家可以派出的最多的名额。
 * 程序执行结果为：
 * DEFFF
 * CEFFF
 * CDFFF
 * CDEFF
 * CCFFF
 * CCEFF
 * CCDFF
 * CCDEF
 * BEFFF
 * BDFFF
 * BDEFF
 * BCFFF
 * BCEFF
 * BCDFF
 * BCDEF
 * …
 * (以下省略，总共101行)
 * <p>
 * 思路
 * 分析递归参数的含义，及其变化方向
 */
public class Q5抽签 {
    public static void f(int[] a, int k, int n, String s) {
        if (k == a.length) {
            if (n == 0) System.out.println(s);
            return;
        }

        String s2 = s;
        for (int i = 0; i <= a[k]; i++) {
            f(a, k + 1, n - i, s2);   //填空位置
            s2 += (char) (k + 'A');
        }
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 2, 1, 1, 3};

        f(a, 0, 5, "");
    }
}
