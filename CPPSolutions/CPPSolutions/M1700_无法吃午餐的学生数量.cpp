#include <cstdio>
#include <vector>

using namespace std;

class Solution {
public:
    int countStudents(vector<int>& students, vector<int>& sandwiches) {
        int n = sandwiches.size();
        int cnt[2] = {0, 0};
        for (auto& stu : students)
            cnt[stu]++;
        for (int i = 0; i < n; i++)
            if (--cnt[sandwiches[i]] < 0)
                return n - i;

        return 0;
    }
};