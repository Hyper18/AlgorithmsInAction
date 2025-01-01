package String;

/**
 * @author Hyperspace
 * @date 2025/01/01
 * @file M3280_将日期转换为二进制表示.java
 * <p>
 * 思路
 * 1. 模拟
 * 库函数：Integer.toBinaryString()
 * 2. 位运算
 */
public class M3280_将日期转换为二进制表示 {
    public String convertDateToBinary(String date) {
        String[] s = date.split("-");
        return String.join("-",
                Integer.toBinaryString(Integer.parseInt(s[0])),
                Integer.toBinaryString(Integer.parseInt(s[1])),
                Integer.toBinaryString(Integer.parseInt(s[2])));
    }

    public String convertDateToBinary2(String date) {
        return Integer.toBinaryString(Integer.parseInt(date.substring(0, 4))) + "-" + Integer.toBinaryString(Integer.parseInt(date.substring(5, 7))) + "-" + Integer.toBinaryString(Integer.parseInt(date.substring(8, 10)));
    }

    public String convertDateToBinary3(String date) {
        String[] s = date.split("-");
        return String.join("-", convert(s[0]), convert(s[1]), convert(s[2]));
    }

    private String convert(String s) {
        StringBuilder sb = new StringBuilder();
        int x = Integer.parseInt(s);
        while (x > 0) {
            sb.append(x & 1);
            x >>= 1;
        }

        return sb.reverse().toString();
    }
}
