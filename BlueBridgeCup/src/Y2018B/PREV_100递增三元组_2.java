package Y2018B;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/04/06
 * 排序+双指针 -- O(n * nlogn)
 * 75/100。。
 */
public class PREV_100递增三元组_2 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int[] A = new int[n + 1];
        int[] B = new int[n + 1];
        int[] C = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            A[i] = nextInt();
        }
        Arrays.sort(A);
        for (int j = 1; j <= n; j++) {
            B[j] = nextInt();
        }
        Arrays.sort(B);
        for (int k = 1; k <= n; k++) {
            C[k] = nextInt();
        }
        Arrays.sort(C);

        int ans = 0;
        int pa = 1, pb = 1;
        for (int pc = 1; pc <= n; pc++) {
            pb = 1;
            while (pb <= n) {
                if (B[pb] >= C[pc]) {
                    break;
                }
                pa = 1;
                while (pa <= n && A[pa] < B[pb]) {
                    ans++;
                    pa++;
                }
                pb++;
            }
        }

        out.println(ans);

        close();
    }

    public static int nextInt() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return Integer.parseInt(tk.nextToken());
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
