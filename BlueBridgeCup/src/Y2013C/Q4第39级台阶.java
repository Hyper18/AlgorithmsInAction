package Y2013C;

/**
 * @author Hyper
 * @date 2022/03/16
 * dp[i][j]在第i步采用j步（0：偶数步， 1奇数步）走楼梯
 * 注意最开始和结束均使用偶数步
 */
public class Q4第39级台阶 {
    public static void main(String[] args) {
        int[][] dp = new int[40][2];
        dp[1][0] = 0;
        dp[1][1] = 1;
        dp[2][0] = 1;
        dp[2][1] = 1;
        for (int i = 3; i <= 39; i++) {
            dp[i][1] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][0] = dp[i - 1][1] + dp[i - 2][1];
        }

        System.out.println(dp[39][0]);
    }
}
