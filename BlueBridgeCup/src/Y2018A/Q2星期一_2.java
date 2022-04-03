package Y2018A;

/**
 * @author Hyperspace
 * @date 2022/04/03
 * <p>
 * 标题：星期一
 * <p>
 * 整个20世纪（1901年1月1日至2000年12月31日之间），一共有多少个星期一？
 * (不要告诉我你不知道今天是星期几)
 * <p>
 * 注意：需要提交的只是一个整数，不要填写任何多余的内容或说明文字。
 * <p>
 * 思路
 * 模拟
 * 第一天周二, 最后一天周天，相减需补上第一天，而days又少了一天周一
 */
public class Q2星期一_2 {
    public static void main(String[] args) {
        int days = 0;
        for (int y = 1901; y <= 2000; y++) {
            days += isLeapYear(y) ? 366 : 365;
        }
        System.out.println((days + 1) / 7 - 1);
    }

    private static boolean isLeapYear(int y) {
        return y % 400 == 0 || (y % 4 == 0 && y % 100 != 0);
    }
}
