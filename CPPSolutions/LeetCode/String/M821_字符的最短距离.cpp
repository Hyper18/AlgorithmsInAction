using namespace std;

#include <vector>
#include <string>
#include <list>

class Solution {
public:
    vector<int> shortestToChar(string s, char c) {
        int len = s.length();
        vector<int> ans(len);
        list<int> pos;
        for (int i = 0; i < len; i++) {
            if (s[i] == c) {
                ans[i] = 0;
                pos.push_back(i);
            }
        }

        for (int i = 0; i < len; i++) {
            if (s[i] == c) {
                continue;
            }
            int min = len;
            for (auto &idx: pos) {
                int cur = abs(idx - i);
                if (cur < min) {
                    min = cur;
                }
            }
            ans[i] = min;
        }

        return ans;
    }

    vector<int> shortestToChar2(string s, char c) {
        int len = s.length();
        vector<int> ans(len, len);
        int last = -len;
        for (int i = 0; i < len; i++) {
            if (s[i] == c) {
                for (int j = i; j >= max(0, (i + last - 1) / 2); j--) {
                    ans[j] = min(ans[j], i - j);
                }
                last = i;
            } else {
                ans[i] = min(ans[i], i - last);
            }
        }

        return ans;
    }
};