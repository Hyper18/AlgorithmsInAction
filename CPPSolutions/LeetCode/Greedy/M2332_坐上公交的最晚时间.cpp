#include <bits/stdc++.h>

using namespace std;

/**
 * @author Hyperspace
 * @date 2024/09/18
 * @file M2332_坐上公交的最晚时间.cpp
 */

class Solution {
public:
    int latestTimeCatchTheBus(vector<int> &buses, vector<int> &passengers, int capacity) {
        int n = buses.size(), m = passengers.size();
        sort(buses.begin(), buses.end());
        sort(passengers.begin(), passengers.end());
        int ans = 0;
        for (int i = 0, j = 0; i < n; i++) {
            int lastBus = buses[i], cnt = 0;
            for (; j < m && cnt < capacity && passengers[j] <= lastBus; j++, cnt++)
                if (j == 0 || passengers[j - 1] != passengers[j] - 1)
                    ans = max(ans, passengers[j] - 1);
            if (cnt < capacity && (j == 0 || passengers[j - 1] != lastBus)) ans = max(ans, lastBus);
        }

        return ans;
    }
};