#include <bits\stdc++.h>

using namespace std;

class Solution {
public:
    string interpret(string cmd) {
        string res;
        for (int i = 0; i < cmd.size(); i++) {
            if (cmd[i] == 'G') {
                res += "G";
            } else if (cmd[i] == '(') {
                if (cmd[i + 1] == 'a') {
                    res += "al";
                } else {
                    res += "o";
                }
            }
        }

        return res;
    }
};