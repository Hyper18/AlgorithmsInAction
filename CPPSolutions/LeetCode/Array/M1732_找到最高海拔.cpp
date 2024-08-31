#include <bits\stdc++.h>

using namespace std;

class Solution {
public:
    int largestAltitude(vector<int> &gain) {
        int n = gain.size();
        int ans = 0, h = 0;
        for (int i = 0; i < n; i++) {
            h += gain[i];
            if (h > ans) ans = h;
        }

        return ans;
    }
};