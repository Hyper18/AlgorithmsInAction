package Y2013A;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2022/03/13
 * 模拟
 */
public class Q4颠倒的价牌 {
	public static void main(String[] args) {
		Map<Integer, Integer> map1 = new HashMap<>();
		Map<Integer, Integer> map2 = new HashMap<>();
		for (int i = 1000; i < 9999; i++) {
			int price = reverse(i);
			if (price - i > -300 && price - i < -200) {
				map1.put(price - i, i);
			}
			if (price - i > 800 && price - i < 900) {
				map2.put(price - i, i);
			}
		}

		for (Map.Entry<Integer, Integer> entry2 : map2.entrySet()) {
			for (Map.Entry<Integer, Integer> entry1 : map1.entrySet()) {
				if (entry2.getKey() + entry1.getKey() == 558) {
					System.out.println(entry1.getValue());
				}
			}
		}
	}

	private static int reverse(int i) {
		char[] s = String.valueOf(i).toCharArray();

		for (int j = 0; j < s.length; j++) {
			if (s[j] == '6') {
				s[j] = '9';
			} else if (s[j] == '9') {
				s[j] = '6';
			}
		}
		StringBuilder sb = new StringBuilder();

		return Integer.parseInt(sb.append(s).reverse().toString());
	}
}
