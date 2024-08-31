#include <bits\stdc++.h>

using namespace std;

class Solution {
public:
    int numMatchingSubseq(string s, vector<string> &words) {
        vector<vector<int>> pos(26);
        for (int i = 0; i < s.size(); i++) pos[s[i] - 'a'].emplace_back(i);
        int ans = 0;
        auto check = [&](string &w) {
            int idx = -1;
            for (char &c: w) {
                auto &li = pos[c - 'a'];
                int r = upper_bound(li.begin(), li.end(), idx) - li.begin();
                if (r == li.size()) return false;
                idx = li[r];
            }
            return true;
        };
        for (auto &word: words) ans += check(word);

        return ans;
    }
};