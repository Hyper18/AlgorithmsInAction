package Array;

/**
 * @author Hyper
 * @date 2024/10/10
 * @file M3162_优质数对的总数I.java
 */
public class M3162_优质数对的总数I {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int ans = 0;
        for (int x : nums1) {
            for (int y : nums2) {
                if (x % (y * k) == 0) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
