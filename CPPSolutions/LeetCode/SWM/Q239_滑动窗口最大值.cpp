#include <bits\stdc++.h>

using namespace std;

class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        int n = nums.size();
        priority_queue<pair<int, int>> pq;
        for (int i = 0; i < k; i++) pq.emplace(nums[i], i);
        vector<int> res = { pq.top().first };
        for (int i = k; i < n; i++) {
            pq.emplace(nums[i], i);
            while (pq.top().second <= i - k) pq.pop();
            res.push_back(pq.top().first);
        }

        return res;
    }
};