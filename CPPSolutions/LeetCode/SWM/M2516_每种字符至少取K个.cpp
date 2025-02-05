#include <bits/stdc++.h>

using namespace std;

/**
 * @author Hyper
 * @date 2024/09/27
 * @file M2516_每种字符至少取K个.cpp
 */
class Solution {
public:
    int takeCharacters(string s, int k) {
        int n = s.size();
        int cnt[3];
        for (auto &c: s) cnt[c - 'a']++;
        if (cnt[0] < k || cnt[1] < k || cnt[2] < k) return -1;
        int l = 0, r = 0, len = 0;
        while (r < n) {
            cnt[s[r++] - 'a']--;
            if (cnt[0] < k || cnt[1] < k || cnt[2] < k) cnt[s[l++] - 'a']++;
            else len = max(len, r - l);
        }

        return n - len;
    }
};