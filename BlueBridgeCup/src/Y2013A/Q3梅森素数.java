package Y2013A;

import java.math.BigInteger;

/**
 * @author Hyper
 * @date 2022/03/13
 * BigInteger类的使用
 */
public class Q3梅森素数 {
	public static void main(String[] args) {
		BigInteger n = new BigInteger("2").pow(11213).subtract(BigInteger.ONE);
		String s = n.toString();
		System.out.println(s.substring(s.length() - 100));
	}
}
