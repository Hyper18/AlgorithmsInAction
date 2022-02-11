/**
 * @author Vincent
 * 解题思路
 * 主要难点在于数据类型范围，考虑先处理正负，再在同个循环内部同时完成取当前位值和累加反转值操作，最后处理结果
 */
public class Q9_同文数 {
    public boolean isPalindrome(int x) {
        int temp = x;
        int sum = 0;
        while (temp > 0) {
            sum = sum * 10 + temp % 10;
            temp /= 10;
        }

        return sum == x;
    }
}
