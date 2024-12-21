package Matrix;

import java.util.*;

/**
 * @author Hyperspace
 * @date 2024/12/21
 * @file M2545_根据第K场考试的分数排序.java
 */
public class M2545_根据第K场考试的分数排序 {
    public int[][] sortTheStudents(int[][] score, int k) {
        int m = score.length, n = score[0].length;
        List<int[]> li = new ArrayList<>(Arrays.asList(score));
        li.sort(Comparator.comparingInt(o -> o[k]));
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            res[i] = li.get(m - 1 - i);
        }

        return res;
    }

    public int[][] sortTheStudents2(int[][] score, int k) {
        Arrays.sort(score, (a, b) -> b[k] - a[k]);
        return score;
    }
}
