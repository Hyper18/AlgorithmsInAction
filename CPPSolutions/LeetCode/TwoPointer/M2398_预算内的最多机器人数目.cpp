#include <bits/stdc++.h>

using namespace std;

typedef long long LL;

/**
 * @author Hyperspace
 * @date 2024/09/13
 * @file M2398_预算内的最多机器人数目.cpp
 */

class Solution {
public:
    int maximumRobots(vector<int> &chargeTimes, vector<int> &runningCosts, LL budget) {
        int n = chargeTimes.size();
        deque<int> q;
        long sum = 0;
        int ans = 0, l = 0, r = 0;
        while (r < n) {
            while (!q.empty() && chargeTimes[r] >= chargeTimes[q.back()]) q.pop_back();
            q.push_back(r);
            sum += runningCosts[r];
            while (!q.empty() && chargeTimes[q.front()] + (r - l + 1) * sum > budget) {
                if (l == q.front()) q.pop_front();
                sum -= runningCosts[l++];
            }
            ans = max(ans, r++ - l + 1);
        }

        return ans;
    }
};