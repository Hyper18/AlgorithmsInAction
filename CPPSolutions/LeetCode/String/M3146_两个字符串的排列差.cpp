#include <bits/stdc++.h>

using namespace std;

typedef long long LL;

/**
 * @author Hyper
 * @date 2024/08/24
 * @file M3146_两个字符串的排列差.cpp
 */
class Solution {
public:
    int findPermutationDifference(string s, string t) {
        int n = s.size();
        int ans = 0;
        for (int i = 0; i < n; i++) ans += abs(i - (int) t.find(s[i]));

        return ans;
    }

    int findPermutationDifference2(string s, string t) {
        int n = s.size();
        int ans = 0, pos[26];
        for (int i = 0; i < n; i++) pos[s[i] - 'a'] = i;
        for (int i = 0; i < n; i++) ans += abs(i - pos[t[i] - 'a']);

        return ans;
    }

    int findPermutationDifference3(string s, string t) {
        int n = s.size();
        vector<int> pos(26);
        int ans = 0;
        for (int i = 0; i < n; i++) pos[s[i] - 'a'] = i;
        for (int i = 0; i < n; i++) ans += abs(i - pos[t[i] - 'a']);

        return ans;
    }
};