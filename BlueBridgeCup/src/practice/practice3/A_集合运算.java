package practice.practice3;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author Hyperspace
 * @date 2022/02/28
 */
public class A_集合运算 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int n = in.nextInt();
        in.nextLine();
        int[] nums1 = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = in.nextInt();
        }
        in.nextLine();
        int m = in.nextInt();
        int[] nums2 = new int[m];
        for (int i = 0; i < m; i++) {
            nums2[i] = in.nextInt();
        }

        Set<Integer> intersection = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums1[i] == nums2[j]) {
                    intersection.add(nums1[i]);
                }
            }
        }
        Object[] arr = intersection.toArray();
        Arrays.sort(arr);

        int len = arr.length;
        for (int i = 0; i < len; i++) {
            out.print(arr[i] + " ");
            if (i == len - 1) {
                out.println();
            }
        }

        Set<Integer> union = new HashSet<>();
        for (int num : nums1) {
            if (!union.contains(num)) {
                union.add(num);
            }
        }
        for (int num : nums2) {
            if (!union.contains(num)) {
                union.add(num);
            }
        }

        Object[] arr2 = union.toArray();
        Arrays.sort(arr2);

        int len2 = arr2.length;
        for (int i = 0; i < len2; i++) {
            out.print(arr2[i] + " ");
            if (i == len2 - 1) {
                out.println();
            }
        }

        List<Integer> list = new ArrayList<>();
        List<Integer> complement = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(nums2[i]);
        }
        for (int j = 0; j < n; j++) {
            if (list.indexOf(nums1[j]) == -1) {
                complement.add(nums1[j]);
            }
        }
        Collections.sort(complement);
        int len3 = complement.size();
        for (int i = 0; i < len3; i++) {
            out.print(complement.get(i) + " ");
        }

        in.close();
        out.close();
    }
}
