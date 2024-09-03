#include <bits/stdc++.h>

using namespace std;

typedef long long LL;

/**
 * @author Hyperspace
 * @date 2024/09/03
 * @file M2708_一个小组的最大实力值.cpp
 */
class Solution {
public:
    LL maxStrength(vector<int> &nums) {
        int n = nums.size();
        LL mn = nums[0], mx = mn, t, s;
        for (int i = 1; i < n; i++) {
            t = mn, s = nums[i];
            mn = min(min(mn, s), min(mn * s, mx * s));
            mx = max(max(mx, s), max(t * s, mx * s));
        }

        return mx;
    }
};