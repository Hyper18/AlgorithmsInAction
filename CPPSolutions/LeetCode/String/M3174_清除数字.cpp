#include <bits/stdc++.h>

using namespace std;

/**
 * @author Hyperspace
 * @date 2024/09/05
 * @file M3174_清除数字.cpp
 */
class Solution {
public:
    string clearDigits(string s) {
        string ans;
        for (auto c: s) {
            if (!ans.empty() && isdigit(c)) {
                ans.pop_back();
                continue;
            }
            ans += c;
        }

        return ans;
    }
};