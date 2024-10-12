#include <bits/stdc++.h>

using namespace std;

typedef long long LL;

/**
 * @author Hyperspace
 * @date 2024/10/12
 * @file M3158_求出出现两次数字的XOR值.cpp
 */
class Solution {
public:
    int duplicateNumbersXOR(vector<int> &nums) {
        int ans = 0;
        LL vis = 0;
        for (int num: nums) {
            if (vis >> num & 1) ans ^= num;
            else vis |= 1L << num;
        }

        return ans;
    }
};