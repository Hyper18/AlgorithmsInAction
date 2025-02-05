package Y2018B;

/**
 * @author Hyper
 * @date 2022/04/05
 * <p>
 * 第一下想到二分，但这个思路是走不通的
 * 求的是”在最坏的运气下“，即需要从第一楼开始摔起。。。否则500碎了
 * 思路
 * dp table
 */
public class Q4测试次数 {
    private static int[][] dp = new int[3 + 1][1000 + 10];

    public static void main(String[] args) {
        throwPhones(3, 1000);
        System.out.println(dp[3][1000]);
    }

    private static void throwPhones(int phone, int floor) {
        // (第一部手机从第一层摔到最后一层，都不坏)
        for (int i = 1; i <= phone; i++) {
            for (int j = 1; j <= floor; j++) {
                dp[i][j] = j;
            }
        }

        for (int i = 2; i <= phone; i++) {
            for (int j = 1; j <= floor; j++) {
                for (int k = 1; k < j; k++) {
                    // min 表示最佳策略，max 表示最差运气
                    // 状态1：摔坏 -- 手机的数量减一，下一次要去楼下测试，最多再测试k-1次
                    // 状态2：没摔坏 -- 下一次去楼上测试，最多再测试j-k次
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][k - 1], dp[i][j - k]) + 1);
                }
            }
        }
    }
}
