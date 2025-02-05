#include <bits/stdc++.h>

using namespace std;

typedef long long LL;

/**
 * @author Hyper
 * @date 2024/10/11
 * @file M3164_优质数对的总数II.cpp
 */
class Solution {
public:
    LL numberOfPairs(vector<int> &nums1, vector<int> &nums2, int k) {
        unordered_map<int, int> mp;
        for (int v: nums1) {
            if (v % k) continue;
            v /= k;
            for (int d = 1; d * d <= v; d++) {
                if (v % d) continue;
                mp[d]++;
                if (d * d < v) mp[v / d]++;
            }
        }
        LL ans = 0;
        for (int v: nums2) ans += mp[v];

        return ans;
    }
};