package Y2013A;

/**
 * @author Hyper
 * @date 2022/03/13
 * 快速排序变体：单 双 三指针
 * 确定主元，left right p
 * <p>
 * 可考虑全0的特殊情况，此时p必须递增，否则无限循环
 */
public class Q5三步排序 {
    public static void main(String[] args) {
        int[] nums = new int[]{25, 18, -2, 0, 16, -5, 33, 21, 0, 19, -16, 25, -3, 0};
        sort(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }

    static void sort(int[] x) {
        int p = 0;
        int left = 0;
        int right = x.length - 1;

        while (p <= right) {
            if (x[p] < 0) {
                int t = x[left];
                x[left] = x[p];
                x[p] = t;
                left++;
                p++;
            } else if (x[p] > 0) {
                int t = x[right];
                x[right] = x[p];
                x[p] = t;
                right--;
            } else {
                p++; // 代码填空位置
            }
        }
    }
}
