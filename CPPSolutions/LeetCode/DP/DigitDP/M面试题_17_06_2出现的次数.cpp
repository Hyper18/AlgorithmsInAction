#include <bits/stdc++.h>

using namespace std;

/**
 * @author Hyper
 * @date 2024/09/01
 * @file M面试题_17_06_2出现的次数.cpp
 */
class Solution {
public:
    int numberOf2sInRange(int n) {
        auto s = to_string(n);
        int m = s.length(), memo[m][m];
        memset(memo, -1, sizeof(memo));
        function<int(int, int, bool)> f = [&](int i, int cnt, bool isLimit) -> int {
            if (i == m) return cnt;
            if (!isLimit && memo[i][cnt] != -1) return memo[i][cnt];
            int ans = 0;
            int up = isLimit ? s[i] - '0' : 9;
            for (int d = 0; d <= up; d++)
                ans += f(i + 1, cnt + (d == 2), isLimit && d == up);
            if (!isLimit) memo[i][cnt] = ans;

            return ans;
        };

        return f(0, 0, 1);
    }
};