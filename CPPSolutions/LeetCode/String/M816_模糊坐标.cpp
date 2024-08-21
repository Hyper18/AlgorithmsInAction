#include <bits\stdc++.h>

using namespace std;

class Solution {
public:
    vector<string> ambiguousCoordinates(string s) {
        vector<string> res;
        s = s.substr(1, s.size() - 2);
        int n = s.length();
        for (int i = 1; i < n; i++) {
            vector<string> sx = split(s.substr(0, i)), sy = split(s.substr(i));
            for (auto& x : sx) {
                for (auto& y : sy) {
                    res.push_back("(" + x + ", " + y + ")");
                }
            }
        }

        return res;
    }

    vector<string> split(string s) {
        vector<string> res;
        int n = s.length();
        if (n == 1) {
            res.push_back(s);
            return res;
        }

        if (s.front() == '0' && s.back() == '0') return res;
        if (s.front() == '0') {
            res.push_back(string("0.") + s.substr(1));
            return res;
        }
        if (s.back() == '0') {
            res.push_back(s);
            return res;
        }

        res.push_back(s);
        for (int i = 1; i < n; i++) {
            res.push_back(s.substr(0, i) + '.' + s.substr(i));
        }

        return res;
    }
};