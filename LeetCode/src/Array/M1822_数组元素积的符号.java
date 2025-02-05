package Array;

/**
 * @author Hyper
 * @date 2022/10/27
 */
public class M1822_数组元素积的符号 {
    public int arraySign(int[] nums) {
        int ans = 1;
        for (int n : nums) {
            if (n == 0) {
                return 0;
            } else if (n < 0) {
                ans = -ans;
            }
        }

        return ans;
    }
}
