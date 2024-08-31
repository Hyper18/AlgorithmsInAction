#include <bits/stdc++.h>
#include "../../Headers/Tree/Employee.h"

using namespace std;

/**
 * @author Hyperspace
 * @date 2024/08/26
 * @file M690_员工的重要性.cpp
 */
class Solution {
private:
    unordered_map<int, Employee *> mp;

    int dfs(int id) {
        Employee *e = mp[id];
        int ans = e->importance;
        for (int i: e->subordinates) ans += dfs(i);

        return ans;
    }

public:
    int getImportance(vector<Employee *> employees, int id) {
        for (auto &e: employees) mp.emplace(e->id, e);
        return dfs(id);
    }
};