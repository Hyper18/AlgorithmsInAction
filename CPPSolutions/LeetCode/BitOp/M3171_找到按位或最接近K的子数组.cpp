#include <bits/stdc++.h>

using namespace std;

/**
 * @author Hyper
 * @date 2024/10/09
 * @file M3171_找到按位或最接近K的子数组.cpp
 */
class Solution {
public:
    int minimumDifference(vector<int> &nums, int k) {
        int n = nums.size();
        int ans = INT_MAX;
        for (int i = 0; i < n; i++) {
            int t = nums[i];
            ans = min(ans, abs(t - k));
            for (int j = i - 1; j >= 0 && (nums[j] | t) != nums[j]; j--) {
                nums[j] |= t;
                ans = min(ans, abs(nums[j] - k));
            }
        }

        return ans;
    }
};