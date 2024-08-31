#include <bits/stdc++.h>

using namespace std;

typedef long long LL;

/**
 * @author Hyperspace
 * @date 2024/08/21
 * @file M3007_价值和小于等于K的最大数字.cpp
 */
class Solution {
public:
    LL findMaximumNumber(LL k, int x) {
        auto check = [&](LL num) {
            int m = log2(num) + 1;
            vector<vector<LL>> memo(m, vector<LL>(m, -1));
            auto f = [&](auto &&f, int i, int cnt, bool isLimit) -> LL {
                if (i < 0) return cnt;
                if (!isLimit && memo[i][cnt] != -1) return memo[i][cnt];
                int up = isLimit ? num >> i & 1 : 1;
                LL ans = 0;
                for (int d = 0; d <= up; d++)
                    ans += f(f, i - 1, cnt + (d == 1 && (i + 1) % x == 0), isLimit && d == up);
                if (!isLimit) memo[i][cnt] = ans;

                return ans;
            };

            return f(f, m - 1, 0, true) <= k;
        };

        LL low = 0, high = (k + 1) << x;
        while (low + 1 < high) {
            LL mid = low + ((high - low) >> 1);
            (check(mid) ? low : high) = mid;
        }

        return low;
    }
};