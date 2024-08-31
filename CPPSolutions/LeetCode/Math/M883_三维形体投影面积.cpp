using namespace std;

#include <vector>
#include <algorithm>

class Solution {
public:
    int projectionArea(vector<vector<int>> &grid) {
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < grid.size(); i++) {
            int bMax = 0, cMax = 0;
            for (int j = 0; j < grid[0].size(); j++) {
                a += grid[i][j] > 0 ? 1 : 0;
                bMax = max(bMax, grid[i][j]);
                cMax = max(cMax, grid[j][i]);
            }
            b += bMax, c += cMax;
        }

        return a + b + c;
    }
};