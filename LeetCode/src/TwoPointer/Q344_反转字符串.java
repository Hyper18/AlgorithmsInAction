package TwoPointer;

/**
 * @author Hyperspace
 * @date 2022/02/14
 * <p>
 * 思路
 * 双指针
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
}
