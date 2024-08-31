#include <bits\stdc++.h>

using namespace std;

const int MOD = 1e9 + 7;

class Solution {
public:
    int sumSubarrayMins(vector<int> &arr) {
        int n = arr.size();
        vector<int> q, l(n, -1), r(n, n);
        for (int i = 0; i < n; i++) {
            while (!q.empty() && arr[q.back()] >= arr[i]) {
                r[q.back()] = i;
                q.pop_back();
            }
            q.push_back(i);
        }

        q.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!q.empty() && arr[q.back()] > arr[i]) {
                l[q.back()] = i;
                q.pop_back();
            }
            q.push_back(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int a = i - l[i], b = r[i] - i;
            ans += (((long) a * b) % MOD * arr[i]) % MOD;
            ans %= MOD;
        }

        return ans;
    }
};