import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyper
 * @date 2022/02/10
 * 思路
 * 暴力嵌套循环枚举，分子和分母的最大公约数为1表示其互质，是为最简分数。
 * 1. 辗转相除法 -> while实现
 * 2. 辗转相除法 -> 递归实现
 */
public class M1447_最简分数 {
    public static int gcd(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a %= b;
            } else {
                b %= a;
            }
        }
        return a + b;
    }

    public List<String> simplifiedFractions(int n) {
        StringBuilder sb;
        List<String> ans = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (gcd(j, i) == 1) {
                    sb = new StringBuilder();
                    sb.append(j).append("/").append(i);
                    ans.add(j + "/" + i);
                }
            }
        }
        return ans;
    }

    public static int gcd2(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public List<String> simplifiedFractions2(int n) {
        StringBuilder sb;
        if (n == 1) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        for (int i = 2; i <= n; i += 1) {
            sb = new StringBuilder();
            sb.append(1).append("/").append(i);
            ans.add(sb.toString());
        }
        for (int i = 2; i <= n; i += 1) {
            for (int j = i + 1; j <= n; j += 1) {
                if (gcd2(j, i) == 1) {
                    sb = new StringBuilder();
                    sb.append(i).append("/").append(j);
                    ans.add(sb.toString());
                }
            }
        }
        return ans;
    }
}
