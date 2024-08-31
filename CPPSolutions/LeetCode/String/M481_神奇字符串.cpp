#include <bits\stdc++.h>

using namespace std;

class Solution {
public:
    int magicalString(int n) {
        vector<int> s = {1, 2, 2};
        int i = 2;
        while (s.size() < n) {
            int lastNum = s[s.size() - 1];
            int cur = 3 - lastNum;
            for (int j = 0; j < s[i]; j++) s.push_back(cur);
            i++;
        }

        int ans = 0;
        for (int j = 0; j < n; j++)
            if (s[j] == 1)
                ans++;

        return ans;
    }
};