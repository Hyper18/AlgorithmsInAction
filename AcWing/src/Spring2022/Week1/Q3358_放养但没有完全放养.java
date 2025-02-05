package Spring2022.Week1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/04/30
 * <p>
 * 思路：贪心 -- O(n)
 * 写完看题解才发现ac思路就是贪心法。。
 * 使用hash记录字母表的字符-idx对应键值关系
 * 遍历下一行输入的字符串，
 * 若后一位数值小于等于前一位，则说明此时已经开始了新一轮的字母歌
 * <p>
 * 笔记：贪心的逻辑方式
 * 本题core： ans >= cnt + 1，等号可以取到（第一种叙述方式）
 * 1. 贪心的 值 容易叙述
 * 最优解 大于等于 贪心解 且 等号可以取到 --> 推出：最优解等于贪心解
 * 2. 贪心的 过程 容易叙述
 * 最优解 大于等于 贪心解 且 贪心解 大于等于 最优解 --> 也能推出：最优解等于贪心解
 */
public class Q3358_放养但没有完全放养 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        String order = next();
        Map<Character, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            idxMap.put(order.charAt(i), i);
        }

        char[] input = next().toCharArray();
        int ans = 1;
        if (input.length == 1) {
            out.println(ans);
            System.exit(0);
        }
        for (int i = 1; i < input.length; i++) {
            if (idxMap.get(input[i]) - idxMap.get(input[i - 1]) <= 0) {
                ans++;
            }
        }

        out.println(ans);

        close();
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
