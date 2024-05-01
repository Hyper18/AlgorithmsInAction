package Graph;

/**
 * @author Hyperspace
 * @date 2024/04/13
 * @file M2924_找到冠军II.java
 * <p>
 * 思路
 * 模拟，统计出度
 * 找出度为0的节点
 * 若存在多个，则显然不符合题意
 */
public class M2924_找到冠军II {
    public int findChampion(int n, int[][] edges) {
        int[] deg = new int[n];
        for (int[] edge : edges) {
            deg[edge[1]]++;
        }
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) {
                if (ans == -1) {
                    ans = i;
                } else {
                    return -1;
                }
            }
        }

        return ans;
    }
}
