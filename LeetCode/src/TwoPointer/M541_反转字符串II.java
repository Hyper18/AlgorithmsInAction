package TwoPointer;

/**
 * @author Hyper
 * @date 2025/01/31
 * @file M541_反转字符串II.java
 * <p>
 * 思路
 * 双指针
 */
public class M541_反转字符串II {
    public String reverseStr(String s, int k) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int i = 0; i < n; i += k << 1) {
            int l = i, r = Math.min(i + k - 1, n - 1);
            while (l < r) {
                swap(l++, r--, cs);
            }
        }

        return new String(cs);
    }

    private void swap(int i, int j, char[] s) {
        char t = s[i];
        s[i] = s[j];
        s[j] = t;
    }
}
