package Competition.ComD72;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyper
 * @date 2022/02/19
 * <p>
 * 重点在处理最后一项
 * 如果最小偶整数也不足以拆分，加给前一项
 */
public class Q5998_拆分成最多数目的偶整数之和 {
    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 == 1) {
            return new ArrayList<>();
        }
        List<Long> res = new ArrayList<>();
        long tmp = finalSum;
        Long cur = 2L;
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
}
