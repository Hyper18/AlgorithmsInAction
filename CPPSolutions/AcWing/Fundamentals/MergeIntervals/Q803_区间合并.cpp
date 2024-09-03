#include <bits/stdc++.h>

using namespace std;

typedef pair<int, int> PII;

/**
 * @author Hyperspace
 * @date 2024/09/03
 * @file Q803_区间合并.cpp
 */
const int N = -2e9;

void merge(vector<PII> &segs) {
    vector<PII> res;
    sort(segs.begin(), segs.end());
    int st = N, ed = st;
    for (auto seg: segs) {
        if (ed < seg.first) {
            if (st != N) res.emplace_back(st, ed);
            st = seg.first, ed = seg.second;
        } else ed = max(ed, seg.second);
    }
    if (st != N) res.emplace_back(st, ed);
    segs = res;
}

int main() {
    int n;
    cin >> n;
    vector<PII> segs;
    for (int i = 0; i < n; i++) {
        int l, r;
        cin >> l >> r;
        segs.emplace_back(l, r);
    }
    merge(segs);
    cout << segs.size() << endl;

    return 0;
}