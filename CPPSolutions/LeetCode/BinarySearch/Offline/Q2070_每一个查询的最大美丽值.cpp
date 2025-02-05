#include <bits/stdc++.h>

using namespace std;

/**
 * @author Hyper
 * @date 2024/12/16
 * @file Q2070_每一个查询的最大美丽值.cpp
 */
class Solution {
public:
    vector<int> maximumBeauty(vector<vector<int>> &items, vector<int> &queries) {
        int n = items.size(), k = queries.size();
        sort(items.begin(), items.end(), [](const vector<int> &a, const vector<int> &b) {
            return a[0] < b[0];
        });
        for (int i = 1; i < n; i++) items[i][1] = max(items[i][1], items[i - 1][1]);
        for (int i = 0; i < k; i++) binarySearch(items, queries[i]);

        return queries;
    }

    void binarySearch(vector<vector<int>> &nums, int &target) {
        int low = 0, high = nums.size();
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid][0] <= target) low = mid + 1;
            else high = mid;
        }
        target = low - 1 >= 0 ? nums[low - 1][1] : 0;
    }
};
