package train;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author Hyper
 * @date 2022/03/01
 * <p>
 * 思路
 * set去重+sort
 * 注：注意hashset的默认排列
 * 2. 直接采用treeSet，优化复杂度
 */
public class ALGO_39 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);

        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
            }
        }

        for (int num : set) {
            out.println(num);
        }

        in.close();
        out.close();
    }

    public static void main2(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
            }
        }

        int[] res = new int[set.size()];
        int k = 0;
        for (int num : set) {
            res[k++] = num;
        }

        Arrays.sort(res);
        for (int i = 0; i < res.length; i++) {
            out.println(res[i]);
        }

        in.close();
        out.close();
    }
}
