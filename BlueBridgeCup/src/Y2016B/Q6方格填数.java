package Y2016B;

/**
 * @author Hyper
 * @date 2022/03/28
 * 采用朴素的检查方法，直接枚举出所有可能的操作
 * 本质上还是在做全排列
 */
public class Q6方格填数 {
	private static int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	static int n = nums.length, ans;
	private static boolean[] vis = new boolean[n];
	private static int[] arr = new int[n];

	public static void main(String[] args) {
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
		for (int i = 0; i < nums.length; i++) {
			if (!vis[i]) {
				vis[i] = true;
				arr[k] = i;
				f(k + 1);
				vis[i] = false;
			}
		}
	}

	private static boolean check() {
		if (Math.abs(arr[0] - arr[1]) == 1 || Math.abs(arr[0] - arr[3]) == 1 || Math.abs(arr[0] - arr[4]) == 1
				|| Math.abs(arr[0] - arr[5]) == 1 || Math.abs(arr[1] - arr[2]) == 1 || Math.abs(arr[1] - arr[4]) == 1
				|| Math.abs(arr[1] - arr[5]) == 1 || Math.abs(arr[1] - arr[6]) == 1 || Math.abs(arr[2] - arr[6]) == 1
				|| Math.abs(arr[2] - arr[5]) == 1 || Math.abs(arr[3] - arr[4]) == 1 || Math.abs(arr[3] - arr[7]) == 1
				|| Math.abs(arr[3] - arr[8]) == 1 || Math.abs(arr[4] - arr[5]) == 1 || Math.abs(arr[4] - arr[7]) == 1
				|| Math.abs(arr[4] - arr[8]) == 1 || Math.abs(arr[4] - arr[9]) == 1 || Math.abs(arr[5] - arr[6]) == 1
				|| Math.abs(arr[5] - arr[8]) == 1 || Math.abs(arr[5] - arr[9]) == 1 || Math.abs(arr[7] - arr[8]) == 1
				|| Math.abs(arr[8] - arr[9]) == 1 || Math.abs(arr[6] - arr[9]) == 1) {
			return false;
		}
		return true;
	}
}
