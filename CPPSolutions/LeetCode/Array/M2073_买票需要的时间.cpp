#include <bits/stdc++.h>

using namespace std;

/**
 * @author Hyper
 * @date 2024/09/29
 * @file M2073_买票需要的时间.cpp
 */
class Solution {
public:
    int timeRequiredToBuy(vector<int> &tickets, int k) {
        int n = tickets.size();
        int ans = 0;
        for (int i = 0; i < n; i++) ans += min(tickets[i], tickets[k] - (i > k));

        return ans;
    }
};