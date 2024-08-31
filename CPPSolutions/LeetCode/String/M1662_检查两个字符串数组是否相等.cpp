#include <bits\stdc++.h>

using namespace std;

class Solution {
public:
    bool arrayStringsAreEqual(vector<string> &word1, vector<string> &word2) {
        return join(word1) == join(word2);
    }

    string join(vector<string> &words) {
        string s;
        for (auto &word: words) {
            s += word;
        }
        return s;
    }

    bool arrayStringsAreEqual2(vector<string> &word1, vector<string> &word2) {
        int n1 = word1.size(), n2 = word2.size();
        int p1 = 0, p2 = 0, i = 0, j = 0;
        while (p1 < n1 && p2 < n2) {
            if (word1[p1][i] != word2[p2][j]) {
                return false;
            }
            i++;
            j++;
            if (i == word1[p1].length()) {
                p1++;
                i = 0;
            }
            if (j == word2[p2].length()) {
                p2++;
                j = 0;
            }
        }

        return p1 == n1 && p2 == n2;
    }
};