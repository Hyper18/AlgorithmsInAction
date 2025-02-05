package Y2013A;

/**
 * @author Hyper
 * @date 2022/03/13
 */
public class Q6逆波兰表达式 {
	public static void main(String[] args) {
		int[] ans = evaluate("-+3*5+261");
		for (int n : ans) {
			System.out.print(n + " ");
		}
	}

	static int[] evaluate(String x) {
		if (x.length() == 0)
			return new int[]{0, 0};

		char c = x.charAt(0); // 运算符
		if (c >= '0' && c <= '9')
			return new int[]{c - '0', 1};

		int[] v1 = evaluate(x.substring(1)); // 操作数1（左侧）
		int[] v2 = evaluate(x.substring(1 + v1[1])); // 填空位置，操作数2（右侧）v[1]：处理1结果时消耗的字符数目

		int v = Integer.MAX_VALUE;
		if (c == '+')
			v = v1[0] + v2[0];
		if (c == '*')
			v = v1[0] * v2[0];
		if (c == '-')
			v = v1[0] - v2[0];

		return new int[]{v, 1 + v1[1] + v2[1]};
	}
}
