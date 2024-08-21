#include <cstdio>
#include <string>

using namespace std;

class Solution {
public:
    bool areAlmostEqual(string s1, string s2) {
        if (s1 == s2) return true;
        int n = s1.size();
        char t1 = ' ', t2 = ' ';
        bool flag = false;
        for (int i = 0; i < n; i++) {
            if (s1[i] != s2[i])
                if (t1 == ' ')
                    t1 = s1[i], t2 = s2[i];
            else if (!flag && t1 == s2[i] && t2 == s1[i])
                flag = true;
            else 
                return false;
        }

        return flag;
    }

    bool areAlmostEqual2(string s1, string s2) {
        int n = s1.size();
        int i = -1, j = -1;
        for (int idx = 0; idx < n; idx++) {
            if (s1[idx] != s2[idx]) {
                if (i < 0)
                    i = idx;
                else if (j < 0)
                    j = idx;
                else 
                    return false;
            }
        }

        return i < 0 || j >= 0 && s1[i] == s2[j] && s1[j] == s2[i];
    }
};