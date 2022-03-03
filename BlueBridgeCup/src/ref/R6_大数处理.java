package ref;

import java.io.BufferedInputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2022/03/03
 */
public class R6_大数处理 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));

        /**
         * BigInteger的使用
         */
        String s = in.next();
        BigInteger num = new BigInteger(s);
        BigInteger num2 = new BigInteger(s);
        BigInteger numBinary = new BigInteger(s, 2);

        num.abs();
        num = num.add(num2);
        num = num.subtract(num2);
        num = num.multiply(num2);
        num = num.subtract(num2);
        // 求相反数
        num.negate();
        // 求余数：仅前者可以用于小数
        num.remainder(num2);
        num.mod(num2);
        // 求幂
        num.pow(2);

        num.doubleValue();
        num.floatValue();
        num.intValue();

        num.max(num2);
        num.min(num2);

        // 求两数的最小公约数
        num.gcd(num2);

        // 按位操作:
        num.and(num2);
        num.or(num2);
        num.not();
        num.andNot(num2);
        num.xor(num2);

        // 移位操作
        num.shiftLeft(2);
        num.shiftRight(3);

        // 进制转换
        String str1 = num.toString(2);
        String str2 = numBinary.toString(10);

        /**
         * BigDecimal的使用
         */
        BigDecimal d1 = in.nextBigDecimal();
        BigDecimal d2 = in.nextBigDecimal();

        // 四则操作同上
        d1.multiply(d2);

        // 小数位数
        //scale() 获取小数位数；若是整数则为负数，表示的末尾的0个数
        d1.scale();
        d2.stripTrailingZeros();
        d2.scale();

        // 四舍五入
        d1.setScale(4, RoundingMode.HALF_UP);

        // 直接截断
        d2.setScale(4, RoundingMode.DOWN);

        // sp. 用于小数除法的位数处理
        //保留10位小数并四舍五入
        BigDecimal d3 = d1.divide(d2, 10, RoundingMode.HALF_UP);
        // 报错：ArithmeticException，因为除不尽
        d1.divide(d2);

        // 做除法并保留余数
        BigDecimal[] dr = d1.divideAndRemainder(d2);
        // 第一个结果为商
        System.out.println(dr[0]);
        // 第二个是余数
        System.out.println(dr[1]);

        // 比较两个BigDecimal：使用compareTo
        d1.compareTo(d2);
        // 使用equals需保证位数相同
        d1.equals(d2);
        d1.stripTrailingZeros().equals(d2.stripTrailingZeros());


    }
}
