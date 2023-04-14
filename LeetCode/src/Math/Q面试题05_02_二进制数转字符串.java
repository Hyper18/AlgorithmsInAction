package Math;

/**
 * @author Hyperspace
 * @date 2023/03/02
 * @file Q面试题05_02_二进制数转字符串.java
 * <p>
 * 思路
 * 模拟，小数右侧部分的二进制表示由自身累乘2而来
 * 1)结果>1 取左侧部分，置该位1
 * 2)结果<1 取左侧部分，置该位0
 * 直至结果为1D
 * 本题中若超过浮点数的最大位数（32 bit），认为转换是不可能的
 */
public class Q面试题05_02_二进制数转字符串 {
    public String printBin(double num) {
        StringBuilder sb = new StringBuilder("0.");
        for (int i = 0; i < 32 && num != 0; i++) {
            num *= 2;
            if (num >= 1D) {
                num -= 1;
                sb.append(1);
            } else {
                sb.append(0);
            }
        }

        return num == 0 ? sb.toString() : "ERROR";
    }

    public String printBin2(double num) {
        String ans = "0.";
        for (int i = 0; i < 32 && num != 0; i++) {
            num *= 2;
            int left = (int) num;
            ans += left;
            num -= left;
        }

        return num == 0 ? ans : "ERROR";
    }
}
