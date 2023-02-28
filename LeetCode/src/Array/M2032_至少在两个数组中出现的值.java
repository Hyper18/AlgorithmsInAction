package Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Hyperspace
 * @date 2022/12/29
 * @file M2032_至少在两个数组中出现的值.java
 * <p>
 * 思路
 * 模拟
 */
public class M2032_至少在两个数组中出现的值 {
    Set<Integer> set = new HashSet<>();

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> res = new ArrayList<>();
        getNum(nums1, nums2);
        getNum(nums1, nums3);
        getNum(nums2, nums3);

        res.addAll(set);
        return res;
    }

    public void getNum(int[] arr1, int[] arr2) {
        for (int a : arr1) {
            for (int b : arr2) {
                if (a == b) {
                    set.add(a);
                }
            }
        }
    }

    final int N = 110;

    public List<Integer> twoOutOfThree2(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> res = new ArrayList<>();
        boolean[] f1 = new boolean[N], f2 = new boolean[N], f3 = new boolean[N];

        for (int n : nums1) {
            f1[n] = true;
        }
        for (int n : nums2) {
            f2[n] = true;
        }
        for (int n : nums3) {
            f3[n] = true;
        }
        for (int i = 1; i <= 100; i++) {
            if ((f1[i] && f2[i]) || (f1[i] && f3[i]) || (f2[i] && f3[i])) {
                res.add(i);
            }
        }

        return res;
    }
}
