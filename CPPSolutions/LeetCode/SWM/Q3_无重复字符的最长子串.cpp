#include <bits\stdc++.h>
#include <unordered_set>

using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int n = s.length();
        map<char, int> map;
        int ans = 0, l = 0, r = 0;
        while (r < n) {
            char c = s[r];
            if (map.find(c) != map.end()) l = max(l, map[c] + 1);
            ans = max(ans, r - l + 1);
            map[c] = r++;
        }

        return ans;
    }

    int lengthOfLongestSubstring2(string s) {
        int n = s.length();
        unordered_set<char> set;
        int ans = 0, l = 0, r = 0;
        while (r < n) {
            char c = s[r];
            if (set.find(c) != set.end()) set.erase(s[l++]);
            ans = max(ans, r - l + 1);
            set.insert(s[r++]);
        }

        return ans;
    }
};