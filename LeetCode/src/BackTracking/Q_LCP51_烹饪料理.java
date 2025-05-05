package BackTracking;

/**
 * @author Hyperspace
 * @date 2025/05/04
 * @file Q_LCP51_烹饪料理.java
 * <p>
 * 思路
 * 回溯
 */
public class Q_LCP51_烹饪料理 {
    private int[] materials;
    private int[][] cookbooks, attribute;
    private int ans = -1, limit;

    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        this.materials = materials;
        this.cookbooks = cookbooks;
        this.attribute = attribute;
        this.limit = limit;
        backtrack(0, 0, 0);

        return ans;
    }

    private void backtrack(int i, int x, int y) {
        if (i == cookbooks.length) {
            if (y >= limit) {
                ans = Math.max(ans, x);
            }
            return;
        }
        for (int j = i; j < cookbooks.length; j++) {
            if (check(j)) {
                for (int k = 0; k < materials.length; k++) {
                    materials[k] -= cookbooks[j][k];
                }
                backtrack(j + 1, x + attribute[j][0], y + attribute[j][1]);
                for (int k = 0; k < materials.length; k++) {
                    materials[k] += cookbooks[j][k];
                }
            } else {
                backtrack(j + 1, x, y);
            }
        }
    }

    private boolean check(int i) {
        for (int k = 0; k < materials.length; k++) {
            if (materials[k] < cookbooks[i][k]) {
                return false;
            }
        }

        return true;
    }
}
