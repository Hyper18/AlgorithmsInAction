#include <bits\stdc++.h>

using namespace std;

class Solution {
public:
    int matrixSum(vector<vector<int>>& nums) {
        int m = nums.size(), n = nums[0].size();
        for (int i = 0; i < m; i++) sort(nums[i].begin(), nums[i].end());
        int ans = 0;
        for (int j = 0; j < n; j++) {
            int t = INT_MIN;
            for (int i = 0; i < m; i++) {
                if (nums[i][j] > t) {
                    t = nums[i][j];
                }
            }
            ans += t;
        }

        return ans;
    }
};