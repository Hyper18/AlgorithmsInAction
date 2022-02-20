package Com281;

/**
 * @author Hyperspace
 * @date 2022/02/20
 */
public class Q6012_统计各位数字之和为偶数的整数个数 {
    public int countEven(int num) {
        int cnt = 0;
        int sum;
        for (int i = 2; i <= num; i++) {
            int cur = i;
            sum = 0;
            while (cur > 0) {
                sum += cur % 10;
                cur /= 10;
            }
            if (sum % 2 == 0) {
                cnt++;
            }
        }

        return cnt;
    }
}
