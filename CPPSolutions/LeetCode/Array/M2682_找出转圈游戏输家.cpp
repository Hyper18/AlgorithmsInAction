#include <bits\stdc++.h>

using namespace std;

class Solution {
public:
    vector<int> circularGameLosers(int n, int k) {
        vector<bool> f(n, false);
        int base = 0, step = 0;
        while (!f[base]) {
            f[base] = true;
            step += k;
            base = (base + step) % n;
        }
        vector<int> res;
        for (int i = 0; i < n; i++)
            if (!f[i])
                res.emplace_back(i + 1);

        return res;
    }
};