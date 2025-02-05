package train;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Hyper
 * @date 2022/03/02
 * <p>
 * 思路
 * 有点绕的一道题，主要考虑如何搜索
 * 暴力法，每次选定一个方格，以该方格作为矩阵的左上起点
 * 从正方形长度为1开始判断，若可行则令长度递增，直至该方格能符合的最大正方形边长
 * 以此类推，得到各个方格所构成的最大正方形
 */
public class ALGO_112 {
    private static int[][] nums;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int r = in.nextInt();
        int c = in.nextInt();

        nums = new int[r][c];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                nums[i][j] = in.nextInt();
            }
        }

        int ans = 0;
        int maxLen = Math.min(r, c);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int len = ans + 1; len < maxLen; len++) {
                    if (i + len <= r && j + len <= c) {
                        if (checked(i, j, len)) {
                            ans = len;
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        out.println(ans * ans);

        in.close();
        out.close();
    }

    static boolean checked(int x, int y, int len) {
        int check = nums[x][y];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (nums[x + i][y + j] != check) {
                    return false;
                }
            }
        }

        return true;
    }
}
