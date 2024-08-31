#include<bits\stdc++.h>

using namespace std;

class Solution {
public:
    int trap(vector<int> &height) {
        int n = height.size();
        int i = 1, ans = 0, hl = 0, hr = 0, l = 1, r = n - 2;
        while (i < n - 1) {
            if (height[l - 1] < height[r + 1]) {
                hl = max(hl, height[l - 1]);
                if (hl > height[l]) ans += hl - height[l];
                l++;
            } else {
                hr = max(hr, height[r + 1]);
                if (hr > height[r]) ans += hr - height[r];
                r--;
            }
            i++;
        }

        return ans;
    }
};