#include <stdio.h>
#include <vector>

using namespace std;

const int N = 2510;

class Solution {
    int f[N], ans;

public:
    int lengthOfLIS(vector<int>& nums) {
        int len = nums.size();
        for (int i = 0; i < len; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j])
                    f[i] = max(f[i], f[j] + 1);
            ans = max(ans, f[i]);
        }

        return ans;
    }

    int lengthOfLIS2(vector<int>& nums) {
        int len = nums.size();
        for (int i = 0; i < len; i++) {
            int low = 0, high = ans;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (f[mid] < nums[i])
                    low = mid + 1;
                else
                    high = mid;
            }
            f[low] = nums[i];
            if (ans == high)
                ans++;
        }

        return ans;
    }
};