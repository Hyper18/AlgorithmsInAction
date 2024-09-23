#include <bits/stdc++.h>

using namespace std;

/**
 * @author Hyperspace
 * @date 2024/09/23
 * @file Q63_不同路径II.cpp
 */
class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>> &obstacleGrid) {
        int m = obstacleGrid.size(), n = obstacleGrid[0].size();
        vector<vector<int>> f(m, vector<int>(n));
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (obstacleGrid[i][j] == 1) f[i][j] = 0;
                else if (i == 0 && j == 0) f[i][j] = 1;
                else if (i == 0) f[i][j] = f[0][j - 1];
                else if (j == 0) f[i][j] = f[i - 1][0];
                else f[i][j] = f[i - 1][j] + f[i][j - 1];

        return f[m - 1][n - 1];
    }

    int uniquePathsWithObstacles2(vector<vector<int>> &obstacleGrid) {
        int n = obstacleGrid[0].size();
        vector<int> f(n);
        f[0] = obstacleGrid[0][0] ? 0 : 1;
        for (auto &obs: obstacleGrid)
            for (int j = 0; j < n; j++)
                if (obs[j]) f[j] = 0;
                else if (j - 1 >= 0 && !obs[j - 1]) f[j] += f[j - 1];

        return f[n - 1];
    }
};