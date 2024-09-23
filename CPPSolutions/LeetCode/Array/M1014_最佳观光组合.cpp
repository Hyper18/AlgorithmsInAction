#include <bits/stdc++.h>

using namespace std;

/**
 * @author Hyperspace
 * @date 2024/09/23
 * @file M1014_最佳观光组合.cpp
 */
class Solution {
public:
    int maxScoreSightseeingPair(vector<int> &values) {
        int n = values.size();
        int ans = 0, mx = values[0];
        for (int j = 1; j < n; j++) {
            ans = max(ans, mx + values[j] - j);
            mx = max(mx, values[j] + j);
        }

        return ans;
    }
};