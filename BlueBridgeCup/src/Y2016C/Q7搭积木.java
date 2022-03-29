package Y2016C;

/**
 * @author Hyperspace
 * @date 2022/03/25
 * 全排列 + 剪枝
 */
public class Q7搭积木 {
	private static int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	static int n = nums.length, ans;

	public static void main(String[] args) {
		f(0);
		System.out.println(ans);
	}

	private static void f(int k) {
		if (k == n) {
			ans++;
			return;
		}
		for (int i = k; i < n; i++) {
			swap(i, k);
			if (trim(k)) {
				swap(i, k);
				continue;
			}
			f(k + 1);
			swap(i, k);
		}
	}

	private static boolean trim(int k) {
		if ((k == 1 && nums[1] < nums[0]) || (k == 2 && nums[2] < nums[0]) || (k == 3 && nums[3] < nums[1])
				|| (k == 4 && (nums[4] < nums[1] || nums[4] < nums[2])) || (k == 5 && nums[5] < nums[2])
				|| (k == 6 && nums[6] < nums[3]) || (k == 7 && (nums[7] < nums[3] || nums[7] < nums[4]))
				|| (k == 8 && (nums[8] < nums[4] || nums[8] < nums[5])) || (k == 9 && nums[9] < nums[5])) {
			return true;
		}
		return false;
	}

	private static void swap(int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
}
