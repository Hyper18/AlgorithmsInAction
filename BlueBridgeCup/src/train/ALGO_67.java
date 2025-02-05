package train;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hyper
 * @date 2022/03/01
 * <p>
 * 思路
 * 1. 流
 * 2. 遍历
 */
public class ALGO_67 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int[] nums = new int[11];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }

            if (nums[i] > max) {
                max = nums[i];
            }
        }

        out.print(max + " " + min);

        in.close();
        out.close();
    }

    public static void main2(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int[] nums = new int[11];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
        }

        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();

        out.print(max + " " + min);

        in.close();
        out.close();
    }

}
