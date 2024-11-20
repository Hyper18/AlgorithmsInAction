package Week20;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author Hyperspace
 * @date 2024/11/19
 * @file Q123_滑动窗口最大值.java
 * <p>
 * 题目描述
 * 给定一个整数数组 nums 和一个整数 k，k 表示滑动窗口的大小。
 * 你需要找出每个滑动窗口中的最大值与最小值的差，并返回这些差的最大值。
 * <p>
 * 输入描述
 * 数组的长度为 n，1 <= n <= 10000，
 * 数组中的每个元素范围为[-10000,10000]，
 * 滑动窗口大小k的范围为[1,n]。
 * <p>
 * 输出描述
 * 例如，给定一个字符串 "nums = [1,3,-1,-3,5,3,6,7], k = 3"，表示一个数组和窗口大小 k。
 * 对于该数组中的每个窗口，计算最大值与最小值的差，并返回这些差值中的最大值。
 * 在这个例子中，每个窗口的最大值与最小值的差分别为 [4, 6, 8, 8, 3, 4]，因此最终返回的结果是 8。
 */
public class Q123_滑动窗口最大值2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] numsArr = s.substring(s.indexOf("[") + 1, s.indexOf("]")).split(",");
        int[] nums = new int[numsArr.length];
        for (int i = 0; i < numsArr.length; i++) {
            nums[i] = Integer.parseInt(numsArr[i].trim());
        }
        int k = Integer.parseInt(s.substring(s.lastIndexOf("=") + 1).trim());
        int n = nums.length;
        TreeSet<Integer> st = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            st.add(nums[i]);
        }
        int ans = st.last() - st.first();
        for (int l = 0, r = k; r < n; r++) {
            st.remove(nums[l++]);
            st.add(nums[r]);
            ans = Math.max(ans, st.last() - st.first());
        }
        System.out.println(ans);
    }
}
