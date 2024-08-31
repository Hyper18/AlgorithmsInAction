#include <vector>

using namespace std;

const int N = 1010;
int f[N][N];

class Solution {
public:
    int findLength(vector<int> &nums1, vector<int> &nums2) {
        int n1 = nums1.size(), n2 = nums2.size();
        int ans = 0;
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                f[i][j] = nums1[i] == nums2[j] ? f[i + 1][j + 1] + 1 : 0;
                ans = max(ans, f[i][j]);
            }
        }

        return ans;
    }
};