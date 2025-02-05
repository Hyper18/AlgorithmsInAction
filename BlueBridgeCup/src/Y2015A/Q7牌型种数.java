package Y2015A;

/**
 * @author Hyper
 * @date 2022/03/22
 * 方法一：13张牌，先抓一张牌
 * 递归：规模减一，然后交给其他人。
 * 但这个解法数据规模为13的13次方
 * 方法二：把十三张牌看成13个容量。每个容量都可取0,1,2,3,4
 */
public class Q7牌型种数 {
    static int ans = 0;

    public static void main(String[] args) {
        f(0, 0);
        System.out.println(ans);
    }

    private static void f(int step, int cnt) {
        if (step > 13 || cnt > 13) {
            return;
        }
        if (step == 13 && cnt == 13) {
            ans++;
            return;
        }
        for (int i = 0; i <= 4; i++) {
            f(step + 1, cnt + i);
        }
    }
}
