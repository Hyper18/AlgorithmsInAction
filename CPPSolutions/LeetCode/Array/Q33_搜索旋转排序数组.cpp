#include <stdio.h> 
#include <vector>

using namespace std;

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int len = nums.size();
        int low = 0, high = len - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] >= nums[low]) {
                if (nums[mid] > target && target >= nums[low]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            else {
                if (nums[high] >= target && target > nums[mid]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        
        return -1;
    }

    int search2(vector<int>& nums, int target) {
        int len = nums.size();
        int low = 0, high = len - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < nums[high]) {
                if (nums[high] >= target && target > nums[mid]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
            else {
                if (nums[mid] > target && target >= nums[low]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }
};
