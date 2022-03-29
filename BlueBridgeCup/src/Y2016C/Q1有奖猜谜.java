package Y2016C;

/**
 * @author Hyperspace
 * @date 2022/03/29
 * <p>
 * 有奖猜谜
 * <p>
 * 小明很喜欢猜谜语。
 * 最近，他被邀请参加了X星球的猜谜活动。
 * <p>
 * 每位选手开始的时候都被发给777个电子币。
 * 规则是：猜对了，手里的电子币数目翻倍，
 * 猜错了，扣除555个电子币, 扣完为止。
 * <p>
 * 小明一共猜了15条谜语。
 * 战果为：vxvxvxvxvxvxvvx
 * 其中v表示猜对了，x表示猜错了。
 * <p>
 * 请你计算一下，小明最后手里的电子币数目是多少。
 * <p>
 * 请填写表示最后电子币数目的数字。
 * 注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。
 */
public class Q1有奖猜谜 {
    public static void main(String[] args) {
        String guesses = "vxvxvxvxvxvxvvx";
        int ans = 777;
        for (char c : guesses.toCharArray()) {
            ans = c == 'v' ? ans * 2 : ans - 555;
            if (ans <= 0) {
                break;
            }
        }
        System.out.println(ans);
    }
}
