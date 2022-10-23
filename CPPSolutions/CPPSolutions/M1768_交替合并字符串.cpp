#include <bits\stdc++.h>

using namespace std;

class Solution {
public:
    string mergeAlternately(string word1, string word2) {
        int n1 = word1.size(), n2 = word2.size();
        int i = 0;
        string res;
        while (i < n1 || i < n2) {
            if (i < n1) res.push_back(word1[i]);
            if (i < n2) res.push_back(word2[i]);
            i++;
        }

        return res;
    }
};