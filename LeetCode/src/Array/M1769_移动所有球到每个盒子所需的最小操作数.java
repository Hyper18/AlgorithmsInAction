package Array;

/**
 * @author Hyper
 * @date 2022/12/02
 * @file M1769_移动所有球到每个盒子所需的最小操作数.java
 * <p>
 * 思路
 * 模拟，两次遍历
 */
public class M1769_移动所有球到每个盒子所需的最小操作数 {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] res = new int[n];
        for (int i = 1, cnt = 0, sum = 0; i < n; i++) {
            if (boxes.charAt(i - 1) == '1') {
                cnt++;
            }
            sum += cnt;
            res[i] += sum;
        }
        for (int i = n - 2, cnt = 0, sum = 0; i >= 0; i--) {
            if (boxes.charAt(i + 1) == '1') {
                cnt++;
            }
            sum += cnt;
            res[i] += sum;
        }

        return res;
    }
}
