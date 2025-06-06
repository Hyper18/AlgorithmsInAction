package DisjointSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Hyper
 * @date 2022/03/05，2025/02/05
 */
public class Q128_最长连续序列 {
    class UnionFind {
        private Map<Integer, Integer> pre;
        private Map<Integer, Integer> cnt;

        public UnionFind(int[] nums) {
            pre = new HashMap<>();
            cnt = new HashMap<>();

            for (int num : nums) {
                pre.put(num, num);
                cnt.put(num, 1);
            }
        }

        public Integer find(int key) {
            if (!pre.containsKey(key)) {
                return null;
            }

            while (key != pre.get(key)) {
                pre.put(key, pre.get(pre.get(key)));
                key = pre.get(key);
            }

            return key;
        }

        public int union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return cnt.get(rootX);
            }

            pre.put(rootX, rootY);
            cnt.put(rootY, cnt.get(rootX) + cnt.get(rootY));

            return cnt.get(rootY);
        }
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        UnionFind uf = new UnionFind(nums);

        int ans = 1;
        for (int num : nums) {
            if (uf.find(num + 1) != null) {
                ans = Math.max(ans, uf.union(num, num + 1));
            }
        }

        return ans;
    }

    public int longestConsecutive2(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for (int num : nums) {
            st.add(num);
        }
        int ans = 0;
        for (int num : st) {
            if (st.contains(num - 1)) {
                continue;
            }
            int ne = num + 1;
            while (st.contains(ne)) {
                ne++;
            }
            ans = Math.max(ans, ne - num);
        }

        return ans;
    }
}
