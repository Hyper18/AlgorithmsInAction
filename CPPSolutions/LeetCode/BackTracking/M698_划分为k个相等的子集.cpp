#include <bits/stdc++.h>

using namespace std;

/**
 * @author Hyper
 * @date 2024/08/25
 * @file M698_划分为k个相等的子集.cpp
 *
 * 数组操作：
 * 1. 降序排序
 * sort(nums.rbegin(), nums.rend());
 * C++11引入，STL中rbegin、rend分别是指向数组尾部和（逻辑上）前一个元素的反向迭代器
 * 2. 数组求和
 * accumulate(nums.begin(), nums.end(), 0)
 * 位于numeric库
 * - first：指向容器中第一个元素的迭代器
 * - last：指向容器中最后一个元素之后的位置的迭代器
 * - init：累加的初始值
 * 3. 数组求积
 * 类似2
 * accumulate(nums.begin(), nums.end(), 1, multiplies<int>());
 */
class Solution {
private:
    int target;
    bool ans;

    void backtrack(vector<int> &pos, vector<int> &nums, int k, int i) {
        if (i == nums.size()) {
            ans = true;
            return;
        }
        for (int idx = 0; idx < k; idx++) {
            if (pos[idx] + nums[i] > target || (idx > 0 && pos[idx] == pos[idx - 1])) continue;
            pos[idx] += nums[i];
            backtrack(pos, nums, k, i + 1);
            pos[idx] -= nums[i];
        }
    }

public:
    bool canPartitionKSubsets(vector<int> &nums, int k) {
        int sum = accumulate(nums.begin(), nums.end(), 0);
        if (sum % k != 0) return false;
        target = sum / k;
        sort(nums.rbegin(), nums.rend());
        vector<int> pos(k);
        backtrack(pos, nums, k, 0);

        return ans;
    }
};