#include <bits\stdc++.h>

using namespace std;

const int N = 32;

class Solution {
public:
    int findKOr(vector<int>& nums, int k) {
        int ans = 0;
        for (int i = 0; i < N - 1; i++) {
            int cnt = 0;
            for (int x : nums) {
                cnt += x >> i & 1;
            }
            ans |= cnt >= k ? 1 << i : 0;
        }

        return ans;
    }
};