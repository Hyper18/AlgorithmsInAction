#include <bits\stdc++.h>
#include <unordered_map>

using namespace std;

class Solution {
public:
    string minWindow(string s, string t) {
        int n1 = s.size(), n2 = t.size();
        unordered_map<char, int> mp1, mp2;
        for (auto &c: t) mp2[c]++;
        string ans;
        int cnt = 0, l = 0, r = 0;
        while (r < n1) {
            if (++mp1[s[r]] <= mp2[s[r]]) cnt++;
            while (l < r && mp1[s[l]] > mp2[s[l]]) mp1[s[l++]]--;
            if (cnt == n2) {
                if (ans.empty() || ans.size() > r - l + 1) ans = s.substr(l, r - l + 1);
            }
            r++;
        }

        return ans;
    }
};