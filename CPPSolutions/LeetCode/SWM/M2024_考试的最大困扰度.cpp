#include <bits/stdc++.h>

using namespace std;

/**
 * @author Hyper
 * @date 2024/09/02
 * @file M2024_考试的最大困扰度.cpp
 */
class Solution {
public:
    int maxConsecutiveAnswers(string answerKey, int k) {
        function<int(string &, int, char)> count = [&](string &s, int k, char target) -> int {
            int ans = 0, cnt = 0;
            for (int l = 0, r = 0; r < s.size(); r++) {
                cnt += s[r] != target;
                while (cnt > k) cnt -= s[l++] != target;
                ans = max(ans, r - l + 1);
            }

            return ans;
        };

        return max(count(answerKey, k, 'T'), count(answerKey, k, 'F'));
    }
};