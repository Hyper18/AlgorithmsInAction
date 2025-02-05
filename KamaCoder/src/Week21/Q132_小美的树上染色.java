package Week21;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Hyper
 * @date 2024/12/11
 * @file Q132_小美的树上染色.java
 * <p>
 * 题目描述
 * 小美拿到了一棵树，每个节点有一个权值。初始每个节点都是白色。
 * 小美有若干次操作，每次操作可以选择两个相邻的节点，如果它们都是白色且权值的乘积是完全平方数，小美就可以把这两个节点同时染红。
 * 小美想知道，自己最多可以染红多少个节点？
 * <p>
 * 输入描述
 * 第一行输入一个正整数 n（1 <= n <= 10^5），代表节点的数量。
 * 第二行输入 n 个正整数 ai（1 <= ai <= 10^9），代表每个节点的权值。
 * 接下来的 n - 1 行，每行输入两个正整数 u，v（1 <= u, v <= n），代表节点 u 和节点 v 有一条边连接。
 * <p>
 * 输出描述
 * 输出一个整数，表示最多可以染红的节点数量。
 * <p>
 * 思路@kamaCoder29697
 * 树形DP
 */
public class Q132_小美的树上染色 {
    private static final int N = (int) 1e5 + 10;
    private static Node[] nodes = new Node[N];
    private static int[][] f = new int[N][2];

    static class Node {
        long val;
        List<Integer> childs;

        public Node(long val) {
            this.val = val;
            this.childs = new ArrayList<>();
        }
    }

    private static boolean judge(int a, int b) {
        long ans = nodes[a].val * nodes[b].val, sqr = (int) Math.sqrt(ans);
        return ans == sqr * sqr;
    }

    private static void dfs(int u, int fa) {
        for (int c : nodes[u].childs) {
            if (c == fa) {
                continue;
            }
            dfs(c, u);
            f[u][0] += Math.max(f[c][0], f[c][1]);
        }
        for (int c : nodes[u].childs) {
            if (c == fa || !judge(u, c)) {
                continue;
            }
            f[u][1] = Math.max(f[u][1], f[u][0] - Math.max(f[c][0], f[c][1]) + 2 + f[c][0]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(sc.nextInt());
        }
        while (--n > 0) {
            int u = sc.nextInt(), v = sc.nextInt();
            nodes[u].childs.add(v);
            nodes[v].childs.add(u);
        }
        dfs(1, 0);
        System.out.println(Math.max(f[1][0], f[1][1]));
    }
}
