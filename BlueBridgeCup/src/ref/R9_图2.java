package ref;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Hyper
 * @date 2022/03/03
 */
public class R9_图2 {
    private static int MAXD = 1005;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(System.out)));

        /**
         * 使用List存储
         *
         */
        int points = in.nextInt();
        int edges = in.nextInt();
        List[] list = new ArrayList[MAXD];
        for (int i = 0; i <= points; i++) {
            list[i] = new ArrayList<Integer>();
        }

        while (edges-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            // 无向图
            list[a].add(b);
            list[b].add(a);
        }

        // 这里注意前面输入为1，i也为1
        for (int i = 1; i <= points; i++) {
            int len = list[i].size();
            System.out.print(i + " ");
            for (int j = 0; j < len; j++) {
                System.out.print(" -> " + list[i].get(j));
            }
            System.out.println();
        }

        in.close();
        out.close();
    }
}
