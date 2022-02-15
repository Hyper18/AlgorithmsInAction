package DP;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2022/02/15
 * <p>
 * 思路
 * 1. 数学递推
 * 2. DP
 */
public class Q118_杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> currRow = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    currRow.add(1);
                } else {
                    currRow.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(currRow);
        }

        return res;
    }

    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> dp = new ArrayList<>();
        dp.add(new ArrayList<Integer>() {{
            add(1);
        }});
        for (int i = 1; i < numRows; i++) {
            List<Integer> currRow = new ArrayList<>();
            List<Integer> preRow = dp.get(i - 1);

            currRow.add(1);
            for (int j = 1; j < i; j++) {
                currRow.add(preRow.get(j) + preRow.get(j - 1));
            }
            currRow.add(1);

            dp.add(currRow);
        }

        return dp;
    }
}