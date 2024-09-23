#include <bits/stdc++.h>

using namespace std;

/**
 * @author Hyperspace
 * @date 2024/09/23
 * @file Q62_不同路径.cpp
 */
class Solution {
public:
    int uniquePaths(int m, int n) {
        int f[m][n];
        for (int j = 0; j < n; j++) f[0][j] = 1;
        for (int i = 1; i < m; i++) f[i][0] = 1;
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                f[i][j] = f[i - 1][j] + f[i][j - 1];

        return f[m - 1][n - 1];
    }

    int uniquePaths2(int m, int n) {
        vector<int> f(n, 1);
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                f[j] += f[j - 1];

        return f[n - 1];
    }
};