#include <bits/stdc++.h>

using namespace std;

/**
 * @author Hyperspace
 * @date 2024/08/28
 * @file M3144_分割字符频率相等的最少子字符串.cpp
 */
class Solution {
public:
    int minimumSubstringsInPartition(string s) {
        int n = s.length();
        int f[n], freq[26];
        for (int i = 0; i < n; i++) f[i] = i + 1;
        auto check = [&](int len, int size) -> bool {
            if (len % size) return false;
            int cnt = len / size;
            for (int v: freq)
                if (v > 0 && v != cnt)
                    return false;

            return true;
        };
        for (int i = 0; i < n; i++) {
            memset(freq, 0, sizeof(freq));
            int size = 0;
            for (int j = i; j >= 0; j--) {
                if (!freq[s[j] - 'a']++) size++;
                if (check(i - j + 1, size)) f[i] = !j ? 1 : min(f[i], f[j - 1] + 1);
            }
        }

        return f[n - 1];
    }
};