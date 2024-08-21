#include <cstdio>
#include <vector>

using namespace std;

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int n = nums.size();
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[mid + 1]) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }

    int findPeakElement(vector<int>& nums) {
        int n = nums.size();
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (nums[mid] > nums[mid - 1]) {
                low = mid;
            }
            else {
                high = mid - 1;
            }
        }

        return high;
    }
};