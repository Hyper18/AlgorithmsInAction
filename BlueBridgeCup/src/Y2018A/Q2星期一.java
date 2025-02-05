package Y2018A;

import java.util.Calendar;

/**
 * @author Hyper
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
 * Calendar类的使用
 */
public class Q2星期一 {
    public static void main(String[] args) {
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        // 注意：月份从一月=0开始
        start.set(1901, 1 - 1, 1);
//        System.out.println(start.get(Calendar.DAY_OF_WEEK));
        end.set(2000, 12 - 1, 31);
        int ans = 0;
        while (start.compareTo(end) <= 0) {
            // 注意： 星期从星期天=1开始
            if (start.get(Calendar.DAY_OF_WEEK) == 1 + 1) {
                ans++;
            }
            start.add(Calendar.DATE, 1);
        }
        System.out.println(ans);
    }
}
