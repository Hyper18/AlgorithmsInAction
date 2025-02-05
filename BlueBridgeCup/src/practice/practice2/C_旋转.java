package practice.practice2;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Hyper
 * @date 2022/02/22
 */
public class C_旋转 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int n = in.nextInt();
        int m = in.nextInt();
        int[][] img = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                img[i][j] = in.nextInt();
            }
        }

        int[][] newImg = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                newImg[i][j] = img[n - j + 1][i];
                out.print(newImg[i][j] + " ");
            }
            out.print("\n");
        }

        in.close();
        out.close();
    }
}
