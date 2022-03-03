package ref;

/**
 * @author Hyperspace
 * @date 2022/03/03
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 前向星是一种特殊的边集数组,我们把边集数组中的每一条边按照起点从小到大排序,如果起点相同就按照终点从小到大排序,
 * 并记录下以某个点为起点的所有边在数组中的起始位置和存储长度,那么前向星就构造好了.
 * 用len[i]来记录所有以i为起点的边在数组中的存储长度.
 * 用head[i]记录以i为边集在数组中的第一个存储位置.
 * 原文链接：https://blog.csdn.net/acdreamers/article/details/16902023
 */
public class R10_链式向前星 {
    private static int MAXD = 1005;
    /**
     * node：边的编号
     * head：head点集，表示以i为起点的最后一条边所在结点的编号
     * edge：储存边的集合
     * <p>
     * 实际实现类似邻接表
     */
    private static int node;
    private static int[] head = new int[MAXD];
    private static Edge[] edge = new Edge[MAXD];

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(System.out)));

        int n = in.nextInt();
        int m = in.nextInt();

        init();

        while (m-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            int w = in.nextInt();

            // 有向图
//            addEdge(a, b, w);

            // 无向图的做法
            addEdge(a, b, w);
            addEdge(b, a, w);
        }

        // 保持对应
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
            for (int j = head[i]; j != -1; j = edge[j].getPre()) {
                System.out.print(" -> " + edge[j].getTo());
            }
            System.out.println();
        }

        in.close();
        out.close();
    }

    public static void init() {
        Arrays.fill(head, -1);
        node = 0;
    }

    public static void addEdge(int a, int b, int w) {
        edge[node] = new Edge();
        edge[node].setTo(b);
        edge[node].setW(w);
        edge[node].setPre(head[a]);
        head[a] = node++;
    }

    public static class Edge {
        /**
         * pre：与这条边同起点的上一条边所在结点的编号
         * to：这条边的终点
         * w：weight
         */
        private int pre;
        private int to;
        private int w;

        public Edge() {
        }

        public Edge(int pre, int to, int w) {
            this.pre = pre;
            this.to = to;
            this.w = w;
        }

        public int getPre() {
            return pre;
        }

        public void setPre(int pre) {
            this.pre = pre;
        }

        public int getTo() {
            return to;
        }

        public void setTo(int to) {
            this.to = to;
        }

        public int getW() {
            return w;
        }

        public void setW(int w) {
            this.w = w;
        }
    }
}
