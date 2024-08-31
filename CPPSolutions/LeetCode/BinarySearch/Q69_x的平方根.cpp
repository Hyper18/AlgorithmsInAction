#include <cmath>

using namespace std;

class Solution {
public:
    int mySqrt(int x) {
        if (x == 0)
            return 0;
        int ans = exp(0.5 * log(x));
        return ((long long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans);
    }

    int mySqrt2(int x) {
        int low = 0, high = x, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((long long) mid * mid <= x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
};