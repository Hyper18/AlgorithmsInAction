package Week17;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2024/11/06
 * @file Q115_组装手机2.java
 */
public class Q115_组装手机2 {
    private static final int N = 1010;
    private static int[] a = new int[N], b = new int[N], res = new int[N << 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mx = 0;
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            a[t]++;
            mx = Math.max(mx, t);
        }
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            b[t]++;
            mx = Math.max(mx, t);
        }
        for (int i = 1; i <= mx; i++) {
            if (a[i] == 0) {
                continue;
            }
            for (int j = 1; j <= mx; j++) {
                if (b[j] == 0) {
                    continue;
                }
                res[i + j] += Math.min(a[i], b[j]);
            }
        }
        System.out.println(Arrays.stream(res).max().getAsInt());
    }
}
