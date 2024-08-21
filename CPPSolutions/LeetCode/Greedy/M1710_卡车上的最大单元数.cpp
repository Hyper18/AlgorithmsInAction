#include <bits\stdc++.h>

using namespace std;

class Solution {
public:
    int maximumUnits(vector<vector<int>>& boxTypes, int truckSize) {
        sort(boxTypes.begin(), boxTypes.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[1] > b[1];
        });
        int ans = 0;
        for (auto& box : boxTypes) {
            if (truckSize - box[0] >= 0) {
                ans += box[0] * box[1];
            }
            else {
                ans += truckSize * box[1];
                break;
            }
            truckSize -= box[0];
        }

        return ans;
    }
};