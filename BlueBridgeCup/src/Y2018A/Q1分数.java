package Y2018A;

/**
 * @author Hyperspace
 * @date 2022/04/03
 * <p>
 * 标题：分数
 * <p>
 * 1/1 + 1/2 + 1/4 + 1/8 + 1/16 + ....
 * 每项是前一项的一半，如果一共有20项,
 * 求这个和是多少，结果用分数表示出来。
 * 类似：
 * 3/2
 * 当然，这只是加了前2项而已。分子分母要求互质。
 * <p>
 * 注意：
 * 需要提交的是已经约分过的分数，中间任何位置不能含有空格。
 * 请不要填写任何多余的文字或符号。
 */
public class Q1分数 {
    public static void main(String[] args) {
        int u = 1, d = 1;
        for (int i = 1; i < 20; i++) {
            d *= 2;
            u += d;
        }
        System.out.printf("%d/%d", u / gcd(u, d), d / gcd(u, d));
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
