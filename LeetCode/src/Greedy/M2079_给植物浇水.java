package Greedy;

/**
 * @author Hyper
 * @date 2024/05/08
 * @file M2079_给植物浇水.java
 * <p>
 * 思路
 * 贪心
 */
public class M2079_给植物浇水 {
    public int wateringPlants(int[] plants, int capacity) {
        int n = plants.length;
        int ans = 0, v = capacity;
        for (int i = 0; i < n; i++, ans++) {
            if (v < plants[i]) {
                ans += (i << 1);
                v = capacity;
            }
            v -= plants[i];
        }

        return ans;
    }

    public int wateringPlants2(int[] plants, int capacity) {
        int n = plants.length;
        int ans = n, v = capacity;
        for (int i = 0; i < n; i++) {
            if (v < plants[i]) {
                ans += (i << 1);
                v = capacity;
            }
            v -= plants[i];
        }

        return ans;
    }
}
