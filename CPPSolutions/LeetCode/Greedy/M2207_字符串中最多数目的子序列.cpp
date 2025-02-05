#include <bits/stdc++.h>

using namespace std;

typedef long long LL;

/**
 * @author Hyper
 * @date 2024/09/24
 * @file M2207_字符串中最多数目的子序列.cpp
 */
class Solution {
public:
    LL maximumSubsequenceCount(string text, string pattern) {
        int cnt1 = 0, cnt2 = 0;
        LL ans = 0;
        for (auto &c: text) {
            if (c == pattern[1]) {
                ans += cnt1;
                cnt2++;
            }
            if (c == pattern[0]) cnt1++;
        }

        return ans + max(cnt1, cnt2);
    }
};
