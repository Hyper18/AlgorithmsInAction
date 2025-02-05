package Array;

/**
 * @author Hyper
 * @date 2024/05/10
 * @file M2960_统计已测试设备.java
 * <p>
 * 思路
 * 1. 模拟
 * 一开始理解错题目意思，想的是若增加已测试设备的计数后，
 * 下标在[i + 1, n - 1]的任意设备低于 0需要回滚操作，
 * 因此新开了一个数组，只有符合的时候再arraycopy回原数组
 * 2. 一次遍历，差分数组
 * ans为电池电量-1的次数，则b - ans为每个电池的实际电量
 * <p>
 * 待回看
 */
public class M2960_统计已测试设备 {
    public int countTestedDevices(int[] batteryPercentages) {
        int n = batteryPercentages.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (batteryPercentages[i] > 0) {
                ans++;
                for (int j = i + 1; j < n; j++) {
                    batteryPercentages[j] = batteryPercentages[j] - 1 < 0 ? 0 : --batteryPercentages[j];
                }
            }
        }

        return ans;
    }

    public int countTestedDevices2(int[] batteryPercentages) {
        int ans = 0;
        for (int b : batteryPercentages) {
            ans = b - ans > 0 ? ++ans : ans;
        }

        return ans;
    }
}
