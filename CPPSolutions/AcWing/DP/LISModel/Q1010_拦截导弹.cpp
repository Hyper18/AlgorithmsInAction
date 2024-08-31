using namespace std;

#include <iostream>
#include <sstream>

const int N = 1010;
int h[N], f[N], q[N];
int n;

int main() {
    string line;
    getline(cin, line);
    stringstream ssin(line);
    while (ssin >> h[n]) n++;

    int ans = 0, cnt = 0;
    for (int i = 0; i < n; i++) {
        f[i] = 1;
        for (int j = 0; j < i; j++) if (h[i] <= h[j]) f[i] = max(f[i], f[j] + 1);
        ans = max(ans, f[i]);

        int k = 0;
        while (k < cnt && q[k] < h[i]) k++;
        if (k == cnt) q[cnt++] = h[i];
        else q[k] = h[i];
    }

    printf("%d\n%d", ans, cnt);
}