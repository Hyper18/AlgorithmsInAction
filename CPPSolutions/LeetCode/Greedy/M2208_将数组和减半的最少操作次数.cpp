#include <bits\stdc++.h>

using namespace std;

class Solution {
public:
    int halveArray(vector<int>& nums) {
        priority_queue<double> q(nums.begin(), nums.end());
        int ans = 0;
        double sum = accumulate(nums.begin(), nums.end(), 0.0), cur = sum;
        while (cur > sum / 2) {
            double num = q.top() / 2;
            q.pop();
            q.push(num);
            cur -= num;
            ans++;
        }

        return ans;
    }
};