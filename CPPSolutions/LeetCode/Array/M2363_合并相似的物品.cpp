#include <vector>
#include <algorithm>
#include <map>

using namespace std;

class Solution {
public:
    vector<vector<int>> mergeSimilarItems(vector<vector<int>> &items1, vector<vector<int>> &items2) {
        vector<vector<int>> res;
        int n1 = items1.size(), n2 = items2.size();
        sort(items1.begin(), items1.end());
        sort(items2.begin(), items2.end());
        int i = 0, j = 0;
        while (i < n1 || j < n2) {
            if (j == n2 || (i < n1 && items1[i][0] < items2[j][0])) {
                res.push_back({items1[i][0], items1[i][1]});
                i++;
            } else if (i == n1 || (j < n2 && items1[i][0] > items2[j][0])) {
                res.push_back({items2[j][0], items2[j][1]});
                j++;
            } else if (items1[i][0] == items2[j][0]) {
                res.push_back({items1[i][0], items1[i][1] + items2[j][1]});
                i++, j++;
            }
        }

        return res;
    }

    vector<vector<int>> mergeSimilarItems2(vector<vector<int>> &items1, vector<vector<int>> &items2) {
        vector<vector<int>> res;
        map<int, int> map;
        for (auto &item: items1) map[item[0]] += item[1];
        for (auto &item: items2) map[item[0]] += item[1];
        for (auto &e: map) res.push_back({e.first, e.second});
        // for (auto& [k, v] : map) res.push_back({ k, v }); // C++ 17

        return res;
    }
};