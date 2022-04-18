package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2022/04/18
 * dfs -- O(n), 占用O(1)的额外空间
 */
public class M386_字典序排数 {
    public List<Integer> lexicalOrder(int n) {
        int num = 1;
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            res.add(num);
            if (num * 10 <= n) {
                num *= 10;
            } else {
                while (num % 10 == 9 || num + 1 > n) {
                    num /= 10;
                }
                num++;
            }
        }

        return res;
    }
}
