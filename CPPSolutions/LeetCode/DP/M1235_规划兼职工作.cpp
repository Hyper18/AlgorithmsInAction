#include <bits\stdc++.h>

using namespace std;

const int N = 50010;

vector<int> f(N);

class Solution {
public:
    int jobScheduling(vector<int> &startTime, vector<int> &endTime, vector<int> &profit) {
        int n = startTime.size();
        vector<vector<int>> jobs(n);
        for (int i = 0; i < n; i++)
            jobs[i] = {startTime[i], endTime[i], profit[i]};
        sort(jobs.begin(), jobs.end(), [](const vector<int> &job1, const vector<int> &job2) -> bool {
            return job1[1] < job2[1];
        });

        for (int i = 1; i <= n; i++) {
            int last = upper_bound(jobs.begin(), jobs.begin() + i - 1, jobs[i - 1][0],
                                   [&](int st, const vector<int> &job) -> bool {
                                       return st < job[1];
                                   }) - jobs.begin();
            f[i] = max(f[i - 1], f[last] + jobs[i - 1][2]);
        }

        return f[n];
    }
};