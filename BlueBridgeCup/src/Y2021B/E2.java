package Y2021B;

public class E2 {
	private static final int N = 2021 + 10;
	private static int grid[][] = new int[N][N];
	private static final int INF = 0x3f3f3f3f;

	public static void main(String[] args) {
		init();
		for (int i = 1; i <= 2021; i++) {
			for (int j = i + 1; j <= 2021; j++) {
				if (Math.abs(i - j) > 21) {
					break;
				}
				int dis = lcm(i, j);
				grid[i][j] = dis;
				grid[j][i] = dis;
			}
		}
		floyd();

		System.out.println(grid[1][2021]);
	}

	private static void floyd() {
		for (int k = 1; k <= 2021; k++) {
			for (int i = 1; i <= 2021; i++) {
				for (int j = 1; j <= 2021; j++) {
					if (i != j && grid[i][j] > grid[i][k] + grid[k][j]) {
						grid[i][j] = grid[i][k] + grid[k][j];
					}
				}
			}
		}
	}

	private static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	private static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	private static void init() {
		for (int i = 1; i <= 2021; i++) {
			for (int j = 0; j <= 2021; j++) {
				grid[i][j] = INF;
			}
		}
	}
}
