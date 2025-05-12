package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Hyperspace
 * @date 2025/05/12
 * @file M2094_找出3位偶数.java
 * <p>
 * 思路
 * 1. 枚举
 * 2. 回溯
 */
public class M2094_找出3位偶数 {
    class Solution {
        public int[] findEvenNumbers(int[] digits) {
            int n = digits.length;
            Set<Integer> st = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (digits[i] == 0) {
                    continue;
                }
                for (int j = 0; j < n; j++) {
                    if (j == i) {
                        continue;
                    }
                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j || (digits[k] & 1) != 0) {
                            continue;
                        }
                        st.add(digits[i] * 100 + digits[j] * 10 + digits[k]);
                    }
                }
            }

            return st.stream().mapToInt(i -> i).sorted().toArray();
        }
    }

    class Solution2 {
        private List<Integer> res = new ArrayList<>();
        private int[] cnt = new int[10];

        public int[] findEvenNumbers(int[] digits) {
            for (int i : digits) {
                cnt[i]++;
            }
            dfs(0, 0);

            return res.stream().mapToInt(i -> i).toArray();
        }

        private void dfs(int i, int x) {
            if (i == 3) {
                res.add(x);
                return;
            }
            for (int j = 0; j < cnt.length; j++) {
                if (cnt[j] > 0 && (i == 0 && j > 0 || i == 1 || i == 2 && j % 2 == 0)) {
                    cnt[j]--;
                    dfs(i + 1, x * 10 + j);
                    cnt[j]++;
                }
            }
        }
    }
}
