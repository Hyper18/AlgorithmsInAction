package Y2020B1;

import java.math.BigInteger;

/**
 * @author Hyper
 * @date 2022/04/07
 */
public class E斐波那契数列最大公约数 {
	public static void main(String[] args) {
		BigInteger a = getF(520);
		BigInteger b = getF(2020);
		System.out.println(gcd(a, b));
	}

	private static BigInteger getF(int n) {
		BigInteger pre = BigInteger.valueOf(1);
		BigInteger cur = BigInteger.valueOf(1);
		for (int i = 3; i <= n; i++) {
			BigInteger tmp = pre.add(cur);
			pre = cur;
			cur = tmp;
		}
		return cur;
	}

	private static BigInteger gcd(BigInteger a, BigInteger b) {
		return b.compareTo(BigInteger.valueOf(0)) == 0 ? a : gcd(b, a.mod(b));
	}
}
