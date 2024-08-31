#include <bits\stdc++.h>

using namespace std;

class Solution {
public:
    vector<int> filterRestaurants(vector<vector<int>> &restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        sort(restaurants.begin(), restaurants.end(), [](const vector<int> &a, const vector<int> &b) {
            return a[1] == b[1] ? a[0] > b[0] : a[1] > b[1];
        });
        vector<int> res;
        for (auto &r: restaurants)
            if (r[2] >= veganFriendly && r[3] <= maxPrice && r[4] <= maxDistance)
                res.push_back(r[0]);

        return res;
    }
};