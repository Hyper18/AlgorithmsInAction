package Array;

/**
 * @author Hyperspace
 * @date 2022/08/29
 */
public class M1470_重新排列数组 {
    public int[] shuffle(int[] nums, int n) {
        int len = n * 2;
        int[] res = new int[len];
        for (int i = 0; i < len; i += 2) {
            res[i] = nums[i / 2];
            res[i + 1] = nums[n + i / 2];
        }

        return res;
    }
}
