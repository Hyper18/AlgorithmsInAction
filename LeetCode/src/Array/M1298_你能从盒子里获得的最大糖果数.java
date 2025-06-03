package Array;

/**
 * @author Hyperspace
 * @date 2025/06/03
 * @file M1298_你能从盒子里获得的最大糖果数.java
 * <p>
 * 思路@灵茶山艾府
 * dfs
 */
public class M1298_你能从盒子里获得的最大糖果数 {
    private int[] status, candies;
    private int[][] keys, containedBoxes;
    private boolean[] hasBox;
    private int ans;

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        this.status = status;
        this.candies = candies;
        this.containedBoxes = containedBoxes;
        this.keys = keys;
        int n = status.length;
        hasBox = new boolean[n];
        for (int x : initialBoxes) {
            hasBox[x] = true;
        }
        for (int x : initialBoxes) {
            if (hasBox[x] && status[x] == 1) {
                dfs(x);
            }
        }

        return ans;
    }

    private void dfs(int i) {
        ans += candies[i];
        hasBox[i] = false;
        for (int y : keys[i]) {
            status[y] = 1;
            if (hasBox[y]) {
                dfs(y);
            }
        }
        for (int j : containedBoxes[i]) {
            hasBox[j] = true;
            if (status[j] == 1) {
                dfs(j);
            }
        }
    }
}
