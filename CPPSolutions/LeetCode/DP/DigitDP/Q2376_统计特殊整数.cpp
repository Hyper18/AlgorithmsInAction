#include <bits/stdc++.h>

using namespace std;

/**
 * @author Hyper
 * @date 2024/08/21
 * @file Q2376_统计特殊整数.cpp
 */
class Solution {
public:
    int countSpecialNumbers(int n) {
        auto s = to_string(n);
        int m = s.length(), memo[m][1 << 10];
        memset(memo, -1, sizeof(memo));
        function<int(int, int, bool, bool)> f = [&](int i, int mask, bool isLimit, bool isNum) -> int {
            if (i == m) return isNum;
            if (!isLimit && isNum && memo[i][mask] != -1) return memo[i][mask];
            int ans = 0;
            if (!isNum) ans = f(i + 1, mask, 0, 0);
            int up = isLimit ? s[i] - '0' : 9;
            for (int d = 1 - isNum; d <= up; d++)
                if ((mask >> d & 1) == 0)
                    ans += f(i + 1, mask | (1 << d), isLimit && d == up, 1);
            if (!isLimit && isNum) memo[i][mask] = ans;

            return ans;
        };

        return f(0, 0, 1, 0);
    }
};

//// test case example
//int main() {
//    Solution s;
//    cout << s.countSpecialNumbers(20) << endl;
//
//    return 0;
//}