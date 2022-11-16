#include <bits\stdc++.h>

using namespace std;

class Solution {
private:
    string words = "aeiouAEIOU";

public:
    bool halvesAreAlike(string s) {
        int n = s.length();
        string a = s.substr(0, n / 2), b = s.substr(n / 2);
        int cnt1 = 0, cnt2 = 0;
        for (auto& c : a) if (words.find_first_of(c) != words.npos) cnt1++;
        for (auto& c : b) if (words.find_first_of(c) != words.npos) cnt2++;

        return cnt1 == cnt2;
    }
};