package Array;

/**
 * @author Hyper
 * @date 2025/08/05
 * @file M3477_水果成篮II.java
 */
public class M3477_水果成篮II {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length, m = baskets.length;
        int ans = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (baskets[j] < fruits[i]) {
                    continue;
                }
                baskets[j] = 0;
                ans--;
                break;
            }
        }

        return ans;
    }
}
