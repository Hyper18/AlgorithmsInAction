package Greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyper
 * @date 2022/02/20，2023/07/06
 * @file M2178_拆分成最多数目的正偶数之和.java
 * <p>
 * 思路
 * 贪心
 */
public class M2178_拆分成最多数目的正偶数之和 {
    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 == 1) {
            return new ArrayList<>();
        }
        List<Long> res = new ArrayList<>();
        long tmp = finalSum;
        long cur = 2L;
        while (tmp - cur >= 0) {
            res.add(cur);
            tmp -= cur;
            cur += 2;
        }
        if (tmp > 0) {
            int last = res.size() - 1;
            tmp = tmp + res.get(last);
            res.remove(last);
            res.add(tmp);
        }

        return res;
    }

    public List<Long> maximumEvenSplit2(long finalSum) {
        if (finalSum % 2 == 1) {
            return new ArrayList<>();
        }
        List<Long> res = new ArrayList<>();
        long base = 2;
        while (finalSum >= base) {
            res.add(base);
            finalSum -= base;
            base += 2;
        }
        if (finalSum > 0) {
            res.set(res.size() - 1, res.get(res.size() - 1) + finalSum);
        }

        return res;
    }
}
