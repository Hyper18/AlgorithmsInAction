#include <bits\stdc++.h>

using namespace std;

typedef long long LL;

class Solution {
public:
    LL maxArrayValue(vector<int>& nums) {
        int n = nums.size();
        LL ans = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) ans = ans >= nums[i] ? ans + nums[i] : nums[i];

        return ans;
    }
};