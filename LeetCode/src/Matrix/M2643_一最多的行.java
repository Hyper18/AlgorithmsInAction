package Matrix;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2025/03/22
 * @file M2643_一最多的行.java
 * <p>
 * 思路
 * 模拟
 */
public class M2643_一最多的行 {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] res = new int[2];
        for (int i = 0; i < m; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    cnt++;
                }
            }
            if (cnt > res[1]) {
                res[0] = i;
                res[1] = cnt;
            }
        }

        return res;
    }

    public int[] rowAndMaximumOnes2(int[][] mat) {
        int m = mat.length;
        int[] res = new int[2];
        for (int i = 0; i < m; i++) {
            int cnt = Arrays.stream(mat[i]).sum();
            if (cnt > res[1]) {
                res[0] = i;
                res[1] = cnt;
            }
        }

        return res;
    }
}
