using namespace std;
#include <cstdio>
#include <string>
#define MAX 10010

class Solution {
public:
    int dirs[MAX];
    int lengthLongestPath(string input) {
        memset(dirs, -1, sizeof(dirs));
        int n = input.length();
        int ans = 0;

        int i = 0;
        while (i < n) {
            int level = 0;
            while (i < n && input[i] == '\t') {
                level++;
                i++;
            }
            int j = i;
            bool isDir = 1;
            while (j < n && input[j] != '\n') {
                if (input[j++] == '.') {
                    isDir = 0;
                }
            }
            int cur = j - i;
            int prev = level - 1 >= 0 ? dirs[level-1] : -1;
            int path = prev + 1 + cur;
            if (isDir) {
                dirs[level] = path;
            }
            else if (path > ans) {
                ans = path;
            }
            i = j + 1;
        }
        return ans;
    }
};