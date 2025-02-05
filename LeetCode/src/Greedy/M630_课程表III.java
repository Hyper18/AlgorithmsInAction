package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Hyper
 * @date 2023/09/11
 * @file M630_课程表III.java
 * <p>
 * 思路
 * 1) 01背包压着时间过，1天1门
 * 2) 贪心反悔，参官解
 * 维护一个大根堆，优先弹出课时最长的课程
 * 先贪心更早结束的课程，再贪心课时短的课程
 */
public class M630_课程表III {
    final int N = (int) 1e4 + 10;
    int[] f = new int[N];

    public int scheduleCourse(int[][] courses) {
        int n = courses.length;
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        for (int i = 0; i < n; i++) {
            int v = courses[i][0], m = courses[i][1];
            for (int j = m; j >= v; j--) {
                f[j] = Math.max(f[j], f[j - v] + 1);
            }
        }

        return Arrays.stream(f).max().getAsInt();
    }

    public int scheduleCourse2(int[][] courses) {
        int n = courses.length;
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        int curTime = 0;
        for (int i = 0; i < n; i++) {
            int d = courses[i][0], l = courses[i][1];
            if (curTime + d <= l) {
                curTime += d;
                q.offer(d);
            } else if (!q.isEmpty() && q.peek() > d) {
                curTime -= q.poll();
                q.offer(d);
                curTime += d;
            }
        }

        return q.size();
    }
}
