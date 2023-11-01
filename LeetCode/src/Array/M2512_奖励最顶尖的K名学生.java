package Array;

import java.util.*;

/**
 * @author Hyperspace
 * @date 2023/10/11
 * @file M2512_奖励最顶尖的K名学生.java
 * <p>
 * 思路
 * 模拟，优先队列
 * 1. TLE
 * 2. 优化 hash
 */
public class M2512_奖励最顶尖的K名学生 {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        int n = report.length;
        PriorityQueue<int[]> q = new PriorityQueue<>((stu1, stu2) ->
                stu1[1] == stu2[1] ? stu1[0] - stu2[0] : stu2[1] - stu1[1]);
        int cnt;
        for (int i = 0; i < n; i++) {
            String[] words = report[i].split(" ");
            cnt = 0;
            for (String w : words) {
                for (String pos : positive_feedback) {
                    if (w.equals(pos)) {
                        cnt += 3;
                    }
                }
                for (String neg : negative_feedback) {
                    if (w.equals(neg)) {
                        cnt--;
                    }
                }
            }
            q.offer(new int[]{student_id[i], cnt});
        }
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty() && k > 0) {
            int id = q.poll()[0];
            res.add(id);
            k--;
        }

        return res;
    }

    public List<Integer> topStudents2(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        int n = report.length;
        Set<String> posSet = new HashSet<>(), negSet = new HashSet<>();
        Collections.addAll(posSet, positive_feedback);
        Collections.addAll(negSet, negative_feedback);
        PriorityQueue<int[]> q = new PriorityQueue<>((stu1, stu2) ->
                stu1[1] == stu2[1] ? stu1[0] - stu2[0] : stu2[1] - stu1[1]);
        for (int i = 0, cnt; i < n; i++) {
            String[] words = report[i].split(" ");
            cnt = 0;
            for (String w : words) {
                if (posSet.contains(w)) {
                    cnt += 3;
                }
                if (negSet.contains(w)) {
                    cnt--;
                }
            }
            q.offer(new int[]{student_id[i], cnt});
        }
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty() && k > 0) {
            int id = q.poll()[0];
            res.add(id);
            k--;
        }

        return res;
    }
}
