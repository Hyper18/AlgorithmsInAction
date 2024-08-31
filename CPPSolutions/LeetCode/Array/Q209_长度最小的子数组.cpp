#include <vector>
#include <climits>

using namespace std;

class Solution {
public:
    int minSubArrayLen(int target, vector<int> &nums) {
        int n = nums.size();
        vector<int> preSum(n + 1, 0);
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int ans = INT_MAX;
        for (int i = 1; i <= n; i++) {
            int curTarget = target + preSum[i - 1];
            auto bound = lower_bound(preSum.begin(), preSum.end(), curTarget); // lower_bound返回大于等于key的首个值的位置
            if (bound != preSum.end()) {
                ans = min(ans, static_cast<int>((bound - preSum.begin()) - i + 1)); // static_cast用于转换类型，其安全性由开发人员保证
            }
        }

        return ans == INT_MAX ? 0 : ans;
    }
};