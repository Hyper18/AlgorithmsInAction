using namespace std;

#include <iostream>
#include <queue>

const int N = 1e5 + 10;
const int dx[] = {-1, 1, 2};

int st, ed;
int g[N], d[N];
bool vis[N];

int bfs() {
    queue<int> q;
    q.push(st);
    vis[st] = true;
    while (!q.empty()) {
        int x = q.front();
        q.pop();
        for (int i = 0; i < 3; i++) {
            int nx = dx[i] == 2 ? x * 2 : x + dx[i];
            if (nx < 0 || nx >= N || vis[nx]) continue;
            if (nx == ed) {
                return d[x] + 1;
            }
            vis[nx] = true;
            q.push(nx);
            d[nx] = d[x] + 1;
        }
    }

    return 0;
}

int main() {
    scanf("%d%d", &st, &ed);
    printf("%d", bfs());
}