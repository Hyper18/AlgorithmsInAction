package Array;

/**
 * @author Hyperspace
 * @date 2022/10/13
 * <p>
 * 思路
 * 贪心法
 * 下标和数组中的数均为[0, n)
 * 因此找每段分块的最大数，每次与右边界进行比较
 * 若相等，则说明这是一个最大分割块
 */
public class M769_最多能完成排序的块 {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int t = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            t = Math.max(t, arr[i]);
            if (t == i) {
                ans++;
            }
        }

        return ans;
    }
}
