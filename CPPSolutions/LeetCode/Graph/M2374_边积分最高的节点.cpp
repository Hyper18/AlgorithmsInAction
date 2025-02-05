#include <bits/stdc++.h>

using namespace std;

typedef long long LL;

/**
 * @author Hyper
 * @date 2024/09/21
 * @file M2374_边积分最高的节点.cpp
 */
class Solution {
public:
    int edgeScore(vector<int> &edges) {
        int n = edges.size();
        vector<LL> in(n);
        for (int i = 0; i < n; i++) in[edges[i]] += i;
        LL mx = 0;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (in[i] > mx) {
                ans = i;
                mx = in[i];
            }
        }

        return ans;
    }
};