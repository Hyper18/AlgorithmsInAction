package DP;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyper
 * @date 2022/02/15，2025/01/28
 * <p>
 * 思路
 * 递推
 */
public class Q119_杨辉三角II {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(row);
        }

        return res.get(rowIndex);
    }
}
