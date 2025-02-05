package Greedy;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2024/09/03
 * @file M2708_一个小组的最大实力值.java
 * <p>
 * 思路1 贪心
 * 本质在找绝对值最大的数做乘积，负数则需要两两配对来消掉负号
 * <p>
 * Failed Test Case:
 * [8,6,0,5,-4,-8,-4,9,-1,6,-4,8,-5]
 * i < n && num <= 0 这里<= 0需要=号，否则结果为0
 * [0, -1] 需要标志位flag判断ans是否被修改过
 * [-9] 特判
 * <p>
 * 思路2@灵茶山艾府
 * DP，不太好想
 * 一次遍历，每个元素考虑选或不选
 * 维护最小乘积mn、最大乘积mx
 * 假设当前元素为num，分类讨论如下：
 * 1) 不选
 * mn，mx均不变
 * 2) 单元素数组
 * 特判num[0]
 * 3) 选，num < 0
 * mn * num 为最大乘积
 * mx * num 为最小乘积
 * 4) 选，num == 0
 * 特判skip
 * 5) 选，num > 0
 * mn * num 为最小乘积
 * mx * num 为最大乘积
 * <p>
 * 综合1、2、3、5，有：
 * mn = min(mn, num, mx * num, mn * num)
 * mx = max(mx, num, mx * num, mn * num)
 * <p>
 * 为去掉标志位（处理情况4）的判断，初始值置nums[0]
 */
public class M2708_一个小组的最大实力值 {
    public long maxStrength(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int cnt = 0;
        for (int num : nums) {
            cnt += num < 0 ? 1 : 0;
        }
        Arrays.sort(nums);
        long ans = 1L;
        int i = 0;
        boolean flag = false;
        cnt = cnt % 2 == 0 ? cnt : cnt - 1;
        while (cnt-- > 0) {
            ans *= nums[i++];
            flag = true;
        }
        while (i < n && nums[i] <= 0) {
            i++;
        }
        while (i < n) {
            ans *= nums[i++];
            flag = true;
        }

        return flag ? ans : 0;
    }

    public long maxStrength2(int[] nums) {
        int n = nums.length;
        long mn = nums[0], mx = mn, t, s;
        for (int i = 1; i < n; i++) {
            t = mn;
            s = nums[i];
            mn = Math.min(Math.min(mn, s), Math.min(mn * s, mx * s));
            mx = Math.max(Math.max(mx, s), Math.max(t * s, mx * s));
        }

        return mx;
    }
}
