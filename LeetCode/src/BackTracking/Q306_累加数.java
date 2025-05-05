package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2025/05/05
 * @file Q306_累加数.java
 * <p>
 * 思路
 * 回溯
 */
public class Q306_累加数 {
    class Solution1_0 {
        private List<Integer> path = new ArrayList<>();
        private boolean ans;
        private char[] s;

        public boolean isAdditiveNumber(String num) {
            s = num.toCharArray();
            backtrack(0);

            return ans;
        }

        private void backtrack(int i) {
            if (i == s.length) {
                if (path.size() >= 3) {
                    ans = true;
                }
                return;
            }
            for (int j = i, sum = 0; j < s.length; j++) {
                if (j != i && s[i] == '0') {
                    break;
                }
                sum = sum * 10 + s[j] - '0';
                if (path.size() >= 2 && sum != path.get(path.size() - 1) + path.get(path.size() - 2)) {
                    continue;
                }
                path.add(sum);
                backtrack(j + 1);
                path.remove(path.size() - 1);
                if (ans) {
                    return;
                }
            }
        }
    }

    class Solution1_1 {
        private List<Integer> path = new ArrayList<>();
        private char[] s;

        public boolean isAdditiveNumber(String num) {
            s = num.toCharArray();
            return backtrack(0);
        }

        private boolean backtrack(int i) {
            if (path.size() >= 3) {
                int n = path.size();
                if (path.get(n - 1) != path.get(n - 2) + path.get(n - 3)) {
                    return false;
                }
            }
            if (i == s.length) {
                return path.size() >= 3;
            }
            for (int j = i, sum = 0; j < s.length; j++) {
                if (j != i && s[i] == '0') {
                    break;
                }
                sum = sum * 10 + s[j] - '0';
                path.add(sum);
                if (backtrack(j + 1)) {
                    return true;
                }
                path.remove(path.size() - 1);
            }

            return false;
        }
    }
}
