package TwoPointer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2023/08/26
 * @file M228_汇总区间.java
 * <p>
 * 思路
 * 双指针
 * 1) 麻烦一点的写法
 * 2) 优雅一点的写法
 */
public class M228_汇总区间 {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return new ArrayList<>();
        } else if (n == 1) {
            res.add(String.valueOf(nums[0]));
            return res;
        }
        int l = 0;
        for (int r = 1; r < n; r++) {
            if (nums[r] - nums[r - 1] != 1) {
                if (r - l == 1) {
                    res.add(String.valueOf(nums[r - 1]));
                } else {
                    res.add(nums[l] + "->" + nums[r - 1]);
                }
                l = r;
            }
        }
        if (nums[n - 1] - nums[n - 2] == 1) {
            res.add(nums[l] + "->" + nums[n - 1]);
        } else {
            res.add(String.valueOf(nums[n - 1]));
        }

        return res;
    }

    public List<String> summaryRanges2(int[] nums) {
        int n = nums.length;
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < n; r++) {
            sb.setLength(0);
            sb.append(nums[r]);
            int l = r;
            while (r < n - 1 && nums[r + 1] - nums[r] == 1) {
                r++;
            }
            if (l != r) {
                sb.append("->").append(nums[r]);
            }
            res.add(sb.toString());
        }

        return res;
    }
}
