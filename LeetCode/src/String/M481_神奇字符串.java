package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2022/10/31
 * <p>
 * 思路
 * 模拟，复杂度O(n)
 */
public class M481_神奇字符串 {
    public int magicalString(int n) {
        List<Integer> str = new ArrayList<>(Arrays.asList(1, 2, 2));
        int i = 2;
        while (str.size() < n) {
            int lastNum = str.get(str.size() - 1);
            int cur = 3 - lastNum;
            for (int j = 0; j < str.get(i); j++) {
                str.add(cur);
            }
            i++;
        }

        int ans = 0;
        for (int j = 0; j < n; j++) {
            if (str.get(j) == 1) {
                ans++;
            }
        }

        return ans;
    }
}
