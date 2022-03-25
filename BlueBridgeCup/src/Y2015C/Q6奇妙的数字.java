package Y2015C;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hyperspace
 * @date 2022/03/25
 * 奇妙的数字
 * <p>
 * 小明发现了一个奇妙的数字。它的平方和立方正好把0~9的10个数字每个用且只用了一次。
 * 你能猜出这个数字是多少吗？
 * <p>
 * 请填写该数字，不要填写任何多余的内容。
 * <p>
 * 思路
 * 枚举
 * 首先应当粗略估计位数的大致范围，确定枚举的区间
 * 若该数的平方和立方位数之和不为10，则返回
 * 若符合，则通过set去重判断，有重复直接返回即可
 */
public class Q6奇妙的数字 {
    public static void main(String[] args) {
        for (int i = 10; i < 100; i++) {
            long s = (long) i * i;
            long q = (long) i * i * i;
            if (check(s, q)) {
                System.out.println(i);
                System.exit(0);
            }
        }
    }

    private static boolean check(long s, long q) {
        String s1 = String.valueOf(s);
        String s2 = String.valueOf(q);
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 + l2 != 10) {
            return false;
        }
        Set<Character> set = new HashSet<>();
        for (char c : s1.toCharArray()) {
            if (!set.add(c)) {
                return false;
            }
        }
        for (char c : s2.toCharArray()) {
            if (!set.add(c)) {
                return false;
            }
        }
        return true;
    }
}
