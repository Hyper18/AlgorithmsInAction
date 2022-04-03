package Y2017C;

import java.io.*;
import java.util.*;

/**
 * @author Hyperspace
 * @date 2022/04/03
 * @time 234ms
 */
public class PREV_206青蛙跳杯子_3 {
    private static class StateAndLevel {
        StringBuilder state;
        int level;
        // 记录空杯子的位置
        int pos;

        public StateAndLevel(StringBuilder state, int level, int pos) {
            this.state = state;
            this.level = level;
            this.pos = pos;
        }
    }

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static Set<String> allStates = new HashSet<>();
    private static StringBuilder start, target;

    public static void main(String[] args) throws IOException {
        start = new StringBuilder(next());
        target = new StringBuilder(next());
        bfs();
        close();
    }

    private static void bfs() {
        // 在队列中加入初始状态
        Queue<StateAndLevel> q = new LinkedList<>();
        q.add(new StateAndLevel(start, 0, start.indexOf("*")));
        allStates.add(start.toString());

        while (!q.isEmpty()) {
            StateAndLevel front = q.poll();
            StringBuilder state = front.state;
            int level = front.level;
            // 和目标值做比对：若不加toString，则默认比较的是地址而非内容
            if (target.toString().equals(state.toString())) {
                out.println(level);
                break;
            }
            int pos = front.pos;
            // 演化出若干个相邻状态
            for (int i = -3; i <= 3; i++) {
                if (i == 0) {
                    continue;
                }
                if (pos + i >= 0 && pos + i < state.length()) {
                    StringBuilder newState = new StringBuilder(state);
                    // swap以产生新状态
                    swap(newState, pos, pos + i);
                    // 判重
                    if (!allStates.contains(newState.toString())) {
                        q.add(new StateAndLevel(newState, level + 1, pos + i));
                        // 放入set中
                        allStates.add(newState.toString());
                    }
                }
            }
        }
    }

    private static void swap(StringBuilder s, int i, int j) {
        char t = s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, t);
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
