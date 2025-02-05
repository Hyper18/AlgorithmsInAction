#include <bits/stdc++.h>

using namespace std;

/**
 * @author Hyper
 * @date 2024/08/27
 * @file M3134_找出唯一性数组的中位数.cpp
 *
 * 注意这题tot算的时候1e10正好会炸，需要强转一下
 */
#define LL long long
#define N 100010
int freq[N];

class Solution {
public:
    int medianOfUniquenessArray(vector<int> &nums) {
        int n = nums.size();
        LL tot = ((LL) n * (n + 1) / 2 + 1) / 2;
        auto check = [&](int mid) -> bool {
            LL cnt = 0;
            memset(freq, 0, sizeof(freq));
            for (int l = 0, r = 0, len = 0; r < n; r++) {
                if (++freq[nums[r]] == 1) len++;
                while (len > mid)
                    if (--freq[nums[l++]] == 0)
                        len--;
                cnt += r - l + 1;
                if (cnt >= tot) return true;
            }

            return false;
        };
        int low = 0, high = n;
        while (low + 1 < high) {
            int mid = low + ((high - low) >> 1);
            (check(mid) ? high : low) = mid;
        }

        return high;
    }
};
