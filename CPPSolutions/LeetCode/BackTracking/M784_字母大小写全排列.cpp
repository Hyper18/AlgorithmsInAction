#include <bits\stdc++.h>

using namespace std;

class Solution {
public:
    vector<string> letterCasePermutation(string s) {
        vector<string> res;
        backtrack(s, 0, res);

        return res;
    }

    void backtrack(string &s, int idx, vector<string> &res) {
        while (idx < s.size() && isdigit(s[idx])) {
            idx++;
        }
        if (idx == s.size()) {
            res.push_back(s);
            return;
        }
        s[idx] ^= 32;
        backtrack(s, idx + 1, res);
        s[idx] ^= 32;
        backtrack(s, idx + 1, res);
    }
};