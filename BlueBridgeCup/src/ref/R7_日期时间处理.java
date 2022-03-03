package ref;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Hyperspace
 * @date 2022/03/03
 */
public class R7_日期时间处理 {
    public static void main(String[] args) throws Exception {
        Date date = new Date();
        // 接收一个参数，该参数是从 1970 年 1 月 1 日起的毫秒数
        Date date2 = new Date(100000);

        String s1 = "2022-3-3";
        String s2 = "2022-4-18";
        SimpleDateFormat helper = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = helper.parse(s1);
        Date d2 = helper.parse(s2);

        if (d1.before(d2)) {
            System.out.println("d1更早");
        } else if (d1.equals(d2)) {
            System.out.println("同一天");
        } else {
            System.out.println("d1更晚");
        }

        /**
         * 注意格式化时间：
         * MM是月份 mm是分
         * HH是时 hh是12小时制时间的时
         * dd是日期 DD 一年中的日子
         * WW 一个月中的第几周 ww 一年中的第几周
         */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss");
        System.out.println(sdf.format(date));
        System.out.println(sdf2.format(date2));

        // 返回一个long型的数值，这个数值是当下时间与1970年1月1日零时的差值（ms）
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        // printf格式化日期（了解）
        // F	"年-月-日"格式
        System.out.printf("%tF%n", date);

        /**
         * Calendar类的使用
         */
        // 默认为系统当前日期
        Calendar c = Calendar.getInstance();
        // 设置：这里需要注意默认的月份是从0开始的，因此实际想要输入7月，应为6
        c.set(2022, 3 - 1, 3);
        // 注意这里星期天是周一，因此周四为5，需要减1
        System.out.println(c.get(Calendar.DAY_OF_WEEK) - 1);


        // 自带常量
        int week = Calendar.DAY_OF_WEEK;
        c.set(week, 5);

        // 加上日期
        c.add(Calendar.DATE, 10);

        // 获取操作
        c.get(Calendar.YEAR);
        // 考题：获取历史上的某一天是星期几
        System.out.println(c.get(Calendar.DAY_OF_WEEK) - 1);

        /**
         * 获取星期的公式
         * 基姆拉尔森
         * (d + 2m + 3(m + 1) / 5 + y + y / 4 - y / 100 + y / 400 + 1) % 7
         */
        int y = 2022;
        int m = 3;
        int d = 3;
        System.out.println((d + 2 * m + 3 * (m + 1) / 5 + y + y / 4 - y / 100 + y / 400 + 1) % 7);
    }
}
