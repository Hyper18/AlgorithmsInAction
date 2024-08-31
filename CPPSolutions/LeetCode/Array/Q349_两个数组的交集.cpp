#include <bits\stdc++.h>
#include <unordered_set>

using namespace std;

class Solution {
public:
    vector<int> intersection(vector<int> &nums1, vector<int> &nums2) {
        unordered_set<int> res, nums1_set(nums1.begin(), nums1.end());
        for (int i = 0; i < nums2.size(); i++)
            if (nums1_set.find(nums2[i]) != nums1_set.end())
                res.insert(nums2[i]);

        return vector<int>(res.begin(), res.end());
    }
};