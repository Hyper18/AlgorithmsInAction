package Array;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2024/12/29
 * @file M1366_通过投票对团队排名.java
 * <p>
 * 思路
 * 模拟，自定义排序
 */
public class M1366_通过投票对团队排名 {
    public String rankTeams(String[] votes) {
        int m = votes[0].length();
        int[][] cnts = new int[26][m];
        Integer[] ids = new Integer[m];
        for (String vote : votes) {
            for (int i = 0; i < m; i++) {
                cnts[vote.charAt(i) - 'A'][i]++;
            }
        }
        for (int i = 0; i < m; i++) {
            ids[i] = votes[0].charAt(i) - 'A';
        }
        Arrays.sort(ids, (a, b) -> {
            for (int i = 0; i < cnts[a].length; i++) {
                if (cnts[a][i] != cnts[b][i]) {
                    return cnts[b][i] - cnts[a][i];
                }
            }
            return a - b;
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append((char) ('A' + ids[i]));
        }

        return sb.toString();
    }
}
