package Y2013C;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hyperspace
 * @date 2022/03/16
 */
public class Q1猜年龄 {
    public static void main(String[] args) {
        Set<Integer> set;
        for (int i = 11; i < 99; i++) {
            int tmp1 = (int) Math.pow(i, 3);
            int tmp2 = (int) Math.pow(i, 4);
            boolean flag = true;
            set = new HashSet<>();
            while (tmp1 > 0) {
                if (!set.add(tmp1 % 10)) {
                    flag = false;
                    break;
                }
                tmp1 /= 10;
            }
            if (flag) {
                while (tmp2 > 0) {
                    if (!set.add(tmp2 % 10)) {
                        flag = false;
                        break;
                    }
                    tmp2 /= 10;
                }
            }
            if (flag) {
                System.out.println(i);
                break;
            }
        }
    }
}
