#include <bits\stdc++.h>
#include <unordered_map>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int> &nums, int target) {
        int n = nums.size();
        vector<int> res;
        unordered_map<int, int> mp;
        for (int i = 0; i < n; i++) {
            int num1 = nums[i], num2 = target - num1;
            if (mp.find(num2) != mp.end()) {
                res = {mp[num2], i};
                break;
            }
            mp[num1] = i;
        }

        return res;
    }
};