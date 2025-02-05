package practice.practice1;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hyper
 * @date 2022/02/18
 */
public class K_算法训练_K好数 {
	private static int max = 101;
	private static int mod = 1000000007;

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		int k = in.nextInt();
		int l = in.nextInt();

		int[][] dp = new int[max][max];
		Arrays.fill(dp[1], 1);
		for (int i = 2; i <= l; i++) {
			for (int j = 0; j <= k - 1; j++) {
				for (int p = 0; p <= k - 1; p++) {
					if (p != j - 1 && p != j + 1) {
						dp[i][j] = (dp[i][j] + dp[i - 1][p]) % mod;
					}
				}
			}
		}

		int ans = 0;
		for (int i = 1; i <= k - 1; i++) {
			ans = (ans + dp[l][i]) % mod;
		}

		out.println(ans);

		in.close();
		out.close();
	}
}
