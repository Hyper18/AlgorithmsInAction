/**
 * @author Hyper
 * 解题思路
 * 主要难点在于数据类型范围，考虑先处理正负，再在同个循环内部同时完成取当前位值和累加反转值操作，最后处理结果
 */
public class Q7_整数反转 {
    public int reverse(int x) {
        boolean flag = false;
        if (x < 0) {
            flag = true;
            x = -x;
        }

        int sum = 0;
        while (x > 0) {
            if (sum > (Integer.MAX_VALUE - x % 10) / 10) {
                return 0;
            }
            sum = sum * 10 + x % 10;
            x /= 10;
        }

        return flag ? -sum : sum;
    }
}
