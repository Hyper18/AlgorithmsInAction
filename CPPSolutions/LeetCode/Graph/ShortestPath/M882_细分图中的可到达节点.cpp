#include <bits\stdc++.h>

using namespace std;

const int INF = 0x3f3f3f3f;

class Solution {
public:
    using PII = pair<int, int>;

    int reachableNodes(vector<vector<int>> &edges, int maxMoves, int n) {
        vector<vector<PII>> g(n);
        for (auto e: edges) {
            g[e[0]].emplace_back(e[1], e[2] + 1); // 替换为cnt + 1的新边
            g[e[1]].emplace_back(e[0], e[2] + 1);
        }

        // spfa
        vector<int> dist(n, INF);
        vector<bool> st(n);
        queue<int> q;
        q.push(0);
        st[0] = true;
        dist[0] = 0;
        while (q.size()) {
            auto p = q.front();
            q.pop();
            st[p] = false;
            for (auto &pos: g[p]) {
                int v = pos.first, w = pos.second;
                if (dist[v] > dist[p] + w) {
                    dist[v] = dist[p] + w;
                    if (!st[v]) {
                        st[v] = true;
                        q.push(v);
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++)
            if (dist[i] <= maxMoves)
                ans++;

        for (auto e: edges) {
            int u = e[0], v = e[1], c = e[2];
            int a = max(0, maxMoves - dist[u]), b = max(0, maxMoves - dist[v]);
            ans += min(c, a + b);
        }

        return ans;
    }
};