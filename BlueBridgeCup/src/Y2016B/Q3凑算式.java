package Y2016B;

/**
 * @author Hyper
 * @date 2022/03/26
 * 注意分式的除法
 * 直接除会产生截断
 * 应先通分
 */
public class Q3凑算式 {
    private static int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    static int n = nums.length, ans;

    public static void main(String[] args) {
        f(0);
        System.out.println(ans);
    }

    private static void f(int k) {
        if (k == n) {
            if (check()) {
                ans++;
            }
        }
        for (int i = k; i < n; i++) {
            swap(i, k);
            f(k + 1);
            swap(i, k);
        }
    }

    private static boolean check() {
        int a = nums[0];
        int b1 = nums[1];
        int b2 = nums[2];
        int c1 = nums[3] * 100 + nums[4] * 10 + nums[5];
        int c2 = nums[6] * 100 + nums[7] * 10 + nums[8];
        // key step
        if ((b1 * c2 + c1 * b2) % (b2 * c2) == 0 && (a + (b1 * c2 + c1 * b2) / (b2 * c2) == 10)) {
            return true;
        }
        return false;
    }

    private static void swap(int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
