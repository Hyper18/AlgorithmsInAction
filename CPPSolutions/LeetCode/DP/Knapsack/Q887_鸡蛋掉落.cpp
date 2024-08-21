#include <bits\stdc++.h>

using namespace std;

const int K = 110;

class Solution {
private:
    int f[K];

public:
    int superEggDrop(int k, int n) {
        if (n == 1) return 1;
        int cnt = 0;
        while (f[k] < n) {
            cnt++;
            for (int i = k; i >= 1; i--) 
                f[i] = f[i] + f[i - 1] + 1;
        }

        return cnt;
    }
};