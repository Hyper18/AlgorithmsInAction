#include <vector>

using namespace std;

class Solution {
public:
    vector<int> shuffle(vector<int> &nums, int n) {
        int len = n * 2;
        vector<int> res(len);
        for (int i = 0; i < len; i += 2) {
            res[i] = nums[i / 2];
            res[i + 1] = nums[n + i / 2];
        }
        return res;
    }
};
