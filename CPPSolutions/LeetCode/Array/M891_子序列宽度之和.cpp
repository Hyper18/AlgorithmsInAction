#include <bits\stdc++.h>

using namespace std;

typedef long long LL;

const int N = 100010, MOD = 1e9 + 7;
LL f[N];

class Solution {
public:
    int sumSubseqWidths(vector<int> &nums) {
        int n = nums.size();
        sort(nums.begin(), nums.end());
        f[0] = 1;
        for (int i = 1; i < N; i++) f[i] = (f[i - 1] << 1) % MOD;
        LL ans = 0;
        for (int i = 0; i < n; i++) ans += (f[i] - f[n - 1 - i]) * nums[i];

        return (ans % MOD + MOD) % MOD;
    }
};