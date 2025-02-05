package Array;

/**
 * @author Hyper
 * @date 2023/03/14
 * @file M2383_赢得比赛需要的最少训练时长.java
 * <p>
 * 思路
 * 模拟
 */
public class M2383_赢得比赛需要的最少训练时长 {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int n = energy.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (initialEnergy <= energy[i]) {
                ans += energy[i] - initialEnergy + 1;
                initialEnergy = energy[i] + 1;
            }
            initialEnergy -= energy[i];
            if (initialExperience <= experience[i]) {
                ans += experience[i] - initialExperience + 1;
                initialExperience = experience[i] + 1;
            }
            initialExperience += experience[i];
        }

        return ans;
    }
}
