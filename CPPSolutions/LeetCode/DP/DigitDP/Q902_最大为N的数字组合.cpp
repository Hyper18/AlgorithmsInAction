#include <bits/stdc++.h>

using namespace std;

/**
 * @author Hyperspace
 * @date 2024/09/01
 * @file Q902_最大为N的数字组合.cpp
 */
class Solution {
public:
    int atMostNGivenDigitSet(vector<string> &digits, int n) {
        auto s = to_string(n);
        int m = s.length(), memo[m];
        memset(memo, -1, sizeof(memo));
        auto f = [&](auto &&f, int i, bool isLimit, bool isNum) -> int {
            if (i == m) return isNum;
            if (!isLimit && isNum && memo[i] != -1) return memo[i];
            int ans = 0;
            if (!isNum) ans = f(f, i + 1, 0, 0);
            char up = isLimit ? s[i] : '9';
            for (auto &d: digits)
                if (d[0] <= up)
                    ans += f(f, i + 1, isLimit && d[0] == up, 1);
            if (!isLimit && isNum) memo[i] = ans;

            return ans;
        };

        return f(f, 0, 1, 0);
    }
};