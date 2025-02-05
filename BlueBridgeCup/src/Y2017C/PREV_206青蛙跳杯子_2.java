package Y2017C;

import java.io.*;
import java.util.*;

/**
 * @author Hyper
 * @date 2022/04/03
 * 33/100
 */
public class PREV_206青蛙跳杯子_2 {
    private static class StateAndLevel {
        char[] state;
        int level;
        // 记录空杯子的位置
        int pos;

        public StateAndLevel(char[] state, int level, int pos) {
            this.state = state;
            this.level = level;
            this.pos = pos;
        }
    }

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static Set<String> allStates = new HashSet<>();
    static String start, target;

    public static void main(String[] args) throws IOException {
        start = next();
        target = next();
        bfs();
        close();
    }

    private static void bfs() {
        // 在队列中加入初始状态
        Queue<StateAndLevel> queue = new LinkedList<>();
        queue.add(new StateAndLevel(start.toCharArray(), 0, start.indexOf('*')));
        allStates.add(start);

        while (!queue.isEmpty()) {
            StateAndLevel front = queue.poll();
            char[] state = front.state;
            int level = front.level;
            // 和目标值做比对
            if (target.equals(new String(state))) {
                out.println(level);
                break;
            }
            int pos = front.pos;
            // 演化出若干个相邻状态
            for (int i = -3; i <= 3; i++) {
                if (i == 0) {
                    continue;
                }
                if (pos + i >= 0 && pos + i < state.length) {
                    char[] newState = new String(state).toCharArray();
                    // swap以产生新状态
                    swap(newState, pos, pos + i);
                    // 判重
                    if (!allStates.contains(new String(newState))) {
                        queue.add(new StateAndLevel(newState, level + 1, pos + i));
                    }
                }
            }
        }
    }

    private static void swap(char[] state, int i, int j) {
        char t = state[i];
        state[i] = state[j];
        state[j] = t;
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
