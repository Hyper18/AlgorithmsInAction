#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    int totalFruit(vector<int> &fruits) {
        unordered_map<int, int> cnt;
        int n = fruits.size();
        int ans = 0;
        for (int l = 0, r = 0; r < n; r++) {
            cnt[fruits[r]]++;
            while (cnt.size() > 2) {
                auto it = cnt.find(fruits[l]);
                it->second--;
                if (it->second == 0)
                    cnt.erase(it);
                l++;
            }
            ans = max(ans, r - l + 1);
        }

        return ans;
    }
};