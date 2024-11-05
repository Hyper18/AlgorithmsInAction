package Array;

/**
 * @author Hyperspace
 * @date 2024/11/05
 * @file M3222_求出硬币游戏的赢家.java
 * <p>
 * 思路
 * 模拟
 * 只有一种拿法：75 + 4 * 10
 */
public class M3222_求出硬币游戏的赢家 {
    public String losingPlayer(int x, int y) {
        int cnt = 0;
        while (true) {
            x--;
            y -= 4;
            cnt++;
            if (x < 0 || y < 0) {
                return cnt % 2 == 0 ? "Alice" : "Bob";
            }
        }
    }
}
