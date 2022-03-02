package train;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2022/03/02
 * <p>
 * 注意数组下标
 */
public class ALGO_75 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }

        int cnt = 1;
        int step = 0;
        int outNum = 1;
        while (cnt < n) {
            step++;
            if (step == n) {
                step = 0;
            }
            if (nums[step] != -1) {
                outNum++;
            }
            if (outNum == 3) {
                nums[step] = -1;
                outNum = 0;
                cnt++;
            }
        }

        out.println(Arrays.stream(nums).max().getAsInt());

        in.close();
        out.close();
    }
}
