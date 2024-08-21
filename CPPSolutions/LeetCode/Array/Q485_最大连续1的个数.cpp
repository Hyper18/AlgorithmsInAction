#include <bits\stdc++.h>

using namespace std;

class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int ans = 0, cnt = 0;
        for (int n : nums) {
            if (n == 1) {
                cnt++;
            }
            else {
                ans = max(ans, cnt);
                cnt = 0;
            }
        }

        return max(ans, cnt);
    }
};