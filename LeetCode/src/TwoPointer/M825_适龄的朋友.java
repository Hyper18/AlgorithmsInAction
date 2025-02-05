package TwoPointer;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2024/11/17
 * @file M825_适龄的朋友.java
 * <p>
 * 思路
 * 1. 模拟 TLE
 * 2. 双指针
 */
public class M825_适龄的朋友 {
    public int numFriendRequests(int[] ages) {
        int n = ages.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    continue;
                }
                if (!check(ages[i], ages[j])) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private boolean check(int a, int b) {
        return b <= 0.5 * a + 7 || b > a;
    }

    public int numFriendRequests2(int[] ages) {
        int n = ages.length;
        Arrays.sort(ages);
        int ans = 0, l = 0, r = 0;
        for (int age : ages) {
            if (age < 15) {
                continue;
            }
            while (ages[l] <= 0.5 * age + 7) {
                l++;
            }
            while (r + 1 < n && ages[r + 1] <= age) {
                r++;
            }
            ans += r - l;
        }

        return ans;
    }
}
