package Y2015A;

/**
 * @author Hyper
 * @date 2022/03/21
 */
public class Q3九数分三组 {
    private static int[] nums;

    public static void main(String[] args) {
        nums = new int[9];
        for (int i = 0; i < 9; i++) {
            nums[i] = i + 1;
        }
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
        int a = nums[0] * 100 + nums[1] * 10 + nums[2];
        int b = nums[3] * 100 + nums[4] * 10 + nums[5];
        int c = nums[6] * 100 + nums[7] * 10 + nums[8];
        if (a * 2 == b && a * 3 == c) {
            System.out.print(a + " ");
        }
    }

    private static void swap(int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
