package String;

/**
 * @author Hyper
 * @date 2023/04/17
 * @file M2409_统计共同度过的日子数.java
 * <p>
 * 思路
 * 模拟
 */
public class M2409_统计共同度过的日子数 {
    private int[] daysOfMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int n = daysOfMonth.length;
    private int[] pre = new int[n + 1];

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + daysOfMonth[i - 1];
        }
        int aa = getDayOfYear(arriveAlice), al = getDayOfYear(leaveAlice);
        int ba = getDayOfYear(arriveBob), bl = getDayOfYear(leaveBob);
        int start = Math.max(aa, ba), end = Math.min(al, bl);

        return end >= start ? end - start + 1 : 0;
    }

    private int getDayOfYear(String s) {
        int m = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
        int d = (s.charAt(3) - '0') * 10 + (s.charAt(4) - '0');

        return pre[m - 1] + d;
    }
}
