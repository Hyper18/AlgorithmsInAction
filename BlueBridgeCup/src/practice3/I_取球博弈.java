package practice3;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2022/03/01
 * 递归深搜 25/100
 */
public class I_取球博弈 {
    private static char WIN = '+';
    private static char FAIR = '0';
    private static char LOSE = '-';
    private static int[] n;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        n = new int[3];
        for (int i = 0; i < 3; i++) {
            n[i] = in.nextInt();
        }
        Arrays.sort(n);

        for (int i = 0; i < 5; i++) {
            int x = in.nextInt();
            char res = play(x, 0, 0);

            out.print(res + " ");
        }

        in.close();
        out.close();
    }

    private static char play(int num, int my, int you) {
        boolean flag = false;
        if (num < n[0]) {
            if (my % 2 == 1 && you % 2 == 0) {
                return WIN;
            } else if (my % 2 == 0 && you % 2 == 1) {
                return LOSE;
            } else {
                return FAIR;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (num >= n[i]) {
                char res = play(num - n[i], you, my + n[i]);
                if (LOSE == res) {
                    return WIN;
                }
                if (FAIR == res) {
                    flag = true;
                }
            }
        }

        return flag ? FAIR : LOSE;
    }
}
