#include <bits/stdc++.h>

using namespace std;

/**
 * @author Hyper
 * @date 2024/09/11
 * @file M2555_两个线段获得的最多奖品.cpp
 */
class Solution {
public:
    int maximizeWin(vector<int> &prizePositions, int k) {
        int n = prizePositions.size();
        int ans = 0, pre[n + 1];
        memset(pre, 0, sizeof(pre));
        for (int l = 0, r = 0; r < n; r++) {
            while (prizePositions[r] - prizePositions[l] > k) l++;
            ans = max(ans, pre[l] + r - l + 1);
            pre[r + 1] = max(pre[r], r - l + 1);
        }

        return ans;
    }
};