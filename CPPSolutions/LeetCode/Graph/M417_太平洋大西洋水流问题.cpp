using namespace std;

#include <vector>

static const int dirs[4][2] = {{-1, 0},
                               {1,  0},
                               {0,  -1},
                               {0,  1}};

class Solution {
public:
    vector<vector<int>> grid;
    int m, n;

    void dfs(int x, int y, vector<vector<bool>> &reachable) {
        reachable[x][y] = true;
        for (auto &dir: dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            }
            if (grid[x][y] <= grid[nx][ny] && !reachable[nx][ny]) {
                dfs(nx, ny, reachable);
            }
        }
    }

    vector<vector<int>> pacificAtlantic(vector<vector<int>> &heights) {
        this->grid = heights;
        m = grid.size();
        n = grid[0].size();
        vector <vector<bool>> reachP(m, vector<bool>(n, false));
        vector <vector<bool>> reachA(m, vector<bool>(n, false));

        int len = m > n ? m : n;
        for (int i = 0; i < len; i++) {
            if (i < m) {
                dfs(i, 0, reachP);
                dfs(i, n - 1, reachA);
            }
            if (i < n) {
                dfs(0, i, reachP);
                dfs(m - 1, i, reachA);
            }
        }

        vector <vector<int>> res;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (reachP[i][j] && reachA[i][j]) {
                    vector<int> output;
                    output.emplace_back(i);
                    output.emplace_back(j);
                    res.emplace_back(output);
                }
            }
        }

        return res;
    }
};
