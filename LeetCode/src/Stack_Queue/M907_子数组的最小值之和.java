package Stack_Queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Hyper
 * @date 2022/10/28
 * <p>
 * 思路 @宫水三叶
 * 单调栈
 * Q：如何判别题目需要使用单调栈？
 * 待回看
 * <p>
 * 需要先用单调栈找出左右最远延伸的位置
 * （左边可以穿过相同值，右边止步于相同值）
 * <p>
 * l[i] = loc 含义为下标 i 左边最近一个比 arr[i] 小的位置是 loc
 * （若在 arr[i] 左侧不存在比其小的数，则 loc = -1）
 * r[i] = loc 含义为下标 i 右边最近一个比 arr[i] 大的位置是 loc
 * （若在 arr[i] 左侧不存在比其大的数，则 loc = n）
 * <p>
 * 则题目实质上转化为：
 * 子数组的个数 × 子数组最小值arr[i]，即是当前arr[i]对答案的贡献：a × b × arr[i]
 */
public class M907_子数组的最小值之和 {
    final int MOD = (int) 1e9 + 7;

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Deque<Integer> q = new ArrayDeque<>();
        int[] l = new int[n], r = new int[n];
        Arrays.fill(l, -1);
        Arrays.fill(r, n);
        for (int i = 0; i < n; i++) {
            // 向右延伸
            while (!q.isEmpty() && arr[q.peekLast()] >= arr[i]) {
                r[q.pollLast()] = i;
            }
            q.addLast(i);
        }

        q.clear();
        for (int i = n - 1; i >= 0; i--) {
            // 向左延伸
            while (!q.isEmpty() && arr[q.peekLast()] > arr[i]) {
                l[q.pollLast()] = i;
            }
            q.addLast(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 统计
            int a = i - l[i], b = r[i] - i;
            ans += (((long) a * b) % MOD * arr[i]) % MOD;
            ans %= MOD;
        }

        return ans;
    }
}
