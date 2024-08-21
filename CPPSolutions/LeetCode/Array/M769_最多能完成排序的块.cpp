#include <cstdio>
#include <vector>

using namespace std;

class Solution {
public:
    int maxChunksToSorted(vector<int>& arr) {
        int n = arr.size();
        int t = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            t = max(t, arr[i]);
            if (t == i) {
                ans++;
            }
        }

        return ans;
    }
};