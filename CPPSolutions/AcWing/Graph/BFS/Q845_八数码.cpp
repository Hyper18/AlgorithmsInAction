using namespace std;

#include <iostream>
#include <queue>
#include <unordered_map>

const int N = 3;
const string STR = "12345678x";
const int dirs[4][2] = {{1,  0},
                        {0,  1},
                        {-1, 0},
                        {0,  -1}};

int bfs(string st) {
    queue <string> q;
    unordered_map<string, int> dis;
    q.push(st);
    dis[st] = 0;

    while (!q.empty()) {
        string str = q.front();
        q.pop();

        int d = dis[str];
        if (STR == str) {
            return d;
        }
        int k = str.find('x');
        int x = k / N, y = k % N;
        for (auto &dir: dirs) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }
            swap(str[k], str[nx * 3 + ny]);
            if (!dis.count(str)) {
                dis[str] = d + 1;
                q.push(str);
            }
            swap(str[k], str[nx * 3 + ny]);
        }
    }

    return -1;
}

int main() {
    char s[2];
    string str;
    for (int i = 0; i < 9; i++) {
        scanf("%s", s);
        str += *s;
    }
    printf("%d", bfs(str));
}
