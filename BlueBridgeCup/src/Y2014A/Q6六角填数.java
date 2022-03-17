package Y2014A;

/**
 * @author Hyperspace
 * @date 2022/03/16
 */
public class Q6六角填数 {
    private static int[] nums;

    public static void main(String[] args) {
        nums = new int[]{2, 4, 5, 6, 7, 9, 10, 11, 12};
        backtrack(0);

    }

    private static void backtrack(int k) {
        if (k == nums.length) {
            check();
            return;
        }

        for (int i = k; i < nums.length; i++) {
            swap(i, k);
            backtrack(k + 1);
            swap(i, k);
        }
    }

    private static void check() {
        int r1 = 1 + nums[0] + nums[3] + nums[5];
        int r2 = 1 + nums[1] + nums[4] + nums[8];
        int r3 = 8 + nums[0] + nums[1] + nums[2];
        int r4 = 8 + nums[3] + nums[6] + 3;
        int r5 = nums[2] + nums[4] + nums[7] + 3;
        int r6 = nums[5] + nums[6] + nums[7] + nums[8];

        if (r1 == r2 && r2 == r3 && r3 == r4 && r4 == r5 && r5 == r6) {
            for (int n : nums) {
                System.out.printf(n + " ");
            }
        }
    }

    private static void swap(int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
