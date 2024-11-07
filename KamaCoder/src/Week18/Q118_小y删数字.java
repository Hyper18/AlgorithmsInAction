package Week18;

import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2024/11/07
 * @file Q118_小y删数字.java
 */
public class Q118_小y删数字 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int i = 0;
        while (i < n) {
            a[i++] = sc.nextInt();
        }
        int cnt = 0, zeros = 0;
        for (i = 0; i < n; i++) {
            while (a[i] > 0) {
                int t = a[i] % 10;
                if (t == 0) {
                    zeros++;
                }
                cnt++;
                a[i] /= 10;
            }
        }
        System.out.println(cnt - zeros);
    }
}
