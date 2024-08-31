using namespace std;

#include <iostream>
#include <algorithm>
#include <unordered_map>
#include <queue>

char g[2][4]; // 存放魔板状态
unordered_map<string, pair<char, string>> op;
unordered_map<string, int> d;

// 从字符串设置当前的面板状态
void set(string state) {
    for (int i = 0; i < 4; i++)
        g[0][i] = state[i];
    for (int i = 7, j = 0; j < 4; i--, j++)
        g[1][j] = state[i];
}

// 输出当前操作结果到字符串中
string get() {
    string ans;
    for (int i = 0; i < 4; i++)
        ans += g[0][i];
    for (int i = 3; i >= 0; i--)
        ans += g[1][i];
    return ans;
}

// 操作一：交换上下两行
string move0(string state) {
    set(state);
    for (int i = 0; i < 4; i++)
        swap(g[0][i], g[1][i]);
    return get();
}

// 操作二：将最右侧列插入到最左侧
string move1(string state) {
    set(state);
    char v0 = g[0][3], v1 = g[1][3]; // 手动swap，保存最后一列的两个数
    for (int i = 3; i > 0; i--) {
        g[0][i] = g[0][i - 1];
        g[1][i] = g[1][i - 1];
    }
    g[0][0] = v0, g[1][0] = v1; // 换回
    return get();
}

// 操作三：将中央的4个数作顺时针旋转
string move2(string state) {
    set(state);
    char v = g[0][1]; // 同上
    g[0][1] = g[1][1]; // 向上转
    g[1][1] = g[1][2]; // 向右转
    g[1][2] = g[0][2]; // 向下转
    g[0][2] = v;       // 向左转
    return get();
}

int bfs(string st, string ed) {
    if (st == ed) return 0;

    queue <string> q;
    q.push(st);
    d[st] = 0;
    while (!q.empty()) {
        auto p = q.front();
        q.pop();

        string m[3];
        m[0] = move0(p);
        m[1] = move1(p);
        m[2] = move2(p);

        for (int i = 0; i < 3; i++) {
            if (d.count(m[i])) continue;
            d[m[i]] = d[p] + 1;
            op[m[i]] = {'A' + i, p};
            q.push(m[i]);
            if (m[i] == ed) return d[ed];
        }
    }

    return -1;
}

int main() {
    int x;
    string st = "12345678", ed;
    for (int i = 0; i < 8; i++) {
        scanf("%d", &x);
        ed += char(x + '0');
    }
    int step = bfs(st, ed);
    printf("%d\n", step);
    string ans;
    while (ed != st) {
        ans += op[ed].first;
        ed = op[ed].second;
    }
    reverse(ans.begin(), ans.end());
    if (step > 0) printf("%s", ans.c_str()); // %s默认只用于输出char*
}