package Array;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2024/09/26
 * @file M2535_数组元素和与数字和的绝对差.java
 */
public class M2535_数组元素和与数字和的绝对差 {
    public int differenceOfSum(int[] nums) {
        int s1 = Arrays.stream(nums).sum(), s2 = 0;
        for (int num : nums) {
            while (num > 0) {
                s2 += num % 10;
                num /= 10;
            }
        }
        return s1 >= s2 ? s1 - s2 : s2 - s1;
    }
}
