package Y2017B;

/**
 * @author Hyper
 * @date 2022/04/01
 * <p>
 * 启发我们全排列去重可以从数学角度入手比较快
 * 旋转（3种）、镜像（正反）
 */
public class Q2纸牌三角形 {
    private static int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    static int ans, n = nums.length;

    public static void main(String[] args) {
        f(0);
        System.out.println(ans / 3 / 2);
    }

    private static void f(int k) {
        if (k == n) {
            if (check()) {
                ans++;
            }
            return;
        }
        for (int i = k; i < n; i++) {
            {
                int t = nums[i];
                nums[i] = nums[k];
                nums[k] = t;
            }
            f(k + 1);
            {
                int t = nums[i];
                nums[i] = nums[k];
                nums[k] = t;
            }
        }
    }

    private static boolean check() {
        int a = nums[0] + nums[1] + nums[2] + nums[3];
        int b = nums[3] + nums[4] + nums[5] + nums[6];
        int c = nums[6] + nums[7] + nums[8] + nums[0];
        return a == b && b == c;
    }
}
