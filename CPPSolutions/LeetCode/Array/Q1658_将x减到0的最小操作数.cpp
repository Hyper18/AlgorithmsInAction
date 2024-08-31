#include <bits\stdc++.h>

using namespace std;

class Solution {
public:
    int pre[100010] = {0};

    int minOperations(vector<int> &nums, int x) {
        int n = nums.size();
        if (nums[0] > x && nums[n - 1] > x) return -1;
        for (int i = 1; i <= n; i++) pre[i] = pre[i - 1] + nums[i - 1];
        int ans = 0x3f3f3f3f;
        for (int i = n - 1; i >= 0 && x >= 0; x -= nums[i--]) {
            int l = -1, r = n - 1 - i, low = 0, high = i + 1;
            while (low <= high) {
                int mid = low + ((high - low) >> 1);
                if (pre[mid] == x) {
                    l = mid;
                    break;
                } else if (pre[mid] > x) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            if (l >= 0) ans = min(ans, l + r);
        }

        return ans == 0x3f3f3f3f ? -1 : ans;
    }
};