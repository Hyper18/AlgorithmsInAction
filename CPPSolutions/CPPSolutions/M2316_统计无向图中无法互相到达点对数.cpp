#include <bits\stdc++.h>

using namespace std;

typedef long long LL;

class Solution {
public:
    LL countPairs(int n, vector<vector<int>>& edges) {
        vector<vector<int>> g(n);
        vector<bool> vis(n);
        for (auto& e : edges) g[e[0]].push_back(e[1]), g[e[1]].push_back(e[0]);
        LL ans = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            LL cnt = 0;
            queue<int> q;
            q.push(i);
            vis[i] = true;
            while (!q.empty()) {
                auto p = q.front();
                cnt++;
                q.pop();
                for (int ne : g[p]) {
                    if (vis[ne]) continue;
                    vis[ne] = true;
                    q.push(ne);
                }
            }
            ans += cnt * (n - cnt);
        }

        return ans >> 1;
    }
};