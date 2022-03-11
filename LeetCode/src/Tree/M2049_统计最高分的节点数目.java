package Tree;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2022/03/11
 */
public class M2049_统计最高分的节点数目 {
    int[] parents;
    long max = 0;
    int ans = 0, len;

    public int countHighestScoreNodes(int[] parents) {
        this.parents = parents;
        len = parents.length;

        int[] lefts = new int[len];
        int[] rights = new int[len];
        Arrays.fill(lefts, -1);
        Arrays.fill(rights, -1);

        for (int i = 1; i < len; i++) {
            if (lefts[parents[i]] == -1) {
                lefts[parents[i]] = i;
            } else {
                rights[parents[i]] = i;
            }
        }

        dfs(0, lefts, rights);

        return ans;
    }

    private int dfs(int node, int[] lefts, int[] rights) {
        if (node == -1) {
            return 0;
        }

        int left = dfs(lefts[node], lefts, rights);
        int right = dfs(rights[node], lefts, rights);
        int res = len - 1 - left - right;

        long currMax = cal(left) * cal(right) * cal(res);
        if (currMax == max) {
            ans++;
        } else if (currMax > max) {
            ans = 1;
            max = currMax;
        }

        return left + right + 1;
    }

    private long cal(int count) {
        return count == 0 ? 1 : count;
    }
}
