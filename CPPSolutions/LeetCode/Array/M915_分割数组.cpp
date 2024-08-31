#include <bits\stdc++.h>

using namespace std;

const int N = 100010;

int f[N];

class Solution {
public:
    int partitionDisjoint(vector<int> &nums) {
        int n = nums.size();
        f[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) f[i] = min(f[i + 1], nums[i]);
        int m = 0;
        for (int i = 0; i < n; i++) {
            m = max(m, nums[i]);
            if (m <= f[i + 1]) return i + 1;
        }

        return n;
    }

    int partitionDisjoint2(vector<int> &nums) {
        int n = nums.size();
        int m = 0, left = nums[0], idx = 0;
        for (int i = 0; i < n; i++) {
            m = max(m, nums[i]);
            if (left > nums[i]) {
                left = m;
                idx = i;
            }
        }

        return idx + 1;
    }
};