#include <bits\stdc++.h>
#include <vector>

using namespace std;

class Solution {
public:
    int ans = 0;

    int numOfMinutes(int n, int headID, vector<int>& manager, vector<int>& informTime) {
        vector<vector<int>> g(n);
        for (int i = 0; i < n; i++)
            if (manager[i] > -1)
                g[manager[i]].push_back(i);
        dfs(g, informTime, headID, 0);

        return ans;
    }

    void dfs(vector<vector<int>>& g, vector<int>& informTime, int cur, int sum) {
        sum += informTime[cur];
        ans = max(ans, sum);
        for (int e : g[cur])
            dfs(g, informTime, e, sum);
    }
};