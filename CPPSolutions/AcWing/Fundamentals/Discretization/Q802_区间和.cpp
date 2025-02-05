#include <bits/stdc++.h>

using namespace std;

typedef pair<int, int> PII;

/**
 * @author Hyper
 * @date 2024/09/02
 * @file Q802_区间和.cpp
 *
 * 离散化：将大而分散的稀疏区间映射到连续的一段较小的稠密区间里
 * 从而可以使用前缀和求连续一段的区间和
 *
 * 离散化需先排序去重
 * sort(alls.begin(), alls.end())
 * alls.erase(unique(alls.begin(), alls.end()), alls.end())
 *
 * 返回high+1：从1开始映射，1~n
 * 如果是返回high，则对应0~n-1
 *
 * N怎么来的？
 * 本题取值的数据范围为10^-9~10^9
 * 但实际使用到离散化后的是比较少的，与n,m挂钩，两者均为10^5
 * 故一共使用到的为n个x加上{l,r}的m次查询
 * 则一共需要n+2m个，为3*10^5
 */
const int N = 3e5 + 10;

int n, m;
int a[N], s[N];

vector<int> alls;
vector<PII> add, query;

int find(int target) {
    int low = 0, high = alls.size() - 1;
    while (low < high) {
        int mid = low + ((high - low) >> 1);
        if (alls[mid] >= target) high = mid;
        else low = mid + 1;
    }

    return high + 1;
}

int main() {
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        int x, c;
        cin >> x >> c;
        add.emplace_back(x, c);
        alls.push_back(x);
    }
    for (int i = 0; i < m; i++) {
        int l, r;
        cin >> l >> r;
        query.emplace_back(l, r);
        alls.push_back(l);
        alls.push_back(r);
    }
    sort(alls.begin(), alls.end());
    alls.erase(unique(alls.begin(), alls.end()), alls.end());
    for (auto item: add) {
        int x = find(item.first);
        a[x] += item.second;
    }
    for (int i = 1; i <= alls.size(); i++)
        s[i] = s[i - 1] + a[i];
    for (auto item: query) {
        int l = find(item.first), r = find(item.second);
        cout << s[r] - s[l - 1] << endl;
    }

    return 0;
}