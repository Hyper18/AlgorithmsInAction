#include <bits/stdc++.h>

using namespace std;

/**
 * @author Hyper
 * @date 2024/09/01
 * @file Q600_不含连续1的非负整数.cpp
 */
class Solution {
public:
    int findIntegers(int n) {
        int m = log2(n) + 1, memo[m][2];
        memset(memo, -1, sizeof(memo));
        auto f = [&](auto &&f, int i, bool pre, bool isLimit) -> int {
            if (i == m) return 1;
            if (!isLimit && memo[i][pre] != -1) return memo[i][pre];
            int up = isLimit ? (n >> m - 1 - i) & 1 : 1;
            int ans = f(f, i + 1, 0, isLimit && up == 0);
            if (up == 1 && up != pre)
                ans += f(f, i + 1, 1, isLimit);
            if (!isLimit) memo[i][pre] = ans;

            return ans;
        };

        return f(f, 0, 0, 1);
    }
};