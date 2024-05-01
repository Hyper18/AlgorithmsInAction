package Array;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2024/04/30
 * @file M2798_满足目标工作时长的员工数目.java
 */
public class M2798_满足目标工作时长的员工数目 {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        return (int) Arrays.stream(hours).filter(h -> h >= target).count();
    }

    public int numberOfEmployeesWhoMetTarget2(int[] hours, int target) {
        int ans = 0;
        for (int h : hours) {
            if (h >= target) {
                ans++;
            }
        }

        return ans;
    }
}
