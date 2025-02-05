package String;

/**
 * @author Hyper
 * @date 2025/01/08
 * @file M2264_字符串中最大的3位相同数字.java
 */
public class M2264_字符串中最大的3位相同数字 {
    private final String[] nums = new String[]{"999", "888", "777", "666", "555", "444", "333", "222", "111", "000"};

    public String largestGoodInteger(String num) {
        for (int i = 0; i < 10; i++) {
            if (num.contains(nums[i])) {
                return nums[i];
            }
        }

        return "";
    }
}
