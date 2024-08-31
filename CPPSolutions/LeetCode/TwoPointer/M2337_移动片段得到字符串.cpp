#include <bits\stdc++.h>

using namespace std;

class Solution {
public:
    bool canChange(string start, string target) {
        int n = start.length();
        int i = 0, j = 0;
        while (i < n || j < n) {
            while (i < n && start[i] == '_') i++;
            while (j < n && target[j] == '_') j++;
            if (i < n && j < n) {
                if (start[i] != target[j] || (i < j && start[i] == 'L') || (i > j && target[j] == 'R')) return false;
                i++, j++;
            } else if (i < n) {
                while (i < n) {
                    if (start[i] != '_')
                        return false;
                    i++;
                }
            } else {
                while (j < n) {
                    if (target[j] != '_')
                        return false;
                    j++;
                }
            }
        }

        return true;
    }
};