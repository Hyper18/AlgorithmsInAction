package Array;

/**
 * @author Hyper
 * @date 2024/09/01
 * @file M1450_在既定时间做作业的学生人数.java
 */
public class M1450_在既定时间做作业的学生人数 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int n = startTime.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                ans++;
            }
        }

        return ans;
    }
}
