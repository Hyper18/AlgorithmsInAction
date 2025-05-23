using namespace std;

#include <algorithm>

class Solution {
public:
    int binaryGap(int n) {
        int ans = 0, last = -1;
        for (int i = 0; n > 0; i++) {
            if ((n & 1) == 1) {
                if (last != -1) {
                    ans = max(ans, i - last);
                }
                last = i;
            }
            n >>= 1;
        }

        return ans;
    }
};