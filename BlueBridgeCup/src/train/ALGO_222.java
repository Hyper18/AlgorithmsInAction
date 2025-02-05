package train;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Hyper
 * @date 2022/03/02
 * <p>
 * 双指针
 * 这个题设计swap不是给java用的。。
 */
public class ALGO_222 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int[] nums = new int[20];
        int idx = 0;
        while (true) {
            int num = in.nextInt();
            if (num == 0) {
                break;
            }
            nums[idx++] = num;
        }

        int start = 0;
        int end = idx - 1;
        while (start < end) {
            int tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }

        for (int i = 0; i < idx; i++) {
            if (i == idx - 1) {
                out.print(nums[i]);
                break;
            }
            out.print(nums[i] + " ");
        }

        in.close();
        out.close();
    }
}
