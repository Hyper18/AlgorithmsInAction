#include <bits/stdc++.h>

using namespace std;

/**
 * @author Hyper
 * @date 2024/10/08
 * @file M1436_旅行终点站.cpp
 */
class Solution {
public:
    string destCity(vector<vector<string>>& paths) {
        set<string> st1, st2;
        for (auto& p : paths) {
            st2.erase(p[0]);
            if (st1.find(p[1]) == st1.end()) st2.insert(p[1]);
            st1.insert(p[0]);
        }

        return *st2.begin();
    }
};