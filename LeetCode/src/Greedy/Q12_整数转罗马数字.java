package Greedy;

/**
 * @author Hyper
 * @date 2022/03/27
 * 贪心法
 * 从大到小枚举可能出现的最大数值，
 * 拼接字符串输出
 */
public class Q12_整数转罗马数字 {
    int[] nums = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    String[] strs = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 12; i >= 0; i--) {
            while (num >= nums[i]) {
                num -= nums[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }
}
