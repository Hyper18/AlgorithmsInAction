using namespace std;
#include <vector>

class Solution {
public:
    vector<int> sortArrayByParity(vector<int>& nums) {
        int n = nums.size();
        int low = 0, high = n - 1;
        while (low < high) {
            if (nums[low] % 2 != 0) {
                swap(nums[low], nums[high]);
                high--; 
            }
            else if (nums[high] % 2 == 0) {
                swap(nums[low], nums[high]);
                low++;
            }
            else {
                low++, high--;
            }
        }

        return nums;
    }
};