package Array;

/**
 * @author Hyper
 * @date 2024/11/30
 * @file M3232_判断是否可以赢得数字游戏.java
 * <p>
 * 思路
 * 模拟
 */
public class M3232_判断是否可以赢得数字游戏 {
    public boolean canAliceWin(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num < 10 ? num : -num;
        }

        return sum != 0;
    }
}
