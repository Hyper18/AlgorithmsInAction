package Y2022B;

import java.math.BigInteger;

public class A {
	public static void main(String[] args) {
		BigInteger n = BigInteger.valueOf(20);
		for (int i = 0; i < 22; i++) {
			n = n.multiply(n);
		}
		System.out.println(n.mod(BigInteger.valueOf(7)));
	}
}
