#include <bits\stdc++.h>
#include <unordered_map>

using namespace std;

class Solution {
public:
    int countMatches(vector<vector<string>>& items, string ruleKey, string ruleValue) {
        unordered_map<string, int> index = { {"type", 0}, {"color", 1}, {"name", 2} };
        int idx = index[ruleKey], ans = 0;
        for (auto&& item : items)
            if (ruleValue == item[idx])
                ans++;

        return ans;
    }
};