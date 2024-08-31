#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    vector<string> buildArray(vector<int> &target, int n) {
        vector<string> res;
        int len = target.size();
        int cnt = 0, num = 1;
        for (int i = 0; i < n && cnt != len; i++) {
            res.push_back("Push");
            if (target[cnt] == num) {
                cnt++;
            } else {
                res.push_back("Pop");
            }
            num++;
        }

        return res;
    }

    vector<string> buildArray2(vector<int> &target, int n) {
        vector<string> res;
        int len = target.size();
        int pre = 0;
        for (int i = 0; i < len; i++) {
            int num = target[i];
            for (int j = 0; j < num - pre - 1; j++) {
                res.push_back("Push");
                res.push_back("Pop");
            }
            res.push_back("Push");
            pre = num;
        }

        return res;
    }
};