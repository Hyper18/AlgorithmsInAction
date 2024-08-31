#include <bits\stdc++.h>

using namespace std;

const int N = 1e5 + 10;

class Solution {
public:
    vector<int> nums;
    bool f[N];

    bool validPartition(vector<int> &nums) {
        this->nums = nums;
        int n = nums.size();
        f[0] = true;
        for (int i = 1; i < n; i++)
            if (f[i - 1] && con1(i) || i > 1 && f[i - 2] && (con2(i) || con3(i)))
                f[i + 1] = true;

        return f[n];
    }

    bool con1(int i) {
        return nums[i] == nums[i - 1];
    }

    bool con2(int i) {
        return nums[i] == nums[i - 1] && nums[i] == nums[i - 2];
    }

    bool con3(int i) {
        return nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2;
    }
};