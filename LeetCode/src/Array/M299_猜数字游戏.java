package Array;

/**
 * @author Hyperspace
 * @date 2024/03/10
 * @file M299_猜数字游戏.java
 * <p>
 * 思路
 * 模拟
 * <p>
 * 注：题干费解
 */
public class M299_猜数字游戏 {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        int bulls = 0, cows = 0;
        int[] cnt1 = new int[10], cnt2 = new int[10];
        for (int i = 0; i < n; i++) {
            int a = secret.charAt(i), b = guess.charAt(i);
            if (a == b) {
                bulls++;
            } else {
                cnt1[a - '0']++;
                cnt2[b - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            cows += cnt1[i] <= cnt2[i] ? cnt1[i] : cnt2[i];
        }

        return bulls + "A" + cows + "B";
    }
}
