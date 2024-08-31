#include <bits/stdc++.h>

using namespace std;

/**
 * @author Hyperspace
 * @date 2024/08/30
 * @file M3153_所有数对中数位不同之和.cpp
 */
class Solution {
    typedef long long LL;
public:
    LL sumDigitDifferences(vector<int> &nums) {
        int n = nums.size();
        long ans = 0;
        while (nums[0] > 0) {
            int mp[10];
            memset(mp, 0, sizeof(mp));
            for (int i = 0; i < n; i++) {
                mp[nums[i] % 10]++;
                nums[i] /= 10;
            }
            for (auto &c: mp) ans += c == 0 ? 0 : (long) c * (n - c);
        }

        return ans >> 1;
    }
};