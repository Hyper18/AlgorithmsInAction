#include <bits\stdc++.h>

using namespace std;

class Solution {
public:
    bool check(vector<int> &nums) {
        int n = nums.size();
        int l = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                l = i;
                break;
            }
        }
        if (!l) return true;
        for (int i = l + 1; i < n; i++)
            if (nums[i - 1] > nums[i])
                return false;

        return nums[0] >= nums[n - 1];
    }
};