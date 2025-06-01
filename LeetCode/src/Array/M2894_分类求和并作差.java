package Array;

/**
 * @author Hyperspace
 * @date 2025/05/27
 * @file M2894_分类求和并作差.java
 */
public class M2894_分类求和并作差 {
    public int differenceOfSums(int n, int m) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += i % m == 0 ? -i : i;
        }

        return ans;
    }
}
