package Y2017A;

/**
 * @author Hyperspace
 * @date 2022/03/31
 * <p>
 * 标题：字母组串
 * <p>
 * 由 A,B,C 这3个字母就可以组成许多串。
 * 比如："A","AB","ABC","ABA","AACBB" ....
 * <p>
 * 现在，小明正在思考一个问题：
 * 如果每个字母的个数有限定，能组成多少个已知长度的串呢？
 * <p>
 * 他请好朋友来帮忙，很快得到了代码，
 * 解决方案超级简单，然而最重要的部分却语焉不详。
 * <p>
 * 对于上面的测试数据，小明口算的结果应该是：
 * 6
 * 19
 */
public class Q5字母组串 {
    // a个A，b个B，c个C 字母，能组成多少个不同的长度为n的串。
    static int f(int a, int b, int c, int n) {
        if (a < 0 || b < 0 || c < 0) return 0;
        if (n == 0) return 1;

        return f(a - 1, b, c, n - 1) + f(a, b - 1, c, n - 1) + f(a, b, c - 1, n - 1);  //填空
    }

    public static void main(String[] args) {
        System.out.println(f(1, 1, 1, 2));
        System.out.println(f(1, 2, 3, 3));
    }
}
