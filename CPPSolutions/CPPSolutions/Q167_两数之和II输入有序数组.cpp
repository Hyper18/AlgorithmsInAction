#include <bits\stdc++.h>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int n = numbers.size();
        for (int i = 0; i < n; i++) {
            int low = i + 1, high = n - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int curTarget = target - numbers[i];
                if (numbers[mid] == curTarget) return { i + 1, mid + 1 };
                else if (numbers[mid] > curTarget) high = mid - 1;
                else low = mid + 1;
            }
        }

        return { -1, -1 };
    }
};