#include <bits\stdc++.h>
#include <unordered_map>

using namespace std;

class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        if (s1.length() > s2.length()) return false;
        int n1 = s1.length(), n2 = s2.length();
        vector<int> cnt1(26), cnt2(26);
        for (int i = 0; i < n1; i++) cnt1[s1[i] - 'a']++, cnt2[s2[i] - 'a']++;
        if (cnt1 == cnt2) return true;
        for (int i = n1; i < n2; i++) {
            cnt2[s2[i] - 'a']++, cnt2[s2[i - n1] - 'a']--;
            if (cnt1 == cnt2) return true;
        }

        return false;
    }

    int cnt1[26], cnt2[26];

    bool checkInclusion2(string s1, string s2) {
        if (s1.length() > s2.length()) return false;
        int n1 = s1.length(), n2 = s2.length();
        for (auto &c: s1) cnt1[c - 'a']++;
        int cnt = 0, l = 0, r = 0;
        while (r < n2) {
            if (cnt1[s2[r] - 'a'])
                if (++cnt2[s2[r] - 'a'] == cnt1[s2[r] - 'a'])
                    cnt++;
            if (r - l + 1 == n1) {
                int size = 0;
                for (auto &c: cnt1)
                    if (c)
                        size++;
                if (cnt == size) return true;
                if (cnt1[s2[l] - 'a'])
                    if (cnt2[s2[l] - 'a']-- == cnt1[s2[l] - 'a'])
                        cnt--;
                l++;
            }
            r++;
        }

        return false;
    }

    bool checkInclusion3(string s1, string s2) {
        if (s1.length() > s2.length()) return false;
        int n1 = s1.length(), n2 = s2.length();
        unordered_map<char, int> cnt1, cnt2;
        for (auto &c: s1) cnt1[c]++;
        int cnt = 0, l = 0, r = 0;
        while (r < n2) {
            if (cnt1.find(s2[r]) != cnt1.end())
                if (++cnt2[s2[r]] == cnt1[s2[r]])
                    cnt++;
            if (r - l + 1 == n1) {
                if (cnt == cnt1.size()) return true;
                if (cnt1.find(s2[l]) != cnt1.end())
                    if (cnt2[s2[l]]-- == cnt1[s2[l]])
                        cnt--;
                l++;
            }
            r++;
        }

        return false;
    }
};