using namespace std;

#include <vector>

class Solution {
public:
    int maxRotateFunction(vector<int> &nums) {
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += i * nums[i];
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        for (int i = n - 1, cur = ans; i >= 0; i--) {
            cur += sum - n * nums[i];
            ans = max(ans, cur);
        }

        return ans;
    }
};