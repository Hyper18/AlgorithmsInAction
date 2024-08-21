#include <bits\stdc++.h>

using namespace std;

class Solution {
public:
    int longestSubarray(vector<int>& nums, int limit) {
        int n = nums.size();
        deque<int> qMin, qMax;
        int ans = 0, l = 0, r = 0;
        while (r < n) {
            while (!qMin.empty() && qMin.back() > nums[r]) qMin.pop_back();
            while (!qMax.empty() && qMax.back() < nums[r]) qMax.pop_back();
            qMin.push_back(nums[r]), qMax.push_back(nums[r]);
            while (!qMin.empty() && !qMax.empty() && qMax.front() - qMin.front() > limit) {
                if (nums[l] == qMin.front()) qMin.pop_front();
                if (nums[l] == qMax.front()) qMax.pop_front();
                l++;
            }
            ans = max(ans, r - l + 1);
            r++;
        }

        return ans;
    }
};