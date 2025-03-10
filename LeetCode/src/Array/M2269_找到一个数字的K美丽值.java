package Array;

/**
 * @author Hyperspace
 * @date 2025/03/10
 * @file M2269_找到一个数字的K美丽值.java
 */
public class M2269_找到一个数字的K美丽值 {
    public int divisorSubstrings(int num, int k) {
        String s = Integer.toString(num);
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n - k + 1; i++) {
            int x = Integer.parseInt(s.substring(i, i + k));
            if (x != 0 && num % x == 0) {
                ans++;
            }
        }

        return ans;
    }
}
