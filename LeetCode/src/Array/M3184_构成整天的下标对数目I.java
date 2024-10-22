package Array;

/**
 * @author Hyperspace
 * @date 2024/10/22
 * @file M3184_构成整天的下标对数目I.java
 */
public class M3184_构成整天的下标对数目I {
    public int countCompleteDayPairs(int[] hours) {
        int n = hours.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((hours[i] + hours[j]) % 24 == 0) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
