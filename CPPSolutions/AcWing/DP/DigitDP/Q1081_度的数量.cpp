#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

const int N = 35;

int c[N][N];
int K, B;

void init() {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j <= i; j++) {
            if (!j) c[i][j] = 1;
            else c[i][j] = c[i - 1][j] + c[i - 1][j - 1];
        }
    }
}

int f(int n) {
    if (!n) return 0;

    vector<int> nums;
    while (n) {
        nums.push_back(n % B);
        n /= B;
    }

    int ans = 0, last = 0;
    for (int i = nums.size() - 1; i >= 0; i--) {
        int x = nums[i];
        if (x) {
            ans += c[i][K - last];
            if (x == 1) {
                last++;
                if (last > K) {
                    break;
                }
            } else {
                if (K - last - 1 >= 0) {
                    ans += c[i][K - last - 1];
                }
                break;
            }
        }

        if (!i && K == last) {
            ans++;
        }
    }

    return ans;
}

int main() {
    init();
    int l, r;
    scanf("%d%d%d%d", &l, &r, &K, &B);
    printf("%d\n", f(r) - f(l - 1));

    return 0;
}
