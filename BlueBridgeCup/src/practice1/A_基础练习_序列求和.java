package practice1;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class A_基础练习_序列求和 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

		long n = sc.nextLong();
		long sum = n * (n + 1) / 2;
		pw.println(sum);

		sc.close();
		pw.close();
	}
}
