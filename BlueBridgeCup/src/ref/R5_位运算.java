package ref;

/**
 * @author Hyperspace
 * @date 2022/02/10
 */
public class R5_位运算 {
    public static void main(String[] args) {
        /**
         * 按位操作：取反~ 相与& 异或^ 非| 左移<< 右移>> 无符号右移>>>
         * 注：异或1的结果有两种：
         *  如果本身是奇数，那么异或1之后得到的结果必然为偶数；
         *  如果本身是偶数，那么异或1之后得到的结果必然为奇数
         */
        int odd = 123;
        int even = 24;
        if ((odd & 1) == 1) {
            System.out.println("奇数");
        }

        /**
         * 交换两数
         */
        int a = -1;
        int b = 2;
        a = a ^ b;
        System.out.println(a);

        /**
         * 判断是否异号
         * true 异号
         */
        System.out.println((a ^ b) < 0);


        int n = 12;
        n |= n >> 1;
        System.out.println(n);
        n |= n >> 2;
        System.out.println(n);


    }

    /**
     * 二进制取幂
     * https://oi-wiki.org/math/quick-pow/
     */
    long binPow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= a;
            }
            a *= a;
            b >>= 1;
        }
        return res;
    }
}
