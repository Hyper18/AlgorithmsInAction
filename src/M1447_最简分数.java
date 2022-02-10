import java.util.ArrayList;
import java.util.List;

/**
 * @date 2022/02/10
 * tzy 思路
 * 先说操作步骤，然后再讲这么做的原理是什么
 * 若两数相等则一定不互质
 * 若两数不等，分别为a和b，不妨设a>b
 * 则a和b的最大公约数就是b和a%b的最大公约数
 * 递归进行，若 a%b=0时，则返回b
 * 下面解释每一步的意思和原理，这里主要说明一下第3步的原理
 * 在纸上一长一短两条直线，长的代表a，短的代表b
 * 在两条线段上各从头开始截取长度相等的线段p(线段长度代表最大公约数,但要确保两条直线都能正好被截取完)
 * 那么两数的约去最大公约数得到的最简互质数对就是两条直线上线段的个数
 * 当a对b进行求余操作时(a是大的数)，余下来的那部分的线段个数和b的线段个数依然互质(可用反证法来证明)，且余下来的那部分线段和b依然可以整除线段长度p，而p是a和b的最大公约数，因此p也是余下的那部分直线长度（即a%b）和b的最大公约数
 * 而b一定大于等于a%b，因此可以将b当作长直线，a%b当作短直线进入下一轮递归
 * 当较长的那根直线长度正好是较短那根直线长度的整数倍时候（即a%b=0时），就代表较短直线上的线段只有一个了，而较长的直线上的线段个数有若干个，两线段数互质，所以可直接返回较短直线的长度就是最大公约数
 */
public class M1447_最简分数 {
    public static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    public List<String> simplifiedFractions(int n) {
        if (n == 1) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        for (int i = 2; i <= n; i += 1) {
            ans.add(1 + "/" + i);
        }
        for (int i = 2; i <= n; i += 1) {
            for (int j = i + 1; j <= n; j += 1) {
                int gcd = gcd(j, i);
                if (gcd == 1) {
                    ans.add(i + "/" + j);
                }
            }
        }
        return ans;
    }
}
