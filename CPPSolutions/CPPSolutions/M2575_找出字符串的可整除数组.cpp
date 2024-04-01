#include <bits\stdc++.h>

using namespace std;

typedef long long LL;

class Solution {
public:
    vector<int> divisibilityArray(string word, int m) {
        vector<int> res;
        LL num = 0;
        for (auto& w : word) {
            num = (num * 10 + w - '0') % m;
            res.push_back(num == 0 ? 1 : 0);
        }

        return res;
    }
};
