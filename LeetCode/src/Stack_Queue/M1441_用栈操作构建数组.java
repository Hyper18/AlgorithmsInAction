package Stack_Queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2022/10/15
 * <p>
 * 思路
 * 模拟
 */
public class M1441_用栈操作构建数组 {
    public List<String> buildArray(int[] target, int n) {
        int len = target.length;
        List<String> res = new ArrayList<>();
        int cnt = 0, num = 1;
        for (int i = 0; i < n && cnt != len; i++) {
            res.add("Push");
            if (target[cnt] == num) {
                cnt++;
            } else {
                res.add("Pop");
            }
            num++;
        }

        return res;
    }
}
