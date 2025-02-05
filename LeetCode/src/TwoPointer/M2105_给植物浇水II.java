package TwoPointer;

/**
 * @author Hyper
 * @date 2024/05/09
 * @file M2105_给植物浇水II.java
 * <p>
 * 思路
 * 模拟，双指针
 */
public class M2105_给植物浇水II {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n = plants.length;
        int ans = 0, l = 0, r = n - 1, lv = capacityA, rv = capacityB;
        while (l < r) {
            if (lv < plants[l]) {
                lv = capacityA;
                ans++;
            }
            if (rv < plants[r]) {
                rv = capacityB;
                ans++;
            }
            lv -= plants[l++];
            rv -= plants[r--];
        }

        return n % 2 == 1 && lv < plants[l] && rv < plants[l] ? ans + 1 : ans;
    }
}
