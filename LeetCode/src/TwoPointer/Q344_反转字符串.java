package TwoPointer;

/**
 * @author Hyper
 * @date 2022/02/14，2023/08/07
 * <p>
 * 思路
 * 模拟，双指针
 */
public class Q344_反转字符串 {
    public void reverseString(char[] s) {
        int p1 = 0;
        int p2 = s.length - 1;
        while (p1 < p2) {
            swap(p1++, p2--, s);
        }
    }

    private void swap(int p1, int p2, char[] s) {
        char tmp = s[p1];
        s[p1] = s[p2];
        s[p2] = tmp;
    }

    public void reverseString2(char[] s) {
        int n = s.length;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }
}
