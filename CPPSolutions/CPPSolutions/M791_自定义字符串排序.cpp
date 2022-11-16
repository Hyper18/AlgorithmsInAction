#include <bits\stdc++.h>

using namespace std;

class Solution {
public:
    string customSortString(string order, string s) {
        int cnt[26];
        memset(cnt, 0, sizeof cnt);
        for (auto& c : s) cnt[c - 'a']++;
        string res;
        for (auto& c : order) while (cnt[c - 'a']-- > 0) res += c;
        for (int i = 0; i < 26; i++) while (cnt[i]-- > 0) res += i + 'a';

        return res;
    }

    // 使用string()直接累加同一字母
    string customSortString2(string order, string s) {
        int cnt[26];
        memset(cnt, 0, sizeof cnt);
        for (auto& c : s) cnt[c - 'a']++;
        string res;
        for (auto& c : order) {
            if (cnt[c - 'a'] > 0) {
                res += string(cnt[c - 'a'], c);
                cnt[c - 'a'] = 0;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                res += string(cnt[i], i + 'a');
                cnt[i] = 0;
            }
        }

        return res;
    }

    // 换用vector定义
    string customSortString3(string order, string s) {
        vector<int> cnt(26);
        for (auto& c : s) cnt[c - 'a']++;
        string res;
        for (auto& c : order) while (cnt[c - 'a']-- > 0) res += c;
        for (int i = 0; i < 26; i++) while (cnt[i]-- > 0) res += i + 'a';

        return res;
    }

    // 自定义排序，按权重升序排列
    string customSortString4(string order, string s) {
        vector<int> weight(26);
        for (int i = 0; i < order.size(); i++) weight[order[i] - 'a'] = i + 1;
        sort(s.begin(), s.end(), [&](char c0, char c1) {
            return weight[c0 - 'a'] < weight[c1 - 'a'];
        });

        return s;
    }
};