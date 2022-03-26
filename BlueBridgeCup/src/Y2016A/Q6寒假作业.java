package Y2016A;

/**
 * @author Hyperspace
 * @date 2022/03/25
 * 全排列
 * 但是不优化的话要跑巨久。。。
 * 见下
 * <p>
 * 另外注意这里题目已经注明了满足交换律的视为两种不同的方案
 * 因此不需要考虑全排列重复的问题
 */
public class Q6寒假作业 {
    private static int[] nums;
    private static int n, ans;

    public static void main(String[] args) {
        nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        n = nums.length;
        f(0);
        System.out.println(ans);
    }

    private static void f(int k) {
        if (k == n) {
            check();
            return;
        }
        for (int i = k; i < n; i++) {
            swap(i, k);
            // key step
            if (k == 2 && nums[0] + nums[1] != nums[2]) {
                swap(i, k);
                continue;
            }
            f(k + 1);
            swap(i, k);
        }
    }

    private static void check() {
        boolean c1 = nums[0] + nums[1] == nums[2];
        boolean c2 = nums[3] - nums[4] == nums[5];
        boolean c3 = nums[6] * nums[7] == nums[8];
        boolean c4 = nums[9] / nums[10] == nums[11] && nums[9] % nums[10] == 0;
        if (c1 && c2 && c3 && c4) {
//            System.out.printf("%d+%d=%d %d-%d=%d %d*%d=%d %d/%d=%d\n", nums[0], nums[1], nums[2], nums[3], nums[4], nums[5], nums[6], nums[7], nums[8], nums[9], nums[10], nums[11]);
            ans++;
        }
    }

    private static void swap(int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
