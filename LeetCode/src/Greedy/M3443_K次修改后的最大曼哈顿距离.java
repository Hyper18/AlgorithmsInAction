package Greedy;

/**
 * @author Hyperspace
 * @date 2025/06/20
 * @file M3443_K次修改后的最大曼哈顿距离.java
 * <p>
 * 思路
 * 贪心
 * 本质是在两个方向上都找到最大值，并加和
 * 遍历，求每个时刻可能的最大值
 */
public class M3443_K次修改后的最大曼哈顿距离 {
    public int maxDistance(String s, int k) {
        int[] mp = new int[4];
        int ans = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'N':
                    mp[0]++;
                    break;
                case 'S':
                    mp[1]++;
                    break;
                case 'E':
                    mp[2]++;
                    break;
                case 'W':
                    mp[3]++;
                    break;
            }
            int diff1 = Math.min(k, Math.min(mp[0], mp[1])), diff2 = Math.min(k - diff1, Math.min(mp[2], mp[3]));
            ans = Math.max(ans, Math.abs(mp[0] - mp[1]) + diff1 * 2 + Math.abs(mp[2] - mp[3]) + diff2 * 2);
        }

        return ans;
    }
}
