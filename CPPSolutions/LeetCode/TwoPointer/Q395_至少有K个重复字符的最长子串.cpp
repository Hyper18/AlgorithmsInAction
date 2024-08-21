#include <bits\stdc++.h>

using namespace std;

class Solution {
public:
    int cnts[26];

    int longestSubstring(string s, int k) {
        int n = s.length();
        int ans = 0;
        for (int l = 0; l < n - k + 1; l++) {
            int r = l;
            memset(cnts, 0, sizeof(cnts));
            while (r < n) {
                char c = s[r];
                cnts[c - 'a']++;
                if (r - l + 1 >= k && check(k)) {
                    ans = max(ans, r - l + 1);
                }
                r++;
            }
        }

        return ans;
    }

    bool check(int k) {
        for (auto& cnt : cnts) {
            if (cnt != 0 && cnt < k) {
                return false;
            }
        }
        return true;
    }
};