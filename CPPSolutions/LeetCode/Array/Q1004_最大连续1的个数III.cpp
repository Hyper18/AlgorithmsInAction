#include <bits\stdc++.h>

using namespace std;

const int N = 1e5 + 10;
int pre[N];

class Solution {
public:
    int longestOnes(vector<int> &nums, int k) {
        int n = nums.size();
        int ans = 0, cnt = 0, l = 0, r = 0;
        while (r < n) {
            if (nums[r] == 0) {
                cnt++;
            }
            r++;
            while (cnt > k) {
                if (nums[l] == 0) {
                    cnt--;
                }
                l++;
            }
            ans = max(ans, r - l);
        }

        return ans;
    }

    int longestOnes2(vector<int> &nums, int k) {
        int n = nums.size();
        for (int i = 1; i <= n; i++) pre[i] = pre[i - 1] + nums[i - 1];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int low = 0, high = i;
            while (low < high) {
                int mid = low + ((high - low) >> 1);
                if (check(pre, mid, i, k)) high = mid;
                else low = mid + 1;
            }
            if (check(pre, high, i, k)) ans = max(ans, i - high + 1);
        }

        return ans;
    }

    bool check(int pre[], int l, int r, int k) {
        int tot = pre[r + 1] - pre[l], cnt = r - l + 1;
        return cnt - tot <= k;
    }
};