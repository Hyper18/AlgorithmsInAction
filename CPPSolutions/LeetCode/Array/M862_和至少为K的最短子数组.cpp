#include <bits\stdc++.h>

using namespace std;

class Solution {
public:
    int shortestSubarray(vector<int> &nums, int k) {
        int n = nums.size();
        // long
        vector<long> preSum(n + 1);
        for (int i = 1; i <= n; i++) preSum[i] = preSum[i - 1] + nums[i - 1];

        deque<int> q;
        int ans = n + 1;
        for (int i = 0; i <= n; i++) {
            while (!q.empty() && preSum[i] - preSum[q.front()] >= k) {
                ans = min(ans, i - q.front());
                q.pop_front();
            }
            while (!q.empty() && preSum[q.back()] >= preSum[i]) q.pop_back();

            q.push_back(i);
        }

        return ans > n ? -1 : ans;
    }
};
