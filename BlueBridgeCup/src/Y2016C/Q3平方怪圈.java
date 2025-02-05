package Y2016C;

/**
 * @author Hyper
 * @date 2022/03/29
 * <p>
 * 平方怪圈
 * <p>
 * 如果把一个正整数的每一位都平方后再求和，得到一个新的正整数。
 * 对新产生的正整数再做同样的处理。
 * <p>
 * 如此一来，你会发现，不管开始取的是什么数字，
 * 最终如果不是落入1，就是落入同一个循环圈。
 * <p>
 * 请写出这个循环圈中最大的那个数字。
 * <p>
 * 请填写该最大数字。
 * 注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。
 */
public class Q3平方怪圈 {
    public static void main(String[] args) {
        int n = 34;
        int[] res = new int[100];
        for (int i = 0; i < 100; i++) {
            int sum = 0;
            while (n > 0) {
                int tmp = n % 10;
                sum += tmp * tmp;
                n /= 10;
            }
            res[i] = sum;
            n = sum;
        }

        int max = Integer.MIN_VALUE;
        for (int i : res) {
            max = Math.max(max, i);
        }

        System.out.println(max);
    }
}
