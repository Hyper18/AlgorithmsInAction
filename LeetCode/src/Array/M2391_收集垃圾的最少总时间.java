package Array;

/**
 * @author Hyperspace
 * @date 2024/05/11
 * @file M2391_收集垃圾的最少总时间.java
 * <p>
 * 思路
 * 模拟
 * but这题直接模拟比较麻烦，转化一下思路
 * 核心在于：
 * 1）车的使用是唯一的
 * 2）从左到右依次匀速遍历
 * 3）所有垃圾均需要收集
 * 可知ans包含两部分：
 * 1）车行驶的总距离
 * 2）垃圾的总数目
 */
public class M2391_收集垃圾的最少总时间 {
    final String[] s = new String[]{"M", "P", "G"};

    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length, tLen = travel.length, sLen = s.length;
        int[] last = new int[3];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += garbage[i].length();
            for (int j = 0; j < sLen; j++) {
                if (garbage[i].contains(s[j])) {
                    last[j] = i;
                }
            }
        }

        int[] pre = new int[tLen + 1];
        for (int i = 1; i <= tLen; i++) {
            pre[i] = pre[i - 1] + travel[i - 1];
        }
        for (int i = 0; i < sLen; i++) {
            ans += pre[last[i]];
        }

        return ans;
    }
}
