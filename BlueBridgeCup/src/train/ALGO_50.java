package train;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Hyper
 * @date 2022/03/02
 * <p>
 * 思路
 * treeSet去重，并强转char处理在英文字符区间对应的ascii码数值
 */
public class ALGO_50 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int n = in.nextInt();
        int b = in.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);

        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            if (num % b != 0) {
                set.add(num);
            }
        }

        for (int num : set) {
            if (isLetter(num)) {
                out.print((char) num + " ");
            } else {
                out.print(num + " ");
            }
        }

        in.close();
        out.close();
    }

    private static boolean isLetter(int n) {
        if ((n >= 'a' && n <= 'z') || (n >= 'A' && n <= 'Z')) {
            return true;
        }
        return false;
    }
}
