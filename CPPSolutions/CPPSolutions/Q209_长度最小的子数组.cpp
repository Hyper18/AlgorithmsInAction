#include <cstdio>
#include <vector>

using namespace std;

class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int n = nums.size();
        vector<int> preSum(n + 1, 0);
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        
        int ans = INT_MAX;
        for (int i = 1; i <= n; i++) {
            int curTarget = target + preSum[i - 1];
            auto bound = lower_bound(preSum.begin(), preSum.end(), curTarget); // lower_bound���ش��ڵ���key���׸�ֵ��λ��
            if (bound != preSum.end()) {
                ans = min(ans, static_cast<int>((bound - preSum.begin()) - i + 1)); // static_cast����ת�����ͣ��䰲ȫ���ɿ�����Ա��֤
            }
        }

        return ans == INT_MAX ? 0 : ans;
    }
};