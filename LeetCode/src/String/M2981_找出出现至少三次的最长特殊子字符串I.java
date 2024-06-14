package String;

/**
 * @author Hyperspace
 * @date 2024/05/29
 * @file M2981_找出出现至少三次的最长特殊子字符串I.java
 * <p>
 * 思路
 * SWM，二分
 * <p>
 * 重点cnt[k] += Math.max(0, j - i - x + 1)
 * -mid+1后，表示能够分割成子串的数目
 */
public class M2981_找出出现至少三次的最长特殊子字符串I {
    private String s;
    private int n;

    public int maximumLength(String s) {
        this.s = s;
        n = s.length();
        int low = 0, high = n;
        while (low < high) {
            int mid = low + ((high - low + 1) >> 1);
            if (check(mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low == 0 ? -1 : low;
    }

    private boolean check(int x) {
        int[] cnt = new int[26];
        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            int k = s.charAt(i) - 'a';
            cnt[k] += Math.max(0, j - i - x + 1);
            if (cnt[k] >= 3) {
                return true;
            }
            i = j;
        }
        return false;
    }
}
