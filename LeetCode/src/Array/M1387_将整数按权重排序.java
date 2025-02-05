package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyper
 * @date 2024/12/22
 * @file M1387_将整数按权重排序.java
 */
public class M1387_将整数按权重排序 {
    public int getKth(int lo, int hi, int k) {
        List<int[]> li = new ArrayList<>();
        for (int i = lo; i <= hi; i++) {
            li.add(new int[]{i, getWeight(i)});
        }
        li.sort((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        return li.get(k - 1)[0];
    }

    private int getWeight(int i) {
        int ans = 0;
        while (i != 1) {
            i = (i & 1) == 0 ? i / 2 : i * 3 + 1;
            ans++;
        }

        return ans;
    }
}
