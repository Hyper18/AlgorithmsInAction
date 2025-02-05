package Y2016A;

/**
 * @author Hyper
 * @date 2022/03/25
 * 枚举
 * 得到此人从26开始过生日，到他年满33周岁为止正好是今年
 * 符合条件
 */
public class Q2生日蜡烛 {
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            int tmp = 0;
            for (int j = i; j < 100; j++) {
                tmp += j;
                if (tmp == 236) {
                    System.out.println(i);
                    System.exit(0);
                }
            }
        }
    }
}
