package String;

/**
 * @author Hyper
 * @date 2023/03/18
 * @file M1616_分割两个字符串得到回文串.java
 * <p>
 * 思路
 * 1. 双指针，不操作数组
 * 先匹配两串两侧的最长匹配，再匹配两串的中间部分是否为回文串
 * 1）check(a, b) 左指针从A的头位置开始向右，右指针从B的尾位置开始向左
 * 2）check(b, a) 左指针从A的尾位置开始向左，右指针从B的头位置开始向右
 * 对于情况1，对应的是求s(A前缀+B后缀)是否为回文串
 * 此时已匹配的A前缀 = B后缀，因此可再分别比较两串的中间部分
 * 1）比较a串的中间部分
 * 对于子情况1，延长A的前缀
 * 2）比较b串的中间部分
 * 对于子情况2，延长B的前缀
 * 若i与j尚未重合就结束，则不为回文串
 * <p>
 * 类似地，对于情况2，对应的是求s(B前缀+A后缀)是否为回文串
 * 此时已匹配的B前缀 = A后缀，因此可再分别比较两串的中间部分
 * 1）比较a串的中间部分
 * 对于子情况1，延长B的前缀
 * 2）比较b串的中间部分
 * 对于子情况2，延长A的前缀
 * 若i与j尚未重合就结束，则不为回文串
 * 2. 双指针，操作数组（TLE)
 * 每次判断的是 A前缀+B后缀逆 B前缀+A后缀逆 两种情况，且多了每次处理子串的消耗
 */
public class M1616_分割两个字符串得到回文串 {
    public boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    private boolean check(String a, String b) {
        int n = a.length(), i, j;
        for (i = 0, j = n - 1; i < j; i++, j--) {
            if (a.charAt(i) != b.charAt(j)) {
                break;
            }
        }
        return isPalindromeFormation(a, i, j) || isPalindromeFormation(b, i, j);
    }

    private boolean isPalindromeFormation(String s, int i, int j) {
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }

        return i >= j;
    }

    public boolean checkPalindromeFormation2(String a, String b) {
        int n = a.length();
        for (int i = 0; i <= n; i++) {
            String ss1 = a.substring(0, i) + b.substring(i);
            String ss2 = b.substring(0, i) + a.substring(i);
            if (check2(ss1) || check2(ss2)) {
                return true;
            }
        }

        return false;
    }

    private boolean check2(String s) {
        int n = s.length();
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}
