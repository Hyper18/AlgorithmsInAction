#include <bits/stdc++.h>

using namespace std;

/**
 * @author Hyperspace
 * @date 2024/09/19
 * @file M2414_最长的字母序连续子字符串的长度.cpp
 */
class Solution {
public:
    int longestContinuousSubstring(string s) {
        int n = s.length();
        int ans = 1, cnt = 1;
        for (int i = 1; i < n; i++) {
            if (s[i] - s[i - 1] == 1) cnt++;
            else {
                ans = max(ans, cnt);
                cnt = 1;
            }
        }

        return max(ans, cnt);
    }

    int longestContinuousSubstring2(string s) {
        int n = s.length();
        int f[n];
        f[0] = 1;
        for (int i = 1; i < n; i++) f[i] = s[i] - s[i - 1] == 1 == 1 ? f[i - 1] + 1 : 1;
        int mx = 0;
        for (int i = 0; i < n; i++)
            if (f[i] > mx)
                mx = f[i];

        return mx;
    }
};
