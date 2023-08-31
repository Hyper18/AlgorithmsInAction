#include <bits\stdc++.h>

using namespace std;

class Solution {
public:
    int maxAbsoluteSum(vector<int>& nums) {
        int preSum = 0, maxSum = 0, minSum = 0;
        for (auto& n : nums) {
            preSum += n;
            if (preSum > maxSum) maxSum = preSum;
            if (preSum < minSum) minSum = preSum;
        }

        return maxSum - minSum;
    }
};