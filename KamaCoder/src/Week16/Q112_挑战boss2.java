package Week16;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2024/10/16
 * @file Q112_挑战boss.java
 * <p>
 * 题目描述
 * 小欧正在一个回合制格斗游戏中挑战一个boss。已知游戏的0/3机制如下:
 * 每回合小欧先手攻击boss，然后boss攻击小欧，此时1回合结束。
 * 小欧有时可以闪避boss的攻击，当闪避成功时这回合将不受boss的伤害。 小欧攻击boss时可以攒“连击点”，她攻击造成的伤害为a+kb，其中a为基础攻击力，b为基础连击伤害，k为连击次数。小欧每次攻击后会让连击次数加1，但当小欧受到伤害后会重置连击次数为0。
 * 小欧想知道，她最终共对boss造成了多少伤害?
 * <p>
 * 输入描述
 * 第一行输入三个正整数n,a,b，代表回合的数量，小欧基础攻击力，小欧的基础连击伤害。
 * 第二行输入一个长度为n的字符串，字符串仅由o和x组成，其中o代表本回合闪避成功，x代表本回合闪避失败。
 * 1<=n,a,b<=10^5
 * <p>
 * 输出描述
 * 一个正整数，代表小欧造成的伤害总和。
 * <p>
 * 思路
 * 模拟
 */
public class Q112_挑战boss2 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        int n = nextInt(), a = nextInt(), b = nextInt();
        String s = next();
        int ans = 0, k = 0;
        for (char c : s.toCharArray()) {
            ans += a + k * b;
            k = c == 'o' ? k + 1 : 0;
        }

        System.out.println(ans);
    }

    public static int nextInt() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return Integer.parseInt(tk.nextToken());
    }

    public static String next() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return tk.nextToken();
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
