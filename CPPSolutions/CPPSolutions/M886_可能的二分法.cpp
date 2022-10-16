#include <cstdio>
#include <vector>

using namespace std;

const int N = 2010, M = 10010 * 2;

class Solution {
public:
    int h[N], e[M], ne[M];
    int color[N];
    int idx;

    void addEdge(int a, int b) {
        e[idx] = b, ne[idx] = h[a], h[a] = idx++;
    }

    bool possibleBipartition(int n, vector<vector<int>>& dislikes) {
        memset(h, -1, sizeof h);
        for (auto& d : dislikes) {
            int a = d[0], b = d[1];
            addEdge(a, b), addEdge(b, a);
        }
        for (int i = 1; i <= n; i++)
            if (color[i] == 0)
                if (!dfs(i, 1)) return false;

        return true;
    }

    bool dfs(int u, int c) {
        color[u] = c;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (color[j] == c) return false;
            if (color[j] == 0 && !dfs(j, 3 - c)) return false;
        }

        return true;
    }
};