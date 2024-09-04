#include <bits/stdc++.h>

using namespace std;

/**
 * @author Hyperspace
 * @date 2024/09/04
 * @file M2860_让所有学生保持开心的分组方法数.cpp
 */
class Solution {
public:
    int countWays(vector<int> &nums) {
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int ans = 1;
        for (int i = n - 1; i > 0; i--)
            ans += nums[i] > i && nums[i - 1] < i;

        return nums[0] ? ans + 1 : ans;
    }
};