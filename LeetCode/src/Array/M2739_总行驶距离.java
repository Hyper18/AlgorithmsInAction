package Array;

/**
 * @author Hyperspace
 * @date 2024/04/25
 * @file M2739_总行驶距离.java
 * <p>
 * 思路
 * 模拟
 */
public class M2739_总行驶距离 {
    public int distanceTraveled(int mainTank, int additionalTank) {
        return (mainTank + Math.min((mainTank - 1) / 4, additionalTank)) * 10;
    }

    public int distanceTraveled2(int mainTank, int additionalTank) {
        int ans = 0;
        while (mainTank >= 5 && additionalTank > 0) {
            additionalTank--;
            mainTank -= 4;
            ans += 50;
        }

        return mainTank > 0 ? ans + mainTank * 10 : ans;
    }
}
