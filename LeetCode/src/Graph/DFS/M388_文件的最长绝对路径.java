package Graph.DFS;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2022/04/20
 */
public class M388_文件的最长绝对路径 {
    static final int MAX = 10000 + 10;
    static int[] dirs = new int[MAX];

    public int lengthLongestPath(String input) {
        Arrays.fill(dirs, -1);
        int n = input.length();
        int ans = 0;

        int i = 0;
        while (i < n) {
            int level = 0;
            while (i < n && input.charAt(i) == '\t') {
                level++;
                i++;
            }
            int j = i;
            boolean isDir = true;
            while (j < n && input.charAt(j) != '\n') {
                if (input.charAt(j++) == '.') {
                    isDir = false;
                }
            }
            int cur = j - i;
            int prev = level - 1 >= 0 ? dirs[level - 1] : -1;
            int path = prev + 1 + cur;
            if (isDir) {
                dirs[level] = path;
            } else if (path > ans) {
                ans = path;
            }
            i = j + 1;
        }

        return ans;
    }
}
