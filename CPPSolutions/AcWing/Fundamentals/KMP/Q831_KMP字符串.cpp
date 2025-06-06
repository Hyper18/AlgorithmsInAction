#include <bits/stdc++.h>

using namespace std;

/**
 * @author Hyper
 * @date 2024/12/18
 * @file Q831_KMP字符串.cpp
 *
 * 这里的p+1相当于从p数组的下标1位置开始赋值
 */
const int N = 1e5 + 10, M = 1e6 + 10;

int n, m;
int ne[N];
char s[M], p[N];

int main() {
    cin >> n >> (p + 1) >> m >> (s + 1);
    for (int i = 2, j = 0; i <= n; i++) {
        while (j && p[i] != p[j + 1]) j = ne[j];
        if (p[i] == p[j + 1]) j++;
        ne[i] = j;
    }
    for (int i = 1, j = 0; i <= m; i++) {
        while (j && s[i] != p[j + 1]) j = ne[j];
        if (s[i] == p[j + 1]) j++;
        if (j == n) {
            printf("%d ", i - n);
            j = ne[j];
        }
    }

    return 0;
}