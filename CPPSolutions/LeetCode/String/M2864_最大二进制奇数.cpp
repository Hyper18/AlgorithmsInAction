#include <bits\stdc++.h>

using namespace std;

class Solution {
public:
    string maximumOddBinaryNumber(string s) {
        int n = s.length(), cnt = count(s.begin(), s.end(), '1');
        return string(cnt - 1, '1') + string(n - cnt, '0') + '1';
    }
};