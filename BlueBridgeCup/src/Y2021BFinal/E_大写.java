package Y2021BFinal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E_大写 {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String input = in.readLine();
		char[] str = input.toCharArray();
		for (int i = 0; i < str.length; i++) {
			if (check(str[i])) {
				str[i] -= 32;
			}
		}
		System.out.println(str);
	}

	private static boolean check(char c) {
		return c >= 'a' && c <= 'z';
	}
}
