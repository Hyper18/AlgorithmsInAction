#include <bits/stdc++.h>

using namespace std;

/**
 * @author Hyper
 * @date 2024/09/17
 * @file M815_公交路线.cpp
 */
class Solution {
public:
    int numBusesToDestination(vector<vector<int>> &routes, int source, int target) {
        int n = routes.size();
        unordered_map<int, vector<int>> g;
        for (int i = 0; i < n; i++)
            for (int j: routes[i])
                g[j].push_back(i);
        unordered_map<int, int> d;
        queue<int> q;
        d[source] = 0;
        q.push(source);
        while (!q.empty()) {
            int p = q.front(), cur = d[p];
            q.pop();
            for (int i: g[p]) {
                for (int j: routes[i]) {
                    if (d.find(j) == d.end()) {
                        d[j] = cur + 1;
                        q.push(j);
                    }
                }
                routes[i].clear();
            }
        }

        return (d.find(target) == d.end()) ? -1 : d[target];
    }
};