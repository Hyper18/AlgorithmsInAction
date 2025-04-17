package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hyper
 * @date 2025/04/17
 * @file Q508_出现次数最多的子树元素和.java
 */
public class Q508_出现次数最多的子树元素和 {
    private Map<Integer, Integer> mp = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        int mx = 0;
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : mp.entrySet()) {
            if (e.getValue() >= mx) {
                if (e.getValue() > mx) {
                    res.clear();
                    mx = e.getValue();
                }
                res.add(e.getKey());
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

    private int dfs(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        if (cur.left == null && cur.right == null) {
            mp.merge(cur.val, 1, Integer::sum);
            return cur.val;
        }
        int sum = cur.val + dfs(cur.left) + dfs(cur.right);
        mp.merge(sum, 1, Integer::sum);

        return sum;
    }
}
