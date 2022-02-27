package Array;

/**
 * @author Hyperspace
 * @date 2022/02/27
 * <p>
 * 思路
 * 1. 贪心
 * 问题实质上等价于找到最小的除数，使得商最大
 * 就转化为了字符串的处理问题
 * 因此只要为第一个元素（被除数）后的所有元素加上括号
 * 即可使得得到的结果最大
 * 注：当除数为1（即数组的总长度为2）时，应当保证没有冗余的括号
 */
public class M553_最优除法 {
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        StringBuilder sb = new StringBuilder();
        if (n == 1) {
            return sb.append(nums[0]).toString();
        }
        if (n == 2) {
            return sb.append(nums[0]).append("/").append(nums[1]).toString();
        }

        sb.append(nums[0]).append("/(");
        for (int i = 1; i < n - 1; i++) {
            sb.append(nums[i]).append("/");
        }
        sb.append(nums[n - 1]).append(")");

        return sb.toString();
    }
}
