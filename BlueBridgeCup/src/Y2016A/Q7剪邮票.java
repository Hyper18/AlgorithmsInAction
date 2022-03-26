package Y2016A;

import java.io.IOException;

/**
 * @author Hyperspace
 * @date 2022/03/25
 */
public class Q7剪邮票 {
	private static int[] nums = new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
	private static final int r = 3, c = 4;
	private static final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static boolean[] vis = new boolean[r * c];
	private static int[] path = new int[r * c];
	static int n = nums.length, ans;

	public static void main(String[] args) throws IOException {
		f(0);
		System.out.println(ans);
	}

	private static void f(int k) {
		if (k == n) {
			if (check()) {
				ans++;
			}
			return;
		}
		for (int i = 0; i < n; i++) {
			if (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]) {
				continue;
			}
			if (!vis[i]) {
				vis[i] = true;
				path[k] = nums[i];
				f(k + 1);
				vis[i] = false;
			}
		}
	}

	private static boolean check() {
		int[][] grid = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (path[i * 4 + j] == 1) {
					grid[i][j] = 1;
				} else {
					grid[i][j] = 0;
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == 1) {
					dfs(grid, i, j);
					cnt++;
				}
			}
		}
		return cnt == 1;
	}

	private static void dfs(int[][] grid, int x, int y) {
		if (x < 0 || x >= r || y < 0 || y >= c || grid[x][y] != 1) {
			return;
		}
		grid[x][y] = 0;
		for (int[] dir : dirs) {
			dfs(grid, x + dir[0], y + dir[1]);
		}
	}
}
