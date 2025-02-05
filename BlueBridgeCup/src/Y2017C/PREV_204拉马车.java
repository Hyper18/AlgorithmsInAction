package Y2017C;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/04/02
 * 模拟
 * 一遍AC了
 * <p>
 * 主要需考虑换人抽牌、抓牌过程的模拟，选取合适的数据结构
 * 这里用两个队列表示A、B的手牌（FIFO）
 * 用栈表示桌面上的牌（FILO）
 * 当任意一方没有手牌且无法赢牌后，跳出
 * 并输出当前另一方的手牌
 */
public class PREV_204拉马车 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static Queue<Character> A = new ArrayDeque<>(), B = new ArrayDeque<>();
    private static Stack<Character> tb = new Stack<>();
    private static int lastIdx = -1;

    public static void main(String[] args) throws IOException {
        String a = nextString();
        for (char c : a.toCharArray()) {
            A.offer(c);
        }
        String b = nextString();
        for (char c : b.toCharArray()) {
            B.offer(c);
        }

        aPlay();

        for (char c : A.isEmpty() ? B : A) {
            out.print(c);
        }
        out.println();

        close();
    }

    private static void aPlay() {
        if (A.isEmpty() || B.isEmpty()) {
            return;
        }
        char card = A.poll();
        tb.push(card);
        if (findCard(card)) {
            collect(A, tb.size() - lastIdx);
            lastIdx = -1;
            aPlay();
        } else {
            bPlay();
        }
    }

    private static void bPlay() {
        if (A.isEmpty() || B.isEmpty()) {
            return;
        }
        char card = B.poll();
        tb.push(card);
        if (findCard(card)) {
            collect(B, tb.size() - lastIdx);
            lastIdx = -1;
            bPlay();
        } else {
            aPlay();
        }
    }

    private static boolean findCard(char card) {
        for (int i = 0; i < tb.size() - 1; i++) {
            if (tb.get(i) == card) {
                lastIdx = i;
            }
        }
        return lastIdx != -1;
    }

    private static void collect(Queue<Character> queue, int size) {
        for (int i = 0; i < size; i++) {
            queue.offer(tb.pop());
        }
    }

    public static String nextString() throws IOException {
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