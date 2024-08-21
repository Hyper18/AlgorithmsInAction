#include <cstdio>
#include <vector>

using namespace std;

class Solution {
public:
    int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int e = 1 << (n - 2);
        if (k - 1 < e) {
            return kthGrammar(n - 1, k);
        }

        return 1 ^ kthGrammar(n - 1, k - e);
    }

    int kthGrammar2(int n, int k) {
        return __builtin_popcount(k - 1) & 1;
    }
};