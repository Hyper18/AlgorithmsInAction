#include <bits/stdc++.h>

using namespace std;

typedef long long LL;

/**
 * @author Hyperspace
 * @date 2024/09/25
 * @file M2306_公司命名.cpp
 */
class Solution {
public:
    LL distinctNames(vector<string> &ideas) {
        unordered_set<string> st[26];
        for (auto &s: ideas) st[s[0] - 'a'].insert(s.substr(1));
        LL ans = 0;
        for (int i = 1, cnt; i < 26; i++) {
            for (int j = 0; j < i; j++) {
                cnt = 0;
                for (auto &s: st[i])
                    if (st[j].find(s) != st[j].end())
                        cnt++;
                ans += (st[i].size() - cnt) * (st[j].size() - cnt);
            }
        }

        return ans << 1;
    }
};