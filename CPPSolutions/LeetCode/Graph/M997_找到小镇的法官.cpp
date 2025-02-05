#include <bits/stdc++.h>

using namespace std;

/**
 * @author Hyper
 * @date 2024/09/22
 * @file M997_找到小镇的法官.cpp
 */
class Solution {
public:
    int findJudge(int n, vector<vector<int>> &trust) {
        vector<int> in(n + 1), out(n + 1);
        for (auto &e: trust) in[e[1]]++, out[e[0]]++;
        for (int i = 1; i <= n; i++)
            if (in[i] == n - 1 && out[i] == 0)
                return i;

        return -1;
    }
};