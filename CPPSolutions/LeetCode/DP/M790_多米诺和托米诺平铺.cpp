#include <bits\stdc++.h>

using namespace std;

typedef long long LL;

class Solution {
private:
    const LL MOD = 1e9 + 7;

public:
    int numTilings(int n) {
        vector<vector<LL>> f(n + 1, vector<LL>(4));
        f[0][3] = 1;
        for (int i = 1; i <= n; i++) {
            f[i][0] = f[i - 1][3];
            f[i][1] = (f[i - 1][0] + f[i - 1][2]) % MOD;
            f[i][2] = (f[i - 1][0] + f[i - 1][1]) % MOD;
            f[i][3] = (((f[i - 1][0] + f[i - 1][1]) % MOD + f[i - 1][2]) % MOD + f[i - 1][3]) % MOD;
        }

        return f[n][3];
    }
};