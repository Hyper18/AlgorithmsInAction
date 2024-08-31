#include <vector>

using namespace std;

class Solution {
public:
    vector<int> searchRange(vector<int> &nums, int target) {
        int n = nums.size();
        vector<int> res;
        int l = binarySearchL(nums, 0, n - 1, target);
        int r = binarySearchR(nums, 0, n - 1, target);

        return l <= r && (nums[l] == target && nums[r] == target) ? vector<int>{l, r} : vector<int>{-1, -1};
    }

    int binarySearchL(vector<int> &a, int l, int r, int t) {
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (a[m] >= t) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    int binarySearchR(vector<int> &a, int l, int r, int t) {
        while (l < r) {
            int m = l + ((r - l + 1) >> 1);
            if (a[m] <= t) {
                l = m;
            } else {
                r = m - 1;
            }
        }

        return r;
    }
};