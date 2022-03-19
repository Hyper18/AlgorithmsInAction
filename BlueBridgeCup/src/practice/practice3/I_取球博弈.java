package practice.practice3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/07
 * 递归深搜
 * 使用cache的目的：将之前遍历过的胜负结果存起来，
 * 对于cache[x1][1][0]，表示x1个球数，me为奇数，you为偶数的比赛结果
 * 如果出现相同的球数目x1时，可直接获取已缓存的比赛结果
 */
public class I_取球博弈 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private final static int MAXN = 1000 + 5;
    private final static char WIN = '+';
    private final static char FAIR = '0';
    private final static char LOSE = '-';
    private static int[] n = new int[3];
    private static int[] x = new int[5];
    static char[][][] cache = new char[MAXN][2][2];

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 3; i++) {
            n[i] = nextInt();
        }
        Arrays.sort(n);
        for (int i = 0; i < 5; i++) {
            x[i] = nextInt();
            char res = play(x[i], 0, 0);

            out.print(res + " ");
        }

        close();
    }

    /**
     * 进行一局比赛
     *
     * @param num 当前球总数目
     * @param me  当前取球对象的奇偶性
     * @param you 下一个取球对象的奇偶性
     * @return 当局比赛结果
     */
    private static char play(int num, int me, int you) {
        if (num < n[0]) {
            if (me % 2 == 1 && you % 2 == 0) {
                return WIN;
            } else if (me % 2 == 0 && you % 2 == 1) {
                return LOSE;
            } else {
                return FAIR;
            }
        }

        if (cache[num][me][you] != '\0') {
            return cache[num][me][you];
        }

        boolean flag = false;
        for (int i = 0; i < 3; i++) {
            if (num >= n[i]) {
                char res = play(num - n[i], you, (me + n[i]) % 2);
                if (LOSE == res) {
                    cache[num][me][you] = WIN;
                    return WIN;
                }
                if (FAIR == res) {
                    cache[num][me][you] = FAIR;
                    flag = true;
                }
            }
        }

        if (flag) {
            return FAIR;
        } else {
            cache[num][me][you] = LOSE;
            return LOSE;
        }
    }

    public static int nextInt() throws IOException {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }

        return Integer.parseInt(token.nextToken());
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
