package ref;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2022/03/03
 */
public class R9_图 {
    private static int MAXD = 1005;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(System.out)));

        /**
         * 使用二维数组存储
         *
         */
        int[][] graph = new int[MAXD][MAXD];
        int points = in.nextInt();
        int edges = in.nextInt();
        while (edges-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            int weight = in.nextInt();


            // 有向图
//            graph[a][b] = weight;

            // 无向图
            graph[a][b] = weight;
            graph[b][a] = weight;
        }

        for (int i = 1; i <= points; i++) {
            for (int j = 1; j <= points; j++) {
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }

        in.close();
        out.close();
    }
}
